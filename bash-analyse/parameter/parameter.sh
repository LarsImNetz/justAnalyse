#!/bin/bash

if [ $# -eq 0 ]; then
    echo "keine Parameter"
    exit 0
fi

if [ $# -eq 1 ]; then
    echo "genau ein Parameter"
    exit 0
fi

# alles ausgeben
for i in $@; do
    echo "parameter: $i"
done

# bis zum 'to' konsumieren
while [ $# -gt 0 ]; do
    echo $1
    if [ "$1" == "to" ]; then
        break
    fi
    shift
done

# alles ausgeben, was noch da ist.
for i in $@; do
    echo "parameter: $i"
done

