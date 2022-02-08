#!/bin/bash

RUNNER=$(ls *-runner.jar)

while ! nc -z proddb 5432; do
    echo "waiting for godot..."
    sleep 1
done

while ! nc -z studentdb 5433; do
    echo "waiting for studentdb..."
    sleep 1
done

echo "echo db is available, starting quarkus $RUNNER..."
java -Dquarkus.profile=prod -jar $RUNNER
