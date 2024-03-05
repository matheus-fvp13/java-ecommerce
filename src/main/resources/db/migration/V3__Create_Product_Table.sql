CREATE TABLE tb_product
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(100)                            NOT NULL,
    description TEXT,
    price       DOUBLE PRECISION                        NOT NULL,
    img_url     TEXT,
    CONSTRAINT pk_tb_product PRIMARY KEY (id)
);

CREATE TABLE tb_product_category
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL,
    CONSTRAINT pk_tb_product_category PRIMARY KEY (category_id, product_id)
);

ALTER TABLE tb_product
    ADD CONSTRAINT uc_tb_product_name UNIQUE (name);

ALTER TABLE tb_product_category
    ADD CONSTRAINT fk_tbprocat_on_category_entity FOREIGN KEY (category_id) REFERENCES tb_category (id);

ALTER TABLE tb_product_category
    ADD CONSTRAINT fk_tbprocat_on_product_entity FOREIGN KEY (product_id) REFERENCES tb_product (id);