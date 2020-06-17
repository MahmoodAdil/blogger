#!/bin/bash
# This is a shell test file!
echo "This line printing from scripts/ jenkins-bootstrap-submetadata file"	# This is demo!
echo "$SL_USERNAME"
echo "$SL_API_KEY"
echo "$hostnames"
echo "parm hostnames: $hostnames"

export PYTHON_VERSION="3.8"

# check job params
if [ "${SL_USERNAME}" == "" ]; then
  echo "Error: Missing SL_USERNAM param"
  exit 1
fi
