create database cadenaRestaurantes;
use cadenaRestaurantes;
create table restaurantes(
	codRes int auto_increment primary key,
    correo varchar(40) unique,
    clave varchar(40),
    pais varchar(40),
    cp int,
    ciudad varchar(40),
    direccion varchar(80)
);
create table pedidos (
	codPed int auto_increment primary key,
    fecha varchar(21),
    enviado boolean,
    restaurante int not null,
	foreign key(restaurante) references restaurantes (codRes)
);
create table categorias(
	codCat int primary key auto_increment,
    nombre varchar(40) unique not null,
    descripcion varchar(200)
);
create table productos (
	codProd int auto_increment primary key,
    nombre varchar(40) not null,
    descripcion varchar(200),
    peso double,
    stock int not null check (stock > -1),
    categoria int not null,
    foreign key (categoria) references categorias (codCat)
);
create table pedidosProductos (
	codPedProd int primary key auto_increment,
    pedido int not null,
    foreign key (pedido) references pedidos (codPed),
    producto int not null,
    foreign key (producto) references productos (codProd),
    unidades int
);

insert into categorias values(1, "Pasta", "Todo tipo de pasta desde espaguetis hasta raviolis");
insert into categorias values(2, "Vegetales", "Todo tipo de vegetales desde acelgas hasta espinacas");
insert into categorias values(3, "Legumbres", "Todo tipo de legumbres desde garbanzos hasta lentejas");
insert into categorias values(4, "Carnes", "Todo tipo de carnes desde filetes de pollo hasta filetes de ternera");
insert into categorias values(5,"Especias", "Todo tipo de especias desde anis hasta pimenton");
insert into restaurantes values(1, "hola@gmail.com", md5("123"), "España", 28900, "Getafe", "Calle hola");
insert into restaurantes values(2, "adios@gmail.com", md5("abc"), "España", 28900, "Getafe", "Calle adios");
insert into productos (nombre,descripcion,peso,stock,categoria)values("Macarrones", "Marca Soprano", 2.00, 0, 1);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Espaguetis", "Marca El Gallo", 5.67, 5, 1);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Raviolis", "Marca Soprano", 3.250, 7, 1);
insert into productos(nombre,descripcion,peso,stock,categoria) values("Espinacas", "Procedentes de Zamora ", 1.20, 6, 2);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Acelgas", "Procedentes de Leon", 2.00, 10, 2);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Garbanzos", "Si", 2.00, 4, 3);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Judias", "Si", 2.00, 7, 3);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Filete de ternera", "Ganaderia Pi", 1.00, 8, 4);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Filete de Pollo", "Granjas CAE", 0.50, 6, 4);

/*Vistas*/
create view vista_lista_categorias as select * from categorias;
create view vista_stocks as select nombre,stock from productos;
create view lista_caracteristicas_producto as select nombre,descripcion,peso,stock from productos;
create view lista_caracteristicas_categoria as select nombre,descripcion from categorias;
create view vista_nombres_producto as select * from productos;
create view vista_codPed_fecha_restaurante as select codPed,fecha,restaurante from pedidos;


/*Procedimientos*/
DELIMITER $
CREATE PROCEDURE mostrarCategoriaPorNombre(categoria varchar(15))
BEGIN
	SELECT * FROM categorias WHERE nombre = categoria;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE mostrarTodosLosProductosCategoria(numCategoria int)
BEGIN
	SELECT * FROM productos WHERE categoria = numCategoria;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE updateProductos(cantidadStockActual int,nombreProducto varchar(40),cantidadStockARetirar int)
Begin
	UPDATE productos set stock = (cantidadStockActual - cantidadStockARetirar) where nombre like nombreProducto;
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE realizarPedido(fechaPedido varchar(21),codRestaurante int)
BEGIN
	INSERT INTO pedidos (fecha,restaurante) VALUES (fechaPedido,codRestaurante);
END $
DELIMITER ;

DELIMITER $ 
CREATE PROCEDURE anadirPedidosProductos(codPedido int, codProducto int,unidades int) 
BEGIN
	INSERT INTO pedidosProductos (pedido,producto,unidades) VALUES (codPedido,codProducto,unidades);
END $
DELIMITER ;

/*Usuarios*/
CREATE USER 'restaurante'@'localhost' IDENTIFIED BY 'restaurante';
GRANT SELECT ON cadenarestaurantes.vista_lista_categorias TO 'restaurante'@'localhost';
GRANT SELECT ON cadenarestaurantes.vista_stocks TO 'restaurante'@'localhost';
GRANT SELECT ON cadenarestaurantes.lista_caracteristicas_producto TO 'restaurante'@'localhost';
GRANT SELECT ON cadenarestaurantes.lista_caracteristicas_categoria TO 'restaurante'@'localhost';
GRANT SELECT ON cadenarestaurantes.vista_nombres_producto TO 'restaurante'@'localhost';
GRANT EXECUTE ON PROCEDURE cadenarestaurantes.mostrarCategoriaPorNombre to 'restaurante'@'localhost';
GRANT EXECUTE ON PROCEDURE cadenarestaurantes.mostrarTodosLosProductosCategoria to 'restaurante'@'localhost';
-- DROP USER 'restaurante'@'localhost';

CREATE USER 'administrador'@'localhost' IDENTIFIED BY 'administrador';
GRANT ALL PRIVILEGES ON * . * TO 'administrador'@'localhost';
