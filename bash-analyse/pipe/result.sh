#!/bin/bash

if [ $# -eq 1 -a "$1" == "-" ]; then
    read -t 1 RESULT
else
    echo "Parameter: $#"
    exit 1
fi

echo $RESULT
