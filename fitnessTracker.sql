create table users(
    username varchar(50) not null primary key, 
    password varchar (60) not null, 
    enabled boolean not null);

create table authorities(
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users
    foreign key(username) references users(username));

    create unique index ix_auth_username on authorities (username, authority);

insert into users (username, password, enabled) values
    ("bryan", "$2a$10$ukyztFgbdCUqKa4bd4exv.8FS8vhy8LvNKbZvhDsk57l4thwMYZBC", true),
    ("mark", "$2a$10$ukyztFgbdCUqKa4bd4exv.8FS8vhy8LvNKbZvhDsk57l4thwMYZBC", true),
    ("chris", "$2a$10$ukyztFgbdCUqKa4bd4exv.8FS8vhy8LvNKbZvhDsk57l4thwMYZBC", true);

insert into authorities (username, authority) values
    ("chris", "ROLE_ADMIN"),
    ("chris", "ROLE_USER"),
    ("mark", "ROLE_BAD"),
    ("bryan", "ROLE_USER");

create table permissions (
	username varchar(50) not null,
	target varchar(50) not null,
	permission varchar(50) not null,
    constraint fk_permissions_users foreign key (username) references users(username));
    
create unique index ix_perm_username on permissions (username, target, permission);

insert into permissions (username, target, permission) values
	("chris", "com.escobar.model.Goal", "createGoal");