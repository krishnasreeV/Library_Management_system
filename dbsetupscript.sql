/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

DROP TABLE ReturnBook;
DROP TABLE IssuedBookA;
DROP TABLE Issuers;
DROP TABLE BookA;
DROP TABLE Genre;
DROP TABLE Authors;
*/


-- 
-- -- 
CREATE DATABASE LIBRARY;
USE LIBRARY;
CREATE TABLE Authors(
author_id INTEGER AUTO_INCREMENT,
author_name VARCHAR(60),
PRIMARY KEY(author_id)
);

INSERT INTO Authors VALUES (1, 'Tolkein');

CREATE TABLE Genre(
genre_id INTEGER AUTO_INCREMENT,
genre_name VARCHAR(60),
PRIMARY KEY(genre_id)
);

INSERT INTO Genre VALUES(1,'Fantasy');

CREATE TABLE BookA(
book_id INTEGER AUTO_INCREMENT,
book_name VARCHAR(60),
author_id INTEGER,
genre_id INTEGER,
count INTEGER,
PRIMARY KEY(book_id),
FOREIGN KEY(author_id) REFERENCES Authors(author_id),
FOREIGN KEY(genre_id) REFERENCES Genre(genre_id));

CREATE TABLE Issuers(
issuer_id INTEGER AUTO_INCREMENT,
name VARCHAR(60),
max_issue INTEGER,
PRIMARY KEY(issuer_id)
);

CREATE TABLE IssuedBookA(
ib_id INTEGER AUTO_INCREMENT,
book_id INTEGER,
issuer_id INTEGER,
returnedyn CHAR,
PRIMARY KEY(ib_id),
FOREIGN KEY(book_id) REFERENCES BookA(book_id),
FOREIGN KEY(issuer_id) REFERENCES Issuers(issuer_id)
);


CREATE TABLE ReturnBook(
rb_id INTEGER AUTO_INCREMENT,
ib_id INTEGER,
PRIMARY KEY(rb_id),
FOREIGN KEY(ib_id) REFERENCES IssuedBookA(ib_id)
);


