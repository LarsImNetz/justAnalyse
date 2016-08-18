#!/bin/bash

# [[ "$OS" != "Windows_NT" ]] && echo "This script need Windows NT environment to run, must quit!" && exit 1

EASYPHP=
DB_USER=root
DB_PASS=
DB_HOST=localhost
if [ "$OSTYPE" == "linux-gnu" ]; then
    HOSTNAME=$(hostname)
    if [ "$HOSTNAME" == "moon64" ]; then
	DB_PASS=meister
    else
	DB_PASS=murphy
    fi
fi
DATABASE=mysql

SCRIPTDIR=$( dirname $0 )
source ${SCRIPTDIR}/_searchEasyPhp.sh
source ${SCRIPTDIR}/_executeSql.sh

if [ "$OS" == "Windows_NT" ]; then
#	if [ -e "/c/xampp/mysql/bin/mysql.exe" ]; then
#		MYSQL_EXE=/c/xampp/mysql/bin/mysql.exe
#	else
    MYSQL_EXE=$(find $EASYPHP -type f -iname 'mysql.exe')
    
    if [ -z "$MYSQL_EXE" ]; then
	echo "not found MySQL Executable, must quit!"
	exit 3
    else
	echo " found MySQL Executable in: $MYSQL_EXE"
    fi
    #	fi
else
    # echo "This script need Windows NT environment to run, must quit!"
    # exit 1
    MYSQL_EXE=$(which mysql)
fi

# export LIBMYSQL_ENABLE_CLEARTEXT_PLUGIN=1
# MYSQL_PATH=$(dirname $MYSQL_EXE)
# $MYSQL_PATH/mysqlcheck.exe --check-upgrade --all-databases  -u root



echo "clean DB"
if [ "$OS" == "Windows_NT" ]; then
    executeSql "drop user ''@'localhost';"
fi
executeSql "drop user 't4user'@'%';"
executeSql "drop user 't4user'@'localhost';"
# executeSql "drop user 't3user'@'127.0.0.1';"
# executeSql "drop user 't3user'@'localhost';"
executeSql "flush privileges;"
executeSql "drop database web2;"


# MYSQLUSER=$(executeSql "select user,host from user where user='t4user'");
# echo "mysql user: $MYSQLUSER"

echo "init DB"
executeSql "create user 't4user'@'localhost';"
executeSql "create database web2;"
executeSql "GRANT ALL PRIVILEGES ON web2.* TO 't4user'@'localhost' WITH GRANT OPTION;"
# executeSql "ALTER USER 't4user'@'%' IDENTIFIED BY PASSWORD('mPass#10');"
# executeSql "SET old_passwords=0; SET PASSWORD FOR 't4user'@'%' = PASSWORD('passpass');"
executeSql "UPDATE user SET password=password('passpass') WHERE user='t4user';"
executeSql "flush privileges;"

executeSql "select USER(), CURRENT_USER();"
executeSql "select host,user,password,plugin,authentication_string from user;"

if [ "$OS" == "Windows_NT" ]; then
#	MYSQL_PWD=passpass
	DB_PASS=passpass
else
	DB_PASS=passpass
fi
DB_USER=t4user
DB_HOST=localhost
DATABASE=web2

executeSql "show tables;"
executeSql "show databases;"

exit
