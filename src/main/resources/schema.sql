CREATE TABLE IF NOT EXISTS
product(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR2(50),
    description VARCHAR2(400),
    qty NUMERIC(16,2),
    unit_price NUMERIC(16,2),
    category_id NUMERIC(16,2),
    status BOOLEAN DEFAULT true,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS
category(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR2(50)
);


CREATE TABLE IF NOT EXISTS
client(
    id INT NOT NULL AUTO_INCREMENT,
    type_id NUMERIC(16,2),
    identification NUMERIC(16,2),
    name VARCHAR2(50),
    last_name VARCHAR2(50),
    address VARCHAR2(50),
    cell_phone NUMERIC(16,2),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS
orders(
    id INT NOT NULL AUTO_INCREMENT,
    client_id NUMERIC(16,2),
    qty NUMERIC(16,2),
    total_order NUMERIC(16,2),
    date_order VARCHAR2(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS
order_detail(
    id INT NOT NULL AUTO_INCREMENT,
    order_id NUMERIC(16,2),
    product_id NUMERIC(16,2),
    qty NUMERIC(16,2),
    unit_price NUMERIC(16,2),
    total NUMERIC(16,2),
    PRIMARY KEY(id)
);

