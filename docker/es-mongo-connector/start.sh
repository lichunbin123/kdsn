#!/bin/sh

mongo-connector -m ${MONGO_URL} -t ${ES_URL} -d elastic2_doc_manager

/bin/bash
