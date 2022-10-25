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
    fecha varchar(10),
    enviado boolean,
    restaurante int not null,
	foreign key(restaurante) references restaurantes (codRes)
);
create table categorias(
	codCat int primary key auto_increment,
    nombre varchar(40) unique,
    descripcion varchar(40)
);
create table productos (
	codProd int auto_increment primary key,
    nombre varchar(40),
    descripcion varchar(60),
    peso double,
    stock int,
    categoria int,
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

insert into categorias values(1, "Pasta", "Si");
insert into categorias values(2, "Vegetariano", "No");
insert into categorias values(3, "Guiso", "No");
insert into categorias values(4, "Mexicano", "No");
select * from productos;

insert into productos values(1, "Macarrones", "Si", 2.00, 5, 1);
insert into productos values(2, "Espaguetis", "Si", 2.00, 5, 1);
insert into productos values(3, "Espinacas", "Si", 2.00, 5, 2);
insert into productos values(4, "Acelgas", "Si", 2.00, 5, 2);

/*Vistas*/
create view vista_lista_categorias as select * from categorias;
select * from vista_lista_categorias;

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


/*Usuarios*/
CREATE USER 'restaurante'@'localhost' IDENTIFIED BY 'restaurante';
GRANT ALL PRIVILEGES ON * . * TO 'restaurante'@'localhost';

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';
