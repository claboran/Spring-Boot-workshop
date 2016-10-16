CREATE TABLE customer (
  id          BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  first_name  VARCHAR(255),
  last_name   VARCHAR(255)
);

CREATE TABLE contract (
  id          BIGINT  AUTO_INCREMENT PRIMARY KEY NOT NULL,
  valid_from  DATE,
  valid_to    DATE,
  customer_id BIGINT NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);