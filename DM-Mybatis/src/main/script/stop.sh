#!/bin/bash
ps -ef|grep DM-Mybatis-1.0-SNAPSHOT.jar|grep -v grep|awk '{print $2}'|xargs kill -9