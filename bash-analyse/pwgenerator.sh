#!/bin/bash

# erstellt mit Hilfe einer CSV Datei eine Liste von Kennwörtern und Hashes
#
# Die Kennwörter enthalten nur Buchstaben und Zahlen und einen '_' Unterstrich,
# aber kein großes I und kein kleines L.
#
# Zum Verstehen einfach mal starten.
#
# Hinweis:
# Eigentlich sollten bereits bekannte Usernamen mit Hilfe eines Arrays zu
# immer gleichen Kennwörtern führen, leider scheint die Bash hier einen Fehler
# zu haben
#


# DATEI=Uebersicht_Zugänge_BI_PartnerVoll.csv
DATEI=test.csv
DESTFILE=passwords.csv
SQLFILE=passwords.sql

rm -f $DESTFILE
rm -f $SQLFILE

declare -a userarray
declare -a pwarray

function exists_username() {
  local i
  for i in ${userarray[@]} ; do
      if [ "$i" = "$1" ]; then
          echo "1"
          # break
      fi
  done
}

function getpassword() {
  local USERNAME=${1}
  declare -i count
  local count=${#userarray[@]}
  declare -i i
  local i
  for ((i=0; i < $count; i++ )); do
    if [ "${userarray[$i]}" == "$USERNAME" ]; then
      echo "${pwarray[$i]}"
    fi
  done
}

function eintragen() {
    local USERNAME=$1
    local PASSWD=$2

    local count=${#userarray[@]}
    userarray[${count}]=${USERNAME}
    pwarray[${count}]=${PASSWD}
}

function createNewPassword() {
    local USERNAME=$1
    local passwd
    if [ "$(exists_username ${USERNAME})" ]; then
        passwd=$(getpassword ${USERNAME})
    else
      local pwlength=10
      passwd=$(tr -dc 'A-HJ-Za-km-z1-9_' < /dev/urandom | head -c $pwlength | xargs )
      eintragen ${USERNAME} ${passwd}
    fi
    echo "$passwd"
  }

function createHash() {
  local passwd=$1
  local hashedpasswd=$(echo -n "$passwd" | md5sum | head -c 32 | xargs)
  echo "$hashedpasswd"
}

# lese die gesamte DATEI zeilenweise ein
# an 6ter Stelle stehen die Usernamen, nimm diese, generiere dafür ein Passwort
# generiere zusätzlich einen Hash aus dem Passwort

while read line; do
  # CR entfernen
  line="${line%$'\r'}"

  USERNAME=$(echo -n $line | awk -F ';' '{print $6;}' )

  # trim multiple spaces afterward
  USERNAME=${USERNAME%% *}
  USERNAME=${USERNAME#* }

  # echo "'$USERNAME'"
  if [ -n "$USERNAME" ]; then
    PASSWD=$(createNewPassword "${USERNAME}")
    HASHEDPASSWORD=$(createHash ${PASSWD})

    echo "$USERNAME;$PASSWD;$HASHEDPASSWORD"
    echo "$USERNAME;$PASSWD;$HASHEDPASSWORD" >>$DESTFILE

    echo "INSERT INTO USERS (username, password) VALUES ('$USERNAME','$HASHEDPASSWORD');" >>$SQLFILE

  else
    echo ""
    echo "" >>$DESTFILE
  fi
done < $DATEI
