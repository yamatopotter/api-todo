CREATE TABLE user (
    id int primary key not null autoincrement,
    name varchar(40) not null,
    email varchar(150) not null,
    password varchar(32) not null
);

CREATE TABLE task(
    id int primary key not null autoincrement,
    id_user int not null,
    created_at timestamp,
    simple_description varchar(150),
    long_description text,
    task_order int not null,
    is_done boolean not null,
    is_visible boolean not null,
)

CREATE TABLE alert(
    id int primary key not null autoincrement,
    id_task int not null
    start_date datetime not null,
    end_date datetime not null
)