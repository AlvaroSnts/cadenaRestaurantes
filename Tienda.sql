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
    foto Blob ,
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
insert into categorias values(2, "Vegetales", "No");
insert into categorias values(3, "Legumbres", "No");
insert into categorias values(4, "Carnes", "No");
insert into categorias values(5,"Especias", null);
insert into restaurantes values(1, "hola@gmail.com", md5("123"), "España", 28900, "Getafe", "Calle hola");
insert into restaurantes values(2, "adios@gmail.com", md5("abc"), "España", 28900, "Getafe", "Calle adios");
insert into productos (nombre,descripcion,peso,stock,categoria)values("Macarrones", "Si", 2.00, 0, 1);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Espaguetis", "Si", 2.00, 5, 1);
insert into productos(nombre,descripcion,peso,stock,categoria) values("Espinacas", "Si", 2.00, 5, 2);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Acelgas", "Si", 2.00, 10, 2);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Garbanzos", "Si", 2.00, 4, 3);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Judias", "Si", 2.00, 7, 3);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Filete de ternera", "Si", 2.00, 8, 4);
insert into productos (nombre,descripcion,peso,stock,categoria)values("Filete de Pollo", "Si", 2.00, 6, 4);

/*Vistas*/
create view vista_lista_categorias as select * from categorias;
create view vista_stocks as select nombre,stock from productos;
create view lista_caracteristicas_producto as select nombre,descripcion,peso,stock from productos;
create view lista_caracteristicas_categoria as select nombre,descripcion from categorias;
create view lista_fotos as select nombre,foto from productos;
create view vista_nombres_producto as select * from productos;
select * from productos;
select * from restaurantes;
select * from pedidos;
select * from pedidosProductos;



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

CREATE USER 'administrador'@'localhost' IDENTIFIED BY 'administrador';
GRANT ALL PRIVILEGES ON * . * TO 'administrador'@'localhost';