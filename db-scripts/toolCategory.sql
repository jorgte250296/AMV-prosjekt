create database if not exists AMV;
use AMV;
create table if not EXISTS toolCategory
(
    ToolCategory_id     smallint auto_increment,
    ToolCategory       nvarchar(32) not null,

    PRIMARY KEY(ToolCategory_id)
);

insert into toolCategory (ToolCategory) value ('Utstyr og diverse');
insert into toolCategory (ToolCategory) value ('Spikerpistoler o.l.');
insert into toolCategory (ToolCategory) value ('Utstyr for vedhogst');
insert into toolCategory (ToolCategory) value ('Tilhengere');
insert into toolCategory (ToolCategory) value ('Større utstyr');

