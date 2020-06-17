#!/bin/bash
# This is a shell test file!
echo "This line printing from scripts/ jenkins-bootstrap-submetadata file"	# This is demo!
echo "$SL_USERNAME"
echo "$SL_API_KEY"
echo "$hostnames"
echo "parm hostnames: $hostnames"

a='Hello'
b='World'
c="${a} ${b}"
echo "${c}"

file="./data.txt"
while IFS= read -r line
do
        # display $line or do somthing with $line
	printf '%s\n' "$line"
done <"$file"
touch data2.txt
hostfile="./data2.txt"
while IFS= read -r line
do
        # display $line or do somthing with $line
	printf '%s\n' "$line"
done <"$hostfile"
