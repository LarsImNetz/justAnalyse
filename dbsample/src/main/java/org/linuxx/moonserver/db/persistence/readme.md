show databases;
use test;

drop table Name;
CREATE TABLE Name (
  id int(11) NOT NULL,
  vorname varchar(200) NOT NULL,
  name varchar(200) NOT NULL,

  address varchar(50) UNIQUE NOT NULL,
  PRIMARY KEY (id)
);
ALTER TABLE Name ENGINE=InnoDB;

drop table Address;
CREATE TABLE Address (
  id int(11) NOT NULL,
  name varchar(50) NOT NULL,
  ort varchar(200) NOT NULL, 
  PRIMARY KEY (id)
  -- TODO: How I'm be able to use a foreign key to a none primary key in the other table
  --       So I need to create the address table values first
  ,FOREIGN KEY (name) REFERENCES Name(address)
  -- WISHED  ,FOREIGN KEY (fk_address) REFERENCES Address(name)
);
ALTER TABLE Address ENGINE=InnoDB;


-- https://stackoverflow.com/questions/18435065/foreign-key-to-non-primary-key

delete from Name where vorname='lars';
insert into Name(id, vorname, name, address) values (1, 'lars', 'langhans', 'larsl');

-- Kardinalität Name 1:n Address
;
insert into Address(id, name, ort) values (1, 'larsl', 'Tremskamp');
insert into Address(id, name, ort) values (2, 'larsl', 'Karavellenstraße');
insert into Address(id, name, ort) values (3, 'larsl', 'Klipperstraße');

select n.id, n.vorname, n.name, a.ort from Name n, Address a where n.address = a.name;
select n.id, n.vorname, n.name, a.ort from Name n join Address a on a.name = n.address;

select * from Name;
select * From Address;
