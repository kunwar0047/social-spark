DROP DATABASE SocialSpark;
CREATE DATABASE SocialSpark;
USE SocialSpark;
CREATE TABLE `users` (
   `id` int(3) NOT NULL AUTO_INCREMENT,
   `fname` varchar(20) DEFAULT NULL,
   `lname` varchar(20) DEFAULT NULL,
   `username` varchar(250) NOT NULL UNIQUE ,
   `password` varchar(20) DEFAULT NULL,
   `address` varchar(45) DEFAULT NULL,
   `contact` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`id`,`username`)
);
insert into users(fname,lname,username,password,address,contact) values('kunwar','kohli','kunwar','k','a','123');
insert into users(fname,lname,username,password,address,contact) values('AMAN','Deep','aman','a','a','123');
insert into users(fname,lname,username,password,address,contact) values('Deep','singh','deep','a','a','123');
SELECT * from Users;
CREATE TABLE posts (
    postid INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username varchar(250) NOT NULL,
    ptitle VARCHAR(30) NOT NULL,
    pbody TEXT NOT NULL,
    plikes INT DEFAULT 0,
    pdate DATE NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (username)
        REFERENCES users (username)
        ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE relationship(
user_one_name varchar(250) NOT NULL REFERENCES users(username),
user_two_name varchar(250) NOT NULL REFERENCES users(username) ,
status INT NOT NULL default 0,
action_user_name varchar(250) NOT NULL,
CONSTRAINT CheckOneWay CHECK (user_one_name != user_two_name),
CONSTRAINT UQ_Friends_Pairs UNIQUE (user_two_name, user_one_name),
CONSTRAINT PK_Friends_Pairs PRIMARY KEY (user_one_name, user_two_name)
);
CREATE TABLE message(
sender varchar(250) NOT NULL REFERENCES users(username),
receiver varchar(250) NOT NULL REFERENCES users(username) ,
message text,
timesent datetime default CURRENT_TIMESTAMP
);
CREATE TABLE notifications(
id INT AUTO_INCREMENT PRIMARY KEY,
username varchar(250) NOT NULL REFERENCES users(username),
notification varchar(250)
);
CREATE TRIGGER FriendNotification after INSERT ON relationship FOR EACH ROW
INSERT INTO notifications
SET username=new.user_two_name,
notification=CONCAT(UCASE(new.user_one_name) ,' Started Following You');
select * from posts;
CREATE TRIGGER MessageNotification after INSERT ON message FOR EACH ROW
INSERT INTO notifications
SET username=new.receiver,
notification=CONCAT(UCASE(new.sender) ,' Sent You A Message');
select * from posts;
