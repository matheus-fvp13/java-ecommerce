CREATE TABLE tb_order_item
(
    quantity   INTEGER          NOT NULL,
    price      DOUBLE PRECISION NOT NULL,
    order_id   BIGINT           NOT NULL,
    product_id BIGINT           NOT NULL,
    CONSTRAINT pk_tb_order_item PRIMARY KEY (order_id, product_id)
);

ALTER TABLE tb_order_item
    ADD CONSTRAINT FK_TB_ORDER_ITEM_ON_ORDER FOREIGN KEY (order_id) REFERENCES tb_order (id);

ALTER TABLE tb_order_item
    ADD CONSTRAINT FK_TB_ORDER_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES tb_product (id);