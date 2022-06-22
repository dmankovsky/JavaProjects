create table if not exists location (
    id bigint not null auto_increment,
    name varchar(100),
    address varchar(255),
    primary key (id)
);