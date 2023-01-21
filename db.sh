#!/bin/bash

arg="$1"

container_name="snippets-db"
db_name="snippets"
db_user="snippets"
db_password="snippets"

if [ "$arg" = "-r" ] || [ "$arg" = "--reset" ]; then

    docker rm "$container_name" --force

fi

if docker inspect "$container_name" &>/dev/null; then

    docker start "$container_name"

else

    docker run -d \
        --name "$container_name" \
        -p 5432:5432 \
        -e POSTGRES_USER="$db_user" \
        -e POSTGRES_PASSWORD="$db_password" \
        -e POSTGRES_DB="$db_name" \
        postgres

fi
