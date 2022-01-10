create database if not exists AMV;
use AMV;
create table if not exists orderTable
(
    OrderTable_id   smallint auto_increment,
    OrderTable_date date not null,
    User_id         smallint,

    primary key (OrderTable_id),
    # On delete set null = denne verdien i tilhørende tabell vil bli satt til null dersom den fjernes.
    foreign key (User_id) references user (User_id) on delete set null
);


insert into orderTable (OrderTable_date,
                        User_id)

values ('2022-10-21', 1);
