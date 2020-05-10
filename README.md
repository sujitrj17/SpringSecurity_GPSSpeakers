# SpringSecurity_GPSSpeakers
Project which use spring security to login and other functionalities.
before starting with project.
dataabase needs to be set 
must required tables needed for testing are below and values.

CREATE TABLE role
(
 id bigserial NOT NULL,
 name character varying(255),
 CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (
 OIDS=FALSE
);
CREATE TABLE speakers_data
(
 id character varying(200) NOT NULL,
 website character varying(200),
 name character varying(200),
 "position" character varying(500),
 email character varying(200),
 contactno character varying(200),
 address character varying(500),
 CONSTRAINT speakers_data_id_key UNIQUE (id)
)
CREATE TABLE users
(
 id bigserial NOT NULL,
 password character varying NOT NULL,
 username character varying NOT NULL
)
CREATE TABLE users_roles
(
 users_id bigint NOT NULL,
 roles_id bigint NOT NULL,
 CONSTRAINT user_roles_pkey PRIMARY KEY (users_id, roles_id),
 CONSTRAINT fkj9553ass9uctjrmh0gkqsmv0d FOREIGN KEY (roles_id)
     REFERENCES role (id) MATCH SIMPLE
     ON UPDATE NO ACTION ON DELETE NO ACTION
)
*******************************
insert into role values(1,'admin');

insert into users_roles values(2,1);
insert into users_roles values(3,1);

insert into users values(2,'$2a$10$1f9r2shCH0QXO3AkPXQh2.KiRSL3Rz/KxoyCn1oBeQ1XPejqs4K2O','ruchisharma');
insert into users values(3,'$2a$10$6tnlZuNbkt.ij/64hMSuy./9CKOBuZcPYRQ7hXt67WbStNLSguVYm','abcxyz123');
