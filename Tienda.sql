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