#!/bin/bash

echoerr() { echo "$@" 1>&2; }

echo "Das soll so weitergeleitet werden"
echoerr "Das soll nicht ankommen"
