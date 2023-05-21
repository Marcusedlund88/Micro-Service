create table customer(id Long NOTll, name varchar(255), ssn varchar(255),
primary key (id)) engine=InnoDB;
create table customer_seq (next_val bigint) engine=InnoDB;
insert into customer_seq values ( 1 );