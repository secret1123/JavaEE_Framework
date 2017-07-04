DROP DATABASE IF EXISTS db_test;
CREATE DATABASE db_test;

DROP TABLE IF EXISTS db_test.user;
CREATE TABLE db_test.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT '',
  username VARCHAR(255) COMMENT '',
  password VARCHAR(255) COMMENT ''
)
  COMMENT '';

SELECT *
FROM db_test.user;