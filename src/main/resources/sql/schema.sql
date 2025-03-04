CREATE DATABASE IF NOT EXISTS board_springboot
    CHARACTER SET = 'utf8mb4'
    COLLATE = 'utf8mb4_unicode_ci';


-- 데이터베이스 선택
USE board_springboot;

-- 테이블 생성
drop table if exists comments;
DROP TABLE IF EXISTS boards;
DROP TABLE IF EXISTS password_change_logs;
DROP TABLE IF EXISTS login_logs;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    user_no    INT AUTO_INCREMENT PRIMARY KEY,
    user_id    varchar(255) NOT NULL,
    user_name  VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    phone_no   varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE boards
(
    board_no   INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_no    INT          NOT NULL,
    FOREIGN KEY (user_no) REFERENCES users (user_no)

);

CREATE TABLE login_logs
(
    login_log_id INT AUTO_INCREMENT PRIMARY KEY,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ip_address   VARCHAR(255) NOT NULL,
    browser      VARCHAR(255) NOT NULL,
    user_no      INT          NOT NULL,
    FOREIGN KEY (user_no) REFERENCES users (user_no)

);

CREATE TABLE password_change_logs
(
    change_log_id    INT AUTO_INCREMENT PRIMARY KEY,
    user_id          VARCHAR(255) NOT NULL,
    changed_password VARCHAR(255) NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

create table comments
(
    comment_no         int auto_increment primary key not null ,
    user_no            int not null ,
    board_no           int not null ,
    comment_created_at timestamp default current_timestamp not null ,
    parent_no          int,
    comment_cont       varchar(255) not null ,
    foreign key (user_no) references users (user_no),
    foreign key (board_no) references boards (board_no),
    foreign key (parent_no) references comments (comment_no)
);




