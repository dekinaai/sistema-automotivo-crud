INSERT INTO brands (id, name) VALUES (1, 'Toyota'), (2, 'Honda');
INSERT INTO models (id, name, brand_id) VALUES (1, 'Corolla', 1), (2, 'Civic', 2);
INSERT INTO vehicles (id, model_id, year, color, mileage, price, status) VALUES
(1, 1, 2020, 'Prata', 35000, 75000.00, 'AVAILABLE'),
(2, 2, 2019, 'Preto', 50000, 65000.00, 'SOLD');
