#!/bin/sh

mvn -q clean package
# mvn clean install

if [ $? -eq 0 ]; then
    java -jar target/TestExternalProgram.jar
else
    echo "Build failed."
fi
