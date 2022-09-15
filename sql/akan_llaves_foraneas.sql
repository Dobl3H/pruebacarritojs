USE akan;
-- llaves foraneas

ALTER TABLE  productos
ADD CONSTRAINT fk_artista_producto
FOREIGN KEY (artista_id)
REFERENCES artistas (artista_id);

ALTER TABLE  usuario
ADD CONSTRAINT fk_usuario_registro
FOREIGN KEY (id_registro)
REFERENCES registro (id_registro);

ALTER TABLE  productos_pedidos
ADD CONSTRAINT fk_prodPed_produc
FOREIGN KEY (id_producto)
REFERENCES productos (id_producto);

ALTER TABLE  productos_pedidos
ADD CONSTRAINT fk_prodPed_detalles
FOREIGN KEY (id_pedido)
REFERENCES detalle_de_pedido (id_pedido);


ALTER TABLE  envio
ADD CONSTRAINT fk_pedido_detalles
FOREIGN KEY (id_pedido)
REFERENCES detalle_de_pedido (id_pedido);


ALTER TABLE   metodo_pago
ADD CONSTRAINT fk_pago_metodo
FOREIGN KEY ( id_pedido)
REFERENCES detalle_de_pedido (id_pedido);



ALTER TABLE   detalle_de_pedido
ADD CONSTRAINT fk_detalle_usuario
FOREIGN KEY (id_cliente)
REFERENCES usuario (id_cliente);