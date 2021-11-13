CREATE TABLE product(
  id INTEGER,
  name VARCHAR(50),
  category VARCHAR(50),
  price DECIMAL(8, 2),
  manufacturer VARCHAR(50),
  quantity INTEGER
);

INSERT INTO
  product
VALUES
  (100, "mobile1", "Electronics", 25000, "Oppo", 23),
(101, "mobile2", "Electronics", 36000, "OnePlus", 33),
  (102, "laptop", "Electronics", 55000, "Dell", 12),
(103, "Honey", "grocery", 4000, "Honey Co. Pvt", 22),
  (104, "Coffe", "grocery", 280, "Nescafe", 45);