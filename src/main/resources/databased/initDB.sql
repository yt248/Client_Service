create table clients
(
    id      int auto_increment not null,
    name    varchar(32)        not null,
    surname varchar(32)        not null,
    primary key (id)
);

create table orders
(
    number_order int          not null auto_increment,
    description  varchar(120) not null,
    sum          double       not null,
    client_id    int,
    primary key (number_order),
    foreign key (client_id) references clients (id)
);
