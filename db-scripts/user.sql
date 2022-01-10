# Oppretter database hvis den ikke eksisterer
create database if not exists AMV;
# Bruker AMV (opprettet database)
use AMV;
# Lager hvis ikke eksisterer
create table if not EXISTS user
(
    #Attributter, type og constraints
    User_id          smallint auto_increment,
    User_firstName   nvarchar(255) not null,
    User_lastName    nvarchar(255) not null,
    User_phoneNumber nvarchar(255) not null,
    User_password    nvarchar(255) not null,
    User_isAdmin     boolean       not null,
    primary key (User_id)
);


# Inserter en record av en bruker inn i tabellen user.
insert into user (User_firstName,
                  User_lastName,
                  User_phoneNumber,
                  User_password,
                  User_isAdmin)

#values ('Ingvar', 'Pedersen', '48995885', 'password', false);
values ('Kari', 'Nordmann', '12345678', 'test', true);
#values ('Kenneth', 'Sirnes', '99753539', 'password', false);
#values ('Frank', 'Welde', '93008604', 'password', true);
#values ('Allan', 'Mikkelsen', '91624858', 'password', true);
#values ('Johnny', 'Træland', '95735786', 'password', true);

