#!/bin/bash

# EC2로 jar 파일 전송
scp -i board_spring_boot.pem target/board_springboot-0.0.1-SNAPSHOT.jar ec2-user@ec2-13-124-39-184.ap-northeast-2.compute.amazonaws.com:/home/ec2-user/

# EC2에 접속해서 deploy.sh 실행
ssh -i board_spring_boot.pem ec2-user@ec2-13-124-39-184.ap-northeast-2.compute.amazonaws.com "./deploy.sh"
