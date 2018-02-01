#!/bin/sh

if [ -e target/Single-Server-Main-Application-jar-with-dependencies.jar ]; then
    java -jar target/Single-Server-Main-Application-jar-with-dependencies.jar
else
    echo "File to start not found."
fi
