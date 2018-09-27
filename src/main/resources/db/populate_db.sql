DELETE FROM mobile;
DELETE FROM manufacturer;

ALTER SEQUENCE manufacturer_id_seq RESTART WITH 1;
ALTER SEQUENCE mobile_id_seq RESTART WITH 1;

INSERT INTO manufacturer (name, country) VALUES
  ('Siemens', 'Germany'),
  ('Apple', 'USA'),
  ('Motorola', 'USA'),
  ('Nokia', 'Finland');

INSERT INTO mobile (model, price, manufacturer_id) VALUES
  ('c35', 5000, 1),
  ('3310', 2000, 4),
  ('5110', 5000, 4),
  ('3G', 12000, 2),
  ('c25', 3000, 1),
  ('Milestone', 1500, 3);


