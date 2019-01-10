#!/bin/bash

set -o errexit

CURRENT_DIR="$( pwd )"
SC_CONTRACT_DOCKER_VERSION="${SC_CONTRACT_DOCKER_VERSION:-2.0.2.BUILD-SNAPSHOT}"

# Stub coordinates 'groupId:artifactId:version:classifier'
STUB_GROUP="${STUB_GROUP:-com.ibm-developer}"
STUB_ARTIFACT="${STUB_ARTIFACT:-movie-service}"
STUB_VERSION="${STUB_VERSION:-0.0.1-SNAPSHOT}"
STUB_PORT="9876"

# Spring Cloud Contract Stub Runner properties
STUBRUNNER_PORT="${STUBRUNNER_PORT:-8080}"
STUBRUNNER_IDS="${STUB_GROUP}:${STUB_ARTIFACT}:${STUB_VERSION}:stubs:${STUB_PORT}"
STUBRUNNER_REPOSITORY_ROOT="git://https://github.com/wkorando/collaborative-ccd-contracts.git"

docker run  --rm -e "STUBRUNNER_IDS=${STUBRUNNER_IDS}" -e "STUBRUNNER_STUBS_MODE=LOCAL" -e "SERVER_PORT=${STUBRUNNER_PORT}" -e "STUBRUNNER_REPOSITORY_ROOT=${STUBRUNNER_REPOSITORY_ROOT}" -p "${STUBRUNNER_PORT}:${STUBRUNNER_PORT}" -p "${STUB_PORT}:${STUB_PORT}" -v "${CURRENT_DIR}/build/contracts_git/:/contracts_git:rw" springcloud/spring-cloud-contract-stub-runner:"${SC_CONTRACT_DOCKER_VERSION}"