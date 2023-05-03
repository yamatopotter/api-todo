CREATE TABLE user (
    id int PRIMARY KEY  not null AUTO_INCREMENT,
    name varchar(40) not null,
    email varchar(150) not null,
    password varchar(32) not null,
    provider varchar(3) not null,
    created_at timestamp default CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE alert(
    id int PRIMARY KEY not null AUTO_INCREMENT,
    start_date datetime not null,
    end_date datetime not null,
    deleted boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE task(
    id int primary key not null AUTO_INCREMENT,
    id_user int,
    id_alert int,
    created_at timestamp default CURRENT_TIMESTAMP,
    simple_description varchar(150),
    long_description text,
    task_order int not null,
    is_done boolean not null,
    deleted boolean not null,
    FOREIGN KEY (id_user) REFERENCES user(id),
    FOREIGN KEY (id_alert) REFERENCES alert(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

