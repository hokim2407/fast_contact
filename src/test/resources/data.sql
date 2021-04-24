insert into person (id,name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (1, 'martin', 10,'A',1991,3,16 );
insert into person (id,name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (2, 'david', 9,'B',1997,4,1 );
insert into person (id,name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (3, 'dennis', 12,'O',1993,12,16 );
insert into person (id,name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (4, 'sophia', 3,'AB',1992,7,8 );
insert into person (id,name, age, blood_type, year_of_birthday, month_of_birthday, day_of_birthday) values (5, 'benny', 21,'A',1993,4,16 );


insert into block (id,name) values (1,'dennis');
insert into block (id,name) values (2,'sophia');

update person set block_id = 1 where id = 3;
update person set block_id = 2 where id = 4;