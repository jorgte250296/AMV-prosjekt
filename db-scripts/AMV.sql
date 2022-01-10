create database if not exists AMV;
use AMV;
create table if not EXISTS user
(
    User_id          smallint auto_increment,
    User_firstName   nvarchar(255) not null,
    User_lastName    nvarchar(255) not null,
    User_phoneNumber nvarchar(255) not null,
    User_password    nvarchar(255) not null,
    User_isAdmin     boolean       not null,
    primary key (User_id)
);

create table if not EXISTS toolStatus
(
    ToolStatus_id          smallint auto_increment,
    ToolStatus_isAvailable bool,
    ToolStatus_isRented    bool,
    ToolStatus_isDamaged   bool,

    PRIMARY KEY (ToolStatus_id)
);
insert into toolStatus (ToolStatus_isAvailable, ToolStatus_isRented, ToolStatus_isDamaged)
values (true, false, false);

insert into toolStatus (ToolStatus_isAvailable, ToolStatus_isRented, ToolStatus_isDamaged)
values (false, true, false);

insert into toolStatus (ToolStatus_isAvailable, ToolStatus_isRented, ToolStatus_isDamaged)
values (false, false, true);

create table if not EXISTS toolCategory
(
    ToolCategory_id smallint auto_increment,
    ToolCategory    nvarchar(255) not null,

    PRIMARY KEY (ToolCategory_id)
);
insert into toolCategory (ToolCategory)
    value ('Utstyr og diverse');
insert into toolCategory (ToolCategory)
    value ('Spikerpistoler o.l.');
insert into toolCategory (ToolCategory)
    value ('Utstyr for vedhogst');
insert into toolCategory (ToolCategory)
    value ('Tilhengere');
insert into toolCategory (ToolCategory)
    value ('Større utstyr');

create table if not EXISTS tool
(
    Tool_id          smallint auto_increment,
    Tool_toolName    nvarchar(255) not null,
    Tool_description text,
    Tool_price       decimal,
    Tool_freeDayOne  bool     default true,
    ToolCategory_id  smallint,
    ToolStatus_id    smallint default 1,

    PRIMARY KEY (Tool_id),
    FOREIGN KEY (ToolCategory_id) REFERENCES toolCategory (ToolCategory_id) on delete set null,
    FOREIGN KEY (ToolStatus_id) REFERENCES toolStatus (ToolStatus_id) on delete set null
);

create table if not exists orderTable
(
    OrderTable_id   smallint auto_increment,
    OrderTable_date date not null,
    User_id         smallint,

    primary key (OrderTable_id),
    foreign key (User_id) references user (User_id) on delete set null
);

create table if not EXISTS orderItem
(
    Tool_id       smallint                not null,
    OrderTable_id smallint                not null,
    DateFrom      date                    not null,
    DateTo        date                    not null,
    OrderItem_id  smallint auto_increment not null,

    primary key (OrderItem_id),
    foreign key (Tool_id) references tool (tool_id) on delete cascade,
    foreign key (OrderTable_id) references orderTable (OrderTable_id) on delete cascade
);

create table if not EXISTS files
(
    File_id          smallint auto_increment not null,
    File_name        nvarchar(255)           not null,
    File_content     mediumblob              not null,
    File_contentType nvarchar(255)           not null,
    primary key (File_id)
);


