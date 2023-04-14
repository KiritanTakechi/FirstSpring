create schema study;

use study;

create table t_user
(
    f_id       int primary key auto_increment,
    f_nickname nvarchar(32) not null,
    f_username nvarchar(32) not null unique,
    f_password nvarchar(32) not null
);

insert into t_user(f_nickname, f_username, f_password)
values ('管理员', 'root', '123456');