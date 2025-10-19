CREATE TABLE `movimientos_tipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `gasto_ingreso` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `imputable_contrato` tinyint(1) DEFAULT NULL,
  `imputable_inmueble` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;



INSERT INTO movimientos_tipo (nombre,activo,gasto_ingreso,imputable_contrato,imputable_inmueble) VALUES
	 ('Gasto imputable a contrato',1,'G',1,0),
	 ('Cobro factura',1,'I',1,0),
	 ('Gasto no imputable a contrato',1,'G',0,1),
	 ('Ingreso no imputable a contrato',1,'I',0,1),
	 ('IBI',1,'G',0,1),
	 ('Seguros',1,'G',0,1),
	 ('Ingreso imputable a contrato',1,'I',1,0),
	 ('Comunidad de propietarios',1,'G',0,1),
	 ('Hipoteca',1,'G',0,1),
	 ('Impuestos excepto IBI',1,'G',0,0),
	 ('Comunidad bienes',1,'I',0,0),
	 ('Sueldos',1,'G',0,0),
	 ('Pago factura',1,'G',0,1),
	 ('Pendiente Clasificar',1,'T',0,0),
	 ('Traspasos Internos',1,'T',0,0),
	 ('Fianza',1,'T',0,0),
	 ('Para generar nota gasto',1,'G',1,NULL),
	 ('Cobro nota gasto',1,'I',1,0);


