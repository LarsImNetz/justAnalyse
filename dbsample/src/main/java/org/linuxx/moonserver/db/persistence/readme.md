show databases;
use test;

drop table Address;
CREATE TABLE Address (
  id int(11) NOT NULL,
  name varchar(50) NOT NULL,
  ort varchar(200) NOT NULL, 
  PRIMARY KEY (id)
);
ALTER TABLE Address ENGINE=InnoDB;

drop table name;
CREATE TABLE Name (
  id int(11) NOT NULL,
  vorname varchar(200) NOT NULL,
  name varchar(200) NOT NULL,

  fk_address varchar(50) NOT NULL,
  PRIMARY KEY (id)
  -- TODO: How I'm be able to use a foreign key to a none primary key in the other table
  --       So I need to create the address table values first
  ,FOREIGN KEY (id) REFERENCES Address(id)
  -- WISHED  ,FOREIGN KEY (fk_address) REFERENCES Address(name)
);
ALTER TABLE Name ENGINE=InnoDB;

delete from name where vorname='lars';
insert into name(id, vorname, name, fk_address) values (1, 'lars', 'langhans', 'larsl');
-- Kardinalität Name 1:n Address
insert into address(id, name, ort) values (1, 'larsl', 'Tremskamp');
insert into address(id, name, ort) values (2, 'larsl', 'Karavellenstraße');
insert into address(id, name, ort) values (3, 'larsl', 'Klipperstraße');

select n.id, n.vorname, n.name, a.ort from name n, address a where n.fk_address = a.name;
select n.id, n.vorname, n.name, a.ort from name n join address a on a.name = n.fk_address;

select * from name;
select * From address;
