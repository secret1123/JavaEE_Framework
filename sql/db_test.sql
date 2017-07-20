DROP DATABASE IF EXISTS db_test;
CREATE DATABASE db_test;

DROP TABLE IF EXISTS db_test.user;
CREATE TABLE db_test.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  username VARCHAR(191) UNIQUE
  COMMENT '用户名',
  password VARCHAR(255) COMMENT '密码',
  lastTime DATETIME
  COMMENT '登录时间'
)
  COMMENT '用户表';

DROP TABLE IF EXISTS db_test.book;
CREATE TABLE db_test.book (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  title  VARCHAR(255)  NOT NULL
  COMMENT '书名',
  author VARCHAR(255)  NOT NULL
  COMMENT '作者',
  date   DATE          NOT NULL
  COMMENT '出版日期',
  price  DECIMAL(6, 2) NOT NULL
  COMMENT '定价'
)
  COMMENT '图书表';

DROP TABLE IF EXISTS db_test.student;
CREATE TABLE db_test.student (
  id      INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  name    VARCHAR(191) NOT NULL UNIQUE
  COMMENT '姓名',
  age     INT COMMENT '年龄',
  height  DOUBLE COMMENT '身高',
  married VARCHAR(255) COMMENT '婚否'
)
  COMMENT '学生表';

DROP TABLE IF EXISTS db_test.demo;
CREATE TABLE db_test.demo (
  id   INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  name VARCHAR(191) NOT NULL UNIQUE
  COMMENT '姓名'
)
  COMMENT '测试表';

TRUNCATE TABLE db_test.user;

SELECT *
FROM db_test.user;

SELECT *
FROM db_test.book;

SELECT *
FROM db_test.student;

SELECT *
FROM db_test.demo;