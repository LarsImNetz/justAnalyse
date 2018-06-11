#!/bin/sh

if [ -e target/javax-mail-Application-jar-with-dependencies.jar ]; then
    java -jar target/javax-mail-Application-jar-with-dependencies.jar
else
    echo "File target/javax-mail-Application-jar-with-dependencies.jar to start not found."
fi
