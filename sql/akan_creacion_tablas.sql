DROP DATABASE akan;
CREATE DATABASE akan;
USE akan;

-- TABLAS --------------------------------------------------------------
CREATE TABLE artistas(
artista_id INT NOT NULL auto_increment PRIMARY KEY,
nombre CHAR (50) NOT NULL,
apellido CHAR (50) NOT NULL,
categoria  CHAR (50) NOT NULL,
ciudad  VARCHAR (150) NOT NULL,
correo VARCHAR (150) UNIQUE,
link_fb VARCHAR (150),
link_ig VARCHAR (150),
link_tiktok VARCHAR (150),
link_spotify VARCHAR (150),
 telefono  CHAR (50)
 );
 
DROP TABLE artistas;
SELECT * FROM artistas;


CREATE TABLE registro (
id_registro INT NOT NULL PRIMARY KEY,
nombre_usuario VARCHAR (50) NOT NULL,
email VARCHAR(100) UNIQUE  NOT NULL,
contraseña VARCHAR(100) UNIQUE NOT NULL,
fecha_nacimiento TIMESTAMP NOT NULL 
DEFAULT CURRENT_TIMESTAMP 
ON UPDATE CURRENT_TIMESTAMP
);
SELECT * FROM registro;
drop table registro;


CREATE TABLE metodo_pago(
id_pago INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_pedido INT NOT NULL,
id_cliente INT NOT NULL,
tipo_pago VARCHAR(20) NULL,
num_tarjeta VARCHAR(16) NULL,
year_tarjeta INT NULL,
mes_tarjeta INT NULL,
ccv INT NULL);

SELECT * FROM metodo_pago;
drop table metodo_pago;


CREATE TABLE detalle_de_pedido(
id_pedido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_producto INT NOT NULL,
id_cliente INT NOT NULL,
precio_por_unidad DECIMAL(6,2) NOT NULL,
descripcion_del_pedido VARCHAR(255),
total_compra DECIMAL(6,2) NOT NULL,
cantidad INT NOT NULL);

SELECT * FROM detalle_de_pedido;
drop table detalle_de_pedido;



CREATE TABLE envio(
id_guia_envio INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_pedido INT NOT NULL,
id_cliente INT,              -- FOREIGN KEY REFERENCES Detalle de pedido(id_cliente)
fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
registro_envio INT NOT NULL
);
SELECT * FROM envio;
DROP TABLE envio;



CREATE TABLE productos_pedidos(
id_producto_pedido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
-- FOREIGN KEY (id_producto) REFERENCES  productos(id_producto),
-- FOREIGN KEY (id_pedido) REFERENCES  detalle_de_pedido(id_pedido)
id_producto INT NOT NULL,
id_pedido INT NOT NULL
);
SELECT * FROM productos_pedidos;
DROP TABLE productos_pedidos;



CREATE TABLE usuario(
id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(50) UNIQUE NOT NULL, -- FK
nombre_usuario VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
direccion VARCHAR(250) NOT NULL,
id_registro INT NOT NULL,
telefono VARCHAR(15) NOT NULL);

SELECT * FROM usuario;
DROP TABLE usuario;

CREATE TABLE productos(
id_producto INT NOT NULL PRIMARY KEY unique, 
artista_id INT NOT NULL,
nombre_producto VARCHAR(255) NOT NULL,
precio DECIMAL(6,2) NOT NULL,
descripcion VARCHAR(255)
);
SELECT * FROM productos;
DROP TABLE productos;





