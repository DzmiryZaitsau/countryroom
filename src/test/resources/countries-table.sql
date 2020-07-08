drop table if exists countries cascade;
create table  countries (
                       id int (10) AUTO_INCREMENT,
                       name varchar(20) NOT NULL,
                       PRIMARY KEY (id)
);