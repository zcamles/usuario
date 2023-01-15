CREATE SCHEMA usuarios;

SET SCHEMA usuarios;

CREATE TABLE users ( 
   id UUID PRIMARY KEY, 
   name VARCHAR(50), 
   email VARCHAR(20) UNIQUE, 
   password VARCHAR(20),
   created DATE,
   modified DATE,
   last_login DATE,
   token VARCHAR(50),
   is_active BOOL
);

CREATE TABLE phone (
   number VARCHAR(10),
   city_code VARCHAR(2),
   country_code VARCHAR(2),
   user_id UUID NOT NULL,
   foreign key (user_id) references users(id)
);