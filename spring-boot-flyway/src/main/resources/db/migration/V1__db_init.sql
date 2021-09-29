CREATE SEQUENCE seq_users start 1 increment 1;

CREATE TABLE users (
    id bigint NOT NULL default nextval('seq_users'),
    userName varchar(100) NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) DEFAULT NULL,
    PRIMARY KEY (id)
);