create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  enthusiasm            varchar(50) unique,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

create table authorities (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);


CREATE TABLE roles_authorities (
   role_id               bigint not null,
   authority_id               int not null,
   primary key (role_id, authority_id),
   foreign key (role_id) references roles (id),
   foreign key (authority_id) references authorities (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into authorities (name)
values
('READ_MSG'), ('ADMIN_MSG');



insert into users (username, password, email, enthusiasm)
values
('user', '$2a$12$o4f98kanPER0xfqVGQMZtO5ZNT9R2wEL6cJVT37dz/apiATjisJIG', 'user@gmail.com', 'travel');

insert into users_roles (user_id, role_id)
values
(1, 1), (1, 2);


insert into roles_authorities (role_id, authority_id)
values
(1, 1), (2, 2);
