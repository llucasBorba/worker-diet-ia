INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (1, 'Homer Simpson', 108, 183, 39, 'Excesso de acucar e alcool', 'DEFICIT');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (2, 'Marge Simpson', 62, 175, 36, 'Nenhuma', 'MAINTENANCE');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (3, 'Bart Simpson', 42, 150, 10, 'Evitar excesso de acucar', 'MAINTENANCE');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (4, 'Lisa Simpson', 38, 148, 8, 'Vegetariana', 'MAINTENANCE');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (5, 'Ned Flanders', 75, 178, 60, 'Reducao de sodio', 'MAINTENANCE');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (6, 'Milhouse Van Houten', 40, 152, 10, 'Intolerancia leve a lactose', 'MAINTENANCE');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (7, 'Chief Wiggum', 112, 180, 45, 'Controle de gordura e frituras', 'DEFICIT');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (8, 'Apu Nahasapeemapetilon', 68, 172, 40, 'Preferencia por dieta vegetariana', 'MAINTENANCE');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (9, 'Carl Carlson', 82, 181, 38, 'Nenhuma', 'SURPLUS');

INSERT INTO patient (id, name, weight, height, age, restrictions, caloricGoal)
VALUES (10, 'Lenny Leonard', 85, 179, 39, 'Reducao de alcool', 'SURPLUS');

ALTER TABLE patient ALTER COLUMN id RESTART WITH 11;