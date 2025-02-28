CREATE DATABASE IF NOT EXISTS board_springboot
CHARACTER SET = 'utf8mb4'
COLLATE = 'utf8mb4_unicode_ci';

-- 데이터베이스 선택
USE board_springboot;

-- 테이블 생성
DROP TABLE IF EXISTS boards;
DROP TABLE IF EXISTS password_change_logs;
DROP TABLE IF EXISTS login_logs;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_no INT AUTO_INCREMENT PRIMARY KEY,
                       user_id varchar(255) NOT NULL ,
                       user_name VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       phone_no varchar(255) NOT NULL
);


CREATE TABLE boards (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_no INT NOT NULL,
    user_name VARCHAR(255) NOT NULL ,
    FOREIGN KEY (user_no) REFERENCES users(user_no)

);

CREATE TABLE login_logs(
    login_log_id INT AUTO_INCREMENT PRIMARY KEY ,
    created_at TIMESTAMP DEFAULT  CURRENT_TIMESTAMP,
    ip_address VARCHAR(255) NOT NULL ,
    browser VARCHAR(255) NOT NULL ,
    user_no INT NOT NULL ,
    FOREIGN KEY (user_no) REFERENCES users(user_no)

);

CREATE TABLE password_change_logs(
    change_log_id INT AUTO_INCREMENT PRIMARY KEY ,
    user_id VARCHAR(255) NOT NULL ,
    changed_password VARCHAR(255) NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);


