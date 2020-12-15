#!/bin/bash

PWDPATH=`dirname $0`
DMDEMO_HOME=`cd $PWDPATH && cd .. && pwd`
echo $DMDEMO_HOME
cd $DMDEMO_HOME
start() {
  nohup java -jar ./lib/DM-Mybatis-1.0-SNAPSHOT.jar --spring.config.location=$DMDEMO_HOME/conf/application.yml &
  echo -e '\r'
  echo "START SUCCESSFUL"
}
start
