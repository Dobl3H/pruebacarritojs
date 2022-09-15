USE akan;
SHOW tables;

SELECT * FROM artistas;
SELECT * FROM productos;

SELECT artistas.artista_id,artistas.nombre,apellido,productos.nombre_producto
FROM artistas
INNER JOIN productos
ON artistas.artista_id=productos.artista_id;
-- INNER JOIN productos_pedidos
-- ON productos.id_producto=productos_pedidos.id_producto;