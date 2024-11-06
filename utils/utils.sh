#!/bin/bash
set -e

install_gcloud_cli(){
  echo '--- Install gcloud: start ---'

  if ! command -v gcloud &> /dev/null; then
    curl https://sdk.cloud.google.com > /tmp/install.sh
    bash /tmp/install.sh --disable-prompts
  else
    echo 'gcloud already exists! skipping...'
  fi

  echo '--- Install gcloud: end ---'
  echo
}