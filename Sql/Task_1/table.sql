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

CREATE TABLE comments (
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
