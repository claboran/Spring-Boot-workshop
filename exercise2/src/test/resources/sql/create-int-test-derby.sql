CREATE TABLE customer (
  id          BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  first_name  VARCHAR(255),
  last_name   VARCHAR(255),
  CONSTRAINT customer_prim_key PRIMARY KEY (id)
);

CREATE TABLE contract (
  id          BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  valid_from  DATE,
  valid_to    DATE,
  customer_id BIGINT REFERENCES customer(id),
  CONSTRAINT contract_prim_key PRIMARY KEY (id)
);