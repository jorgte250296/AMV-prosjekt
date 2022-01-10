# Oppretter database AMV.
create database if not exists AMV;
# Bruker den opprettede databasen.
use AMV;

# Oppretter tabell for verktøy i en ordre.
create table if not EXISTS orderItem
(
    Tool_id       smallint not null,
    OrderTable_id smallint not null,
    DateFrom      date     not null,
    DateTo        date     not null,
    OrderItem_id  smallint auto_increment not null,

    # Må settes.
    primary key (OrderItem_id),
    # Tilkobling mellom to tabeller.
    foreign key (Tool_id) references tool (tool_id) on delete cascade,
    # On delete cascade = hvis tilhørende tabell slettes, vil også denne tabellen fjernes.
    foreign key (OrderTable_id) references orderTable (OrderTable_id) on delete cascade
);

# Testdata, spesifiser hva som skal settes inn og tilhørende verdier.
insert into orderItem (Tool_id, OrderTable_id, DateTo, DateFrom)
VALUES (2, 1, '2023-02-01', '2021-01-03');

