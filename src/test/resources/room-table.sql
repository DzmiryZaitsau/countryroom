drop table if exists rooms cascade;
create table  rooms (
                       id int (10) AUTO_INCREMENT,
                       name varchar(20) NOT NULL,
                       lamp_is_on BOOLEAN,
                       country_id int(10),
                       PRIMARY KEY (id)
);