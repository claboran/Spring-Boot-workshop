DROP TABLE  contract;

DROP TABLE customer;

CREATE TABLE customer (
  id          BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  first_name  VARCHAR(255),
  last_name   VARCHAR(255)
);

CREATE TABLE contract (
  id          BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  valid_from  DATE,
  valid_to    DATE,
  customer_id BIGINT NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);