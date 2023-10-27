#!/bin/bash

function build() {
  local -a COMMITTED_FILES
  COMMITTED_FILES=$(git diff --name-only --diff-filter=DCM $CI_COMMIT_SHA origin/$CI_MERGE_REQUEST_TARGET_BRANCH_NAME)
  if [ -z "$COMMITTED_FILES" ]; then
      return
  fi
  local -a check_files
  for dir in $COMMITTED_FILES; do
      if [[ $dir =~ ${JAVA_MAIN_SOURCE} ]]; then
        #如果不是 则跳过剩下的步骤
        check_files+=("$REPOSITORY_FULL_PATH/"${dir})
      fi
  done
  if [ -z "$check_files" ]; then
      return
  fi
  S=$(IFS=' '; echo "${check_files[*]}")
  echo $S
}

build "$@"
