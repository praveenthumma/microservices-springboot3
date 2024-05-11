CREATE TABLE t_orders (
    id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_number  VARCHAR(255) DEFAULT NULL,
    sku_code  VARCHAR(255) DEFAULT NULL,
    quantity int(11),
    price DECIMAL(19, 2) NOT NULL
);