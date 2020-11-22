#!/bin/bash

shopt -s extglob

if mv data/unused/*.txt data/ 2> /dev/null; then
    echo "Moved from unused to data"
else
    # mv all but 00-04.txt
    (mv data/!(0[0-4]|solution|merged).txt data/unused/ 2> /dev/null) || true
    echo "Moved from data to unused"
fi