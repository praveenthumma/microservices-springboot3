CREATE TABLE t_inventory
(
    id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sku_code  varchar(255) DEFAULT NULL,
    quantity int(11)      DEFAULT NULL
  
);