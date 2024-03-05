CREATE TABLE tb_payment
(
    order_id BIGINT NOT NULL,
    moment   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_tb_payment PRIMARY KEY (order_id)
);

ALTER TABLE tb_payment
    ADD CONSTRAINT FK_TB_PAYMENT_ON_ORDER FOREIGN KEY (order_id) REFERENCES tb_order (id);