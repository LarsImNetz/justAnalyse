#!/bin/sh

if [ -e target/Single-Server-Main-Application.jar ]; then
    java -jar target/Single-Server-Main-Application.jar
else
    echo "File target/Single-Server-Main-Application.jar to start not found."
fi
