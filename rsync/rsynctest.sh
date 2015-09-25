#!/bin/sh

cd /tmp

# preconditions
rm -rf a
rm -rf b

mkdir -p a/c/asterix
touch a/ich
touch a/nicht
touch a/c/nicht
touch a/c/nicht_doch
touch a/asterix
touch a/c/asterix/obelix

mkdir -p b/c
touch b/bleibt
touch b/c/bleibt
touch b/kommt_weg

cat >.rsyncignore <<__EOF__
nicht
/bleibt
asterix/*
__EOF__

# Erkenntnisse:
# 'nicht' wird ignoriert, also nicht von a nach b geschoben
# 'nicht_doch' wird kopiert, weil es nicht zum 'nicht' Pattern passt
# 'bleibt' wird ignoriert, es wird in b nicht geloescht
# 'b/c/bleibt' wird geloescht, weil es nicht zum '/bleibt' Pattern passt
# 'asterix/*' das Verzeichnis wird angelegt, aber ist leer
# 'asterix' die Datei wird mit kopiert, asterix/* ist ein Directory Pattern

echo "---- rsync ----"


rsync --verbose --delete --recursive --exclude-from='.rsyncignore' a/ b

# check rsync result
if [ ! -e b/ich ]; then
        echo "FAIL! b/ich existiert nicht!"
fi

if [ -e b/c/nicht ]; then
        echo "FAIL! b/c/nicht existiert, sollte ignoriert werden!"
fi

if [ ! -e b/c/nicht_doch ]; then
        echo "FAIL! b/c/nicht_doch existiert nicht!"
fi

if [ -e b/kommt_weg ]; then
        echo "FAIL! b/kommt_weg existiert, sollte aber geloescht werden!"
fi

if [ -e b/nicht ]; then
        echo "FAIL! /nicht sollte ausgelassen werden"
fi

if [ ! -e b/bleibt ]; then
        echo "FAIL! b/bleibt wurde entfernt!"
fi

if [ -e b/c/bleibt ]; then
    echo "FAIL! b/c/bleibt sollte geloescht werden."
fi

if [ ! -e b/asterix ]; then
    echo "FAIL! b/asterix fehlt!"
fi

if [ ! -d b/c/asterix ]; then
    echo "FAIL! b/c/asterix directory should create but should empty"
fi
