#!/bin/bash

cd /mongoconfig

nohup mongod --config config/mongod_el.cfg &

sleep 6

mongo --eval 'rs.initiate()'

/bin/bash
