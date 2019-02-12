insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into account (id, create_date, email, name, nick_name, passwd)
values(1, now(), 'urstory@gmail.com', 'kim', 'toto', '{bcrypt}$2a$10$UkBPAAk468Ir6MEACd1gXuieKCZ2qZAHcDbMER.XG4VNn.mj4MWEC');

insert into account (id, create_date, email, name, nick_name, passwd)
values(2, now(), 'carami@gmail.com', 'kang', 'carami', '{bcrypt}$2a$10$UkBPAAk468Ir6MEACd1gXuieKCZ2qZAHcDbMER.XG4VNn.mj4MWEC');

insert into account_roles(account_id, role_id) values( 1, 1);
insert into account_roles(account_id, role_id) values( 2, 1);
insert into account_roles(account_id, role_id) values( 1, 2);

insert into blog(id, title, url) values(1, 'HELLO JAVA', 'java');

insert into category(id, name, ordering) values(1, '기본문법', 1);
insert into category(id, name, ordering) values(2, '객체지향문', 2);

insert into category(id, name, ordering) values(3, 'JPA', 3);
insert into category(id, name, ordering) values(4, 'JPQL', 4);

insert into post(id, title, content, create_date, category_id) values(1, 'title1', 'content1', now(), 1);
insert into post(id, title, content, create_date, category_id) values(2, 'title2', 'content2', now(), 1);
insert into post(id, title, content, create_date, category_id) values(3, 'title3', 'content3', now(), 1);
insert into post(id, title, content, create_date, category_id) values(4, 'title4', 'content4', now(), 1);
insert into post(id, title, content, create_date, category_id) values(5, 'title5', 'content5', now(), 1);
insert into post(id, title, content, create_date, category_id) values(6, 'title6', 'content6', now(), 2);
