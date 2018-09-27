DROP TABLE IF EXISTS mobile;
DROP TABLE IF EXISTS manufacturer;
DROP SEQUENCE IF EXISTS mobile_id_seq;
DROP SEQUENCE IF EXISTS manufacturer_id_seq;

CREATE SEQUENCE manufacturer_id_seq;
CREATE SEQUENCE mobile_id_seq;

CREATE TABLE manufacturer
(
  id      INTEGER PRIMARY KEY DEFAULT nextval('manufacturer_id_seq'),
  name    VARCHAR(30) NOT NUll,
  country VARCHAR(30) NOT NULL
);

CREATE TABLE mobile
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('mobile_id_seq'),
  model           VARCHAR(30)      NOT NULL,
  price           DOUBLE PRECISION NOT NULL,
  manufacturer_id INTEGER          NOT NULL,
  CONSTRAINT mobile_manufacturer_id_fk
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (id) ON DELETE CASCADE
);



