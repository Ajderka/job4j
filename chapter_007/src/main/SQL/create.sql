CREATE DATABASE Task_1;

CREATE TABLE rights (
	right_id serial PRIMARY KEY,
	right_name VARCHAR(50)
);

CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_name VARCHAR(50)
);

CREATE TABLE role_right (
	right_id INT NOT NULL,
	FOREIGN KEY (right_id) REFERENCES rights (right_id),
	role_id INT NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	role_id INT NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (role_id),
	user_name VARCHAR(50)
);

CREATE TABLE states (
	state_id serial PRIMARY KEY,
	state_name VARCHAR(50)
);

CREATE TABLE categories (
	category_id serial PRIMARY KEY,
	category_name VARCHAR (50)
);

CREATE TABLE items (
	item_id serial PRIMARY KEY,
	user_id INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users (user_id),
	state_id INT NOT NULL,
	FOREIGN KEY (state_id) REFERENCES states (state_id),
	category_id INT NOT NULL,
	FOREIGN KEY (category_id) REFERENCES categories (category_id),
	item_name VARCHAR(250) NOT NULL
);	

CREATE TABLE `comments` (
	comment_id serial PRIMARY KEY,
	item_id INT NOT NULL,
	FOREIGN KEY (item_id) REFERENCES items (item_id),
	comment_text TEXT
);

CREATE TABLE attaches (
	attach_id serial PRIMARY KEY,
	item_id INT NOT NULL,
	FOREIGN KEY (item_id) REFERENCES items (item_id),
	file_name VARCHAR(250)
);

INSERT INTO rights (right_name)
VALUES 
	('Full access'), ('Read only');

INSERT INTO roles (role_name)
VALUES 
	('Admin'), ('Guest');

INSERT INTO role_right (right_id, role_id)
VALUES 
	((SELECT right_id FROM rights WHERE right_name = 'Full access'),
		(SELECT role_id FROM roles WHERE role_name = 'Admin')),
	((SELECT right_id FROM rights WHERE right_name = 'Read only'),
		(SELECT role_id FROM roles WHERE role_name = 'Guest'));

INSERT INTO users (role_id, user_name)
VALUES
	((SELECT role_id FROM roles WHERE role_name = 'Admin'), 'John'),
	((SELECT role_id FROM roles WHERE role_name = 'Guest'), 'Bob');

INSERT INTO states (state_name)
VALUES 
	('New'),
	('In procces'),
	('Closed');
	
INSERT INTO categories (category_name)
VALUES
	('Bug'),
	('Exception'),
	('Error');
	
INSERT INTO items (user_id, state_id, category_id, item_name)
VALUES
	((SELECT user_id FROM users WHERE user_name = 'John'), 
		(SELECT state_id FROM states WHERE state_name = 'New'),
		(SELECT category_id FROM categories WHERE category_name = 'Bug'),
		'Bug#1'),
	((SELECT user_id FROM users WHERE user_name = 'John'), 
		(SELECT state_id FROM states WHERE state_name = 'New'),
		(SELECT category_id FROM categories WHERE category_name = 'Error'),
		'Error#1');

INSERT INTO comments (item_id, comment_text)
VALUES 
	((SELECT item_id FROM items WHERE item_id = 1), 'Мышь живет своей жизнью'),
	((SELECT item_id FROM items WHERE item_id = 2), 'Синий экран');
	
INSERT INTO attaches (item_id, file_name)
VALUES
	((SELECT item_id FROM items WHERE item_id = 1), 'mouse.mp4');