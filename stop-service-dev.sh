#!/usr/bin/env bash

# start service
docker-compose -p resource \
  -f "./src/main/docker/docker-compose.yml" \
  -f "./src/main/docker/docker-compose-dev.yml" \
  down