INSERT INTO department (name, num_of_emp)
SELECT 'Human Resources', 5 WHERE NOT EXISTS (SELECT 1 FROM department WHERE name = 'Human Resources' AND num_of_emp = 5);

INSERT INTO department (name, num_of_emp)
SELECT 'Engineering', 20 WHERE NOT EXISTS (SELECT 1 FROM department WHERE name = 'Engineering' AND num_of_emp = 20);

INSERT INTO department (name, num_of_emp)
SELECT 'Marketing', 10 WHERE NOT EXISTS (SELECT 1 FROM department WHERE name = 'Marketing' AND num_of_emp = 10);

INSERT INTO department (name, num_of_emp)
SELECT 'Sales', 15 WHERE NOT EXISTS (SELECT 1 FROM department WHERE name = 'Sales' AND num_of_emp = 15);

INSERT INTO department (name, num_of_emp)
SELECT 'Customer Support', 8 WHERE NOT EXISTS (SELECT 1 FROM department WHERE name = 'Customer Support' AND num_of_emp = 8);