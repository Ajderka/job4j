CREATE TABLE company
(
  id integer NOT NULL,
  name character varying,
  CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
  id integer NOT NULL,
  name character varying,
  company_id integer,
  CONSTRAINT person_pkey PRIMARY KEY (id)
);

SELECT person.name, company.name FROM person
INNER JOIN company ON person.company_id = company.id
WHERE NOT EXISTS (SELECT name FROM company
  WHERE id = 5);

SELECT company.name, COUNT(person.id) AS count FROM company
INNER JOIN person ON company.id = person.company_id
WHERE MAX(COUNT(person.id));