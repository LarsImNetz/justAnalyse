#!/bin/bash

EXPECTED="Das soll weitergeleitet werden"
RESULT=$(./pipe.sh 2>/dev/null | ./result.sh - )

if [ "$RESULT" != "$EXPECTED" ]; then
    echo "ERROR:  $RESULT ist nicht 'wie erwartet'"
    echo "Expect: $EXPECTED"
    exit 1
fi
