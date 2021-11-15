#!/bin/bash
echo '============================================'
echo
echo 'Cleaning old builds... '
gradle -q clean
rm -fr .gradle
echo 'Done.'
echo
echo '============================================'
echo
echo 'Building the project... '
gradle -q build
echo 'Done.'
echo
echo '============================================'
echo

echo '3 + 5' | gradle -q :task1:run
echo '12 - 3 * 5' | gradle -q :task2:run
echo '13 - (4 + 7) + 2 * 2' | gradle -q :task3:run
echo
echo 'If the numbers above are 8, -3, 6 then tests passed.'
