create table login (
		id serial not null primary KEY,
		username varchar(50),
		password varchar(50)
	);
	
create table users (
		id BIGSERIAL not null primary KEY,
		username varchar(50),
		password varchar(50),
		first_name VARCHAR(50) NOT NULL,
		last_name VARCHAR(50) NOT NULL,
		email VARCHAR(100) NOT NULL,
		login_id BIGINT REFERENCES login(id),
		accounttype VARCHAR(2) default 'E',
		unique(login_id),
		unique(email),
		CONSTRAINT chk_accounttype CHECK (accounttype IN ('E', 'M'))
	);

create table managers (
		id BIGSERIAL not null primary KEY,
		username varchar(50),
		password varchar(50),
		first_name VARCHAR(50) NOT NULL,
		last_name VARCHAR(50) NOT NULL,
		email VARCHAR(100) NOT NULL,
		login_id BIGINT REFERENCES login(id),
		accounttype VARCHAR(2) default 'M',
		unique(login_id),
		unique(email)
	);


select * from users; 
select * from login;
select * from reimbursement;

select * from managers;
----------------------------------
drop table users;
drop table managers;
drop table login;
drop table reimbursement;
----------------------------------

create table reimbursement (
	reimbursementId BIGSERIAL not null primary key,
	r_type VARCHAR(75) not null,
	status VARCHAR(20) not null default 'Created',
	amount numeric not null default 0.00,
	created_date DATE default(CURRENT_DATE),
	submitted_date DATE default(CURRENT_DATE),
	username VARCHAR(50) not null
);
	
select * from users;

insert into users(username,password,gender,notification,qualification) values('test','root123','female','email','Graduate');
insert into accounts(name,balance) values('Neha',10000);

drop table users;

