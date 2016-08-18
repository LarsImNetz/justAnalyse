# Diese Datei bitte nur mittels "source" includen

function executeSql {

  local SQL=${1:-;}
  if [ -z ${DB_PASS} ]; then
	  echo $MYSQL_EXE -u${DB_USER} -h${DB_HOST} ${DATABASE} -e "${SQL}"
	  $MYSQL_EXE -u${DB_USER}              -h${DB_HOST} ${DATABASE} -e "${SQL}"
  else
	  echo $MYSQL_EXE -u${DB_USER} -p${DB_PASS} -h${DB_HOST} ${DATABASE} -e "${SQL}"
	  $MYSQL_EXE -u${DB_USER} -p${DB_PASS} -h${DB_HOST} ${DATABASE} -e "${SQL}"
  fi
  FAILURE=$?
  if [ $FAILURE -ne 0 ]; then
	  echo "ERROR: DB"
  fi
}
