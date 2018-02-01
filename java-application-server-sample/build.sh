#!/bin/sh

mvn -q clean
# mvn clean install
# mvn assembly:single
# mvn package
mvn verify

if [ $? -ne 0 ]; then
    echo "Build failed."
else
    echo "To start, call ./run.sh"
fi
