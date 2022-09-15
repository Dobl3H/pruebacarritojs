USE akan;

 -- agregar datos artistas
INSERT INTO artistas (nombre, apellido, categoria, ciudad, correo, link_fb, link_ig, link_tiktok, link_spotify, telefono)
VALUES ('jesu','rojas','fotografia', 'CDMX', 'jesu@gmail.com','link' , 'link','link' , null, '5511223388'),
('jannethe','woodoh','pintura', 'CDMX', 'janete@gmail.com', null , 'link','link' , null, '5533445588');

SELECT * FROM registro;
-- agregar registros
INSERT INTO registro
(id_registro, nombre_usuario, email, contraseña, fecha_nacimiento)
VALUES (01, "Sophi", "sophiaReyes@gamil.com", "reyes11", '2000-09-09'),
(02, "Pily", "PilyR@gamil.com", "reinas11", '2000-10-09');

SELECT * FROM productos;
-- agregar productos
INSERT INTO productos(id_producto,artista_id,nombre_producto,precio,descripcion)
VALUES(1,1,"Collar azul",75.5,"Collar hecho a mano"),
(2,2,"Collar rosa",80,"Collar hecho a mano");


SELECT * FROM usuario;
-- AGREGAR usuarios
INSERT INTO usuario(email, nombre_usuario, apellido, direccion, id_registro,telefono)
VALUES ('arturo123@gmail.com', 'Arturo', 'Lopez', 'calle a numero b C.P 56000',1, '5519497165'),
('oscar456@gmail.com', 'Oscar', 'Avila', 'calle c numero d C.P 56001',2, '7222478012');

SELECT * FROM detalle_de_pedido;
-- agregar detalles de pedido
INSERT INTO detalle_de_pedido (id_producto,id_cliente, precio_por_unidad, descripcion_del_pedido, total_compra, cantidad)
VALUES (1, 1, 250,"Collar azul",250,1),
(1, 1, 250,"Collar azul",250,1);

SELECT * FROM envio;
-- agregar envio
INSERT INTO envio(id_pedido,id_cliente,fecha,registro_envio)
VALUES(1,1,'2022-08-02',1),
(2,2,'2022-06-12',2);

SELECT * FROM metodo_pago;
-- agregar método de pago
INSERT INTO metodo_pago(id_pedido,id_cliente,tipo_pago,num_tarjeta,year_tarjeta,mes_tarjeta,ccv)
VALUES(1,1,"tarjeta",123456,2022,4,1234),
(2,3,"transferencia",124562,2021,3,1232);



