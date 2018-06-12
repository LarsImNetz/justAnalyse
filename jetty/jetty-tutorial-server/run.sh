#!/bin/bash

if [ -e target/SingleMainApplication.jar ]; then
	java -jar target/SingleMainApplication.jar
else
	echo "noch nicht gebaut?"
fi	
