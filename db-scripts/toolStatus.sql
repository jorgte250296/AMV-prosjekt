create database if not exists AMV;
use AMV;
create table if not EXISTS toolStatus
(
    ToolStatus_id          smallint auto_increment,
    ToolStatus_isAvailable bool,
    ToolStatus_isRented    bool,
    ToolStatus_isDamaged   bool,

    PRIMARY KEY (ToolStatus_id)
);

insert into toolStatus (ToolStatus_isAvailable,
                        ToolStatus_isRented,
                        ToolStatus_isDamaged)
values (false,
        false,
        true);
