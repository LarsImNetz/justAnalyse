#!/bin/bash

DATEI=/c/users/lars.langhans/Documents/Uebersicht_Zugänge_BI_PartnerVoll.csv
DATEI=test.csv
DESTFILE=passwords.csv
SQLFILE=passwords.sql

rm -f $DESTFILE
rm -f $SQLFILE

#set -x

userarray=
pwarray=

function exists_username() {
  local i=
  for i in ${userarray[@]}; do
    if [ "$i" == "$1" ]; then
      echo "1"
    fi
  done
}

function getpassword() {
  local USERNAME=$1
  local count=${#userarray[@]}
  local i=
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
    userarray[$count]=${USERNAME}
    pwarray[$count]=${PASSWD}
}

function createNewPassword() {
    local USERNAME=$1
    local passwd=
    if [ "$(exists_username ${USERNAME})" ]; then
        passwd=$(getpassword ${USERNAME})
    else
      local pwlength=10
      # passwd=$(tr -dc 'A-Za-z0-9_\?\.\#\!' < /dev/urandom | head -c $pwlength | xargs)
      passwd=$(tr -dc 'A-HJ-Za-km-z1-9_' < /dev/urandom | head -c $pwlength | xargs)
      # passwd="po1bi2LAR"
      eintragen ${USERNAME} ${passwd}
    fi
    echo $passwd
  }

function createHash() {
  local passwd=$1
  local hashedpasswd=$(echo -n "$passwd" | md5sum | head -c 32 | xargs)
  echo $hashedpasswd
}

function test() {
  local USER="NNT82"
  createNewPassword $USER
  createNewPassword $USER
  createNewPassword $USER

  #eintragen aa 11
  #eintragen bb 22
  #eintragen cc 33

  if [ "$(exists_username ${USER})" ]; then
    echo "existiert!"
    echo $(getpassword 'NNT82')
  else
    echo "fehlt"
  fi

  local USER=hallo
  echo $(echo ${USER}, "${USER}", '${USER}')

  exit 1
}

# test

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
  if [ -n "$USERNAME" ]; then
    PASSWD=$(createNewPassword ${USERNAME})
    HASHEDPASSWORD=$(createHash ${PASSWD})
#    echo "$USERNAME"

    echo "$USERNAME;$PASSWD;$HASHEDPASSWORD"
    echo "$USERNAME;$PASSWD;$HASHEDPASSWORD" >>$DESTFILE

    echo "INSERT INTO USERS (username, password) VALUES ('$USERNAME','$HASHEDPASSWORD');" >>$SQLFILE

  else
    echo ""
    echo "" >>$DESTFILE
  fi
done < $DATEI