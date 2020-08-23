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