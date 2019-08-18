CREATE DATABASE Car;

CREATE TABLE  car_body (
  car_body_id serial PRIMARY KEY,
  car_body_type VARCHAR(20),
  car_body_color VARCHAR(20)
);

CREATE TABLE  car_engine (
  car_engine_id serial PRIMARY KEY,
  car_engine_type VARCHAR(20),
  car_engine_capacity DEC(2,1),
  car_engine_horsepower INT
);

CREATE TABLE  car_transmission (
  car_transmission_id serial PRIMARY KEY,
  car_transmission_type VARCHAR(20),
  car_transmission_numberOfGears INT
);

CREATE TABLE car (
  car_id serial PRIMARY KEY,
  car_name VARCHAR (30),
  car_body_id INT NOT NULL,
  CONSTRAINT car_body_car_body_id_fk
  FOREIGN KEY (car_body_id)
  REFERENCES car_body (car_body_id),
  car_engine_id INT NOT NULL,
  CONSTRAINT car_engine_car_engine_id_fk
  FOREIGN KEY (car_engine_id)
  REFERENCES car_engine (car_engine_id),
  car_transmission_id INT NOT NULL,
  CONSTRAINT car_transmission_car_transmission_id_fk
  FOREIGN KEY (car_transmission_id)
  REFERENCES car_transmission (car_transmission_id)
);

INSERT INTO car_body (car_body_type, car_body_color)
VALUES ('Sedan' ,'Red'), ('Hatchback', 'Grey'), ('Universal', 'Blue'), ('Wagon', 'Black');

INSERT INTO car_engine (car_engine_type, car_engine_capacity, car_engine_horsepower)
VALUES ('TDI', 2.0, 150), ('MPI', 1.6, 110), ('TSI', 1.8, 180), ('TSI', 2.0, 250);

INSERT INTO car_transmission (car_transmission_type, car_transmission_numberOfGears)
VALUES ('Mechanical', 5), ('Mechanical', 6), ('Automatic', 6), ('DSG', 7);

INSERT INTO car (car_name, car_body_id, car_engine_id, car_transmission_id)
VALUES ('CAR1', 2, 2, 1), ('CAR2', 1, 1, 3), ('CAR3', 3, 3, 4);

-- 1. Вывести список всех машин и все привязанные к ним детали.
SELECT body.car_body_type, body.car_body_color, engine.car_engine_capacity, engine.car_engine_horsepower,
        engine.car_engine_type, tr.car_transmission_type, tr.car_transmission_numberOfGears
FROM car
	INNER JOIN car_body AS body
	ON car.car_body_id = body.car_body_id
	INNER JOIN car_engine AS engine
	ON  car.car_engine_id = engine.car_engine_id
	INNER JOIN car_transmission AS tr
	ON  car.car_transmission_id = tr.car_transmission_id
	ORDER BY car.car_id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
SELECT body.car_body_type, body.car_body_color
FROM car_body AS body
LEFT OUTER JOIN car AS c
ON body.car_body_id = c.car_body_id WHERE c.car_name IS NULL;

SELECT engine.car_engine_capacity, engine.car_engine_horsepower,
        engine.car_engine_type
FROM car_engine AS engine
LEFT OUTER JOIN car AS c
ON engine.car_engine_id = c.car_engine_id WHERE c.car_name IS NULL;

SELECT tr.car_transmission_type, tr.car_transmission_numberOfGears
FROM car_transmission AS tr
LEFT OUTER JOIN car AS c
ON tr.car_transmission_id = c.car_transmission_id WHERE c.car_name IS NULL;