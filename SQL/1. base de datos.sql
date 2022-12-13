/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 16.0 		*/
/*  Created On : 13-dic.-2022 02:28:07 p. m. 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Sequences for Autonumber Columns */

 

 

 

 

 

 

 

 

 

 

/* Drop Tables */

DROP TABLE IF EXISTS Calificacion CASCADE
;

DROP TABLE IF EXISTS Ciudad CASCADE
;

DROP TABLE IF EXISTS Ciudad_Tarifa CASCADE
;

DROP TABLE IF EXISTS Cliente CASCADE
;

DROP TABLE IF EXISTS Horario CASCADE
;

DROP TABLE IF EXISTS Indicación CASCADE
;

DROP TABLE IF EXISTS Mensajero CASCADE
;

DROP TABLE IF EXISTS Pago_Mensajero CASCADE
;

DROP TABLE IF EXISTS Pago_Servicio CASCADE
;

DROP TABLE IF EXISTS Servicio CASCADE
;

DROP TABLE IF EXISTS Tarifa CASCADE
;

/* Create Tables */

CREATE TABLE Calificacion
(
	v_valor integer NOT NULL,	-- valor de la calificacion
	n_descripcion varchar(150) NULL,	-- comentario que el usuario agrega a la calificacion
	k_idCalificacion bigint NOT NULL,
	k_idServicio smallserial NOT NULL
)
;

CREATE TABLE Ciudad
(
	k_codPostal integer NOT NULL,
	n_nombre varchar(20) NOT NULL,
	t_comision numeric(5,2) NOT NULL
)
;

CREATE TABLE Ciudad_Tarifa
(
	k_codPostal integer NOT NULL,
	k_codigo smallserial NOT NULL
)
;

CREATE TABLE Cliente
(
	k_documentoCliente bigint NOT NULL,
	n_tipoDeDocumentoCliente varchar(4) NOT NULL,
	n_nombres varchar(50) NOT NULL,
	n_apellidos varchar(50) NOT NULL,
	f_fechaDeNacimiento date NOT NULL,
	q_numeroTelefono bigint NOT NULL,
	i_direccion varchar(50) NOT NULL,
	o_correo varchar(50) NOT NULL,
	i_contrasenia varchar(40) NOT NULL,
	i_sexo varchar(1) NOT NULL
)
;

CREATE TABLE Horario
(
	k_codigo smallserial NOT NULL,
	n_dia varchar(10) NOT NULL,
	f_horaInicio time without time zone NOT NULL,
	f_horaFin time without time zone NOT NULL,
	k_documentoMensajero bigint NOT NULL,
	n_tipoDocumentoMensajero varchar(4) NOT NULL
)
;

CREATE TABLE Indicación
(
	k_numero smallserial NOT NULL,
	o_direccion varchar(50) NOT NULL,
	n_descripcion varchar(200) NOT NULL,
	k_idServicio smallserial NOT NULL
)
;

CREATE TABLE Mensajero
(
	k_documentoMensajero bigint NOT NULL,
	n_tipoDocumentoMensajero varchar(4) NOT NULL,
	n_nombres varchar(50) NOT NULL,
	n_apellidos varchar(50) NOT NULL,
	f_fechaDeNacimiento date NOT NULL,
	k_numeroDeTelefono bigint NOT NULL,
	o_correo varchar(50) NOT NULL,
	n_sexo varchar(1) NOT NULL,
	n_seguridadSocial varchar(2) NOT NULL,
	n_placaVehiculo varchar(6) NOT NULL,
	i_tipoVehiculo varchar(1) NOT NULL,
	o_direccion varchar(40) NOT NULL,
	n_nacionalidad varchar(20) NOT NULL
)
;

CREATE TABLE Pago_Mensajero
(
	k_codigoPago serial NOT NULL,
	o_valorDePago numeric(10,3) NOT NULL,
	f_fechaInicio date NOT NULL,
	f_fechaFin date NOT NULL,
	i_estado char(1) NOT NULL,
	k_documentoMensajero bigint NOT NULL,
	n_tipoDocumentoMensajero varchar(4) NOT NULL
)
;

CREATE TABLE Pago_Servicio
(
	k_codigoPago serial NOT NULL,
	f_fecha date NOT NULL,
	n_metodoPago varchar(10) NOT NULL,
	k_idServicio smallserial NOT NULL
)
;

CREATE TABLE Servicio
(
	k_idServicio smallserial NOT NULL,
	f_fechaServicio date NOT NULL,
	f_horaInicio time(6) without time zone NOT NULL,
	f_horaFin time(6) without time zone NULL,
	n_tipoPaquete varchar(1) NOT NULL,
	i_estado varchar(1) NOT NULL,
	v_costo numeric(10,3) NOT NULL,
	i_idaVuelta varchar(2) NOT NULL,
	k_codPostal integer NOT NULL,
	k_documentoCliente bigint NOT NULL,
	n_tipoDeDocumentoCliente varchar(4) NOT NULL,
	k_documentoMensajero bigint NOT NULL,
	n_tipoDocumentoMensajero varchar(4) NOT NULL
)
;

CREATE TABLE Tarifa
(
	k_codigo smallserial NOT NULL,
	n_tipoPaquete char(1) NOT NULL,
	v_tarifaPaquete numeric(9,2) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE Calificacion ADD CONSTRAINT PK_Calificacion
	PRIMARY KEY (k_idCalificacion)
;

ALTER TABLE Calificacion ADD CONSTRAINT checkValor CHECK (0 <= v_valor and v_valor <= 5)
;

ALTER TABLE Ciudad ADD CONSTRAINT PK_Ciudad
	PRIMARY KEY (k_codPostal)
;

ALTER TABLE Ciudad 
  ADD CONSTRAINT CiudadUnico UNIQUE (k_codPostal)
;

ALTER TABLE Ciudad_Tarifa ADD CONSTRAINT PK_Ciudad_Tarifa
	PRIMARY KEY (k_codigo,k_codPostal)
;

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente
	PRIMARY KEY (k_documentoCliente,n_tipoDeDocumentoCliente)
;

ALTER TABLE Cliente 
  ADD CONSTRAINT ClienteUnico UNIQUE (k_documentoCliente)
;

ALTER TABLE Horario ADD CONSTRAINT PK_Horario
	PRIMARY KEY (k_codigo)
;

ALTER TABLE Horario 
  ADD CONSTRAINT HorarioUnico UNIQUE (k_codigo)
;

ALTER TABLE Indicación ADD CONSTRAINT PK_Indicación
	PRIMARY KEY (k_numero)
;

ALTER TABLE Indicación 
  ADD CONSTRAINT IndicacionUnico UNIQUE (k_numero)
;

ALTER TABLE Mensajero ADD CONSTRAINT PK_Mensajero
	PRIMARY KEY (n_tipoDocumentoMensajero,k_documentoMensajero)
;

ALTER TABLE Mensajero 
  ADD CONSTRAINT MensajeroUnico UNIQUE (k_documentoMensajero)
;

ALTER TABLE Pago_Mensajero ADD CONSTRAINT PK_Pago_Mensajero
	PRIMARY KEY (k_codigoPago)
;

ALTER TABLE Pago_Mensajero 
  ADD CONSTRAINT PagoMUnico UNIQUE (k_codigoPago)
;

ALTER TABLE Pago_Mensajero ADD CONSTRAINT checkPago CHECK (0 < o_valorDePago)
;

ALTER TABLE Pago_Servicio ADD CONSTRAINT PK_Pago_Servicio
	PRIMARY KEY (k_codigoPago)
;

ALTER TABLE Pago_Servicio 
  ADD CONSTRAINT PagoSUnico UNIQUE (k_codigoPago)
;

ALTER TABLE Servicio ADD CONSTRAINT PK_Servicio
	PRIMARY KEY (k_idServicio)
;

ALTER TABLE Servicio 
  ADD CONSTRAINT ServicioUnico UNIQUE (k_idServicio)
;

ALTER TABLE Tarifa ADD CONSTRAINT PK_Tarifa
	PRIMARY KEY (k_codigo)
;

ALTER TABLE Tarifa 
  ADD CONSTRAINT TarifaUnico UNIQUE (k_codigo)
;

/* Create Foreign Key Constraints */

ALTER TABLE Calificacion ADD CONSTRAINT FK_Calificacion_Servicio
	FOREIGN KEY (k_idServicio) REFERENCES Servicio (k_idServicio) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Ciudad_Tarifa ADD CONSTRAINT FK_Ciudad_Tarifa_Ciudad
	FOREIGN KEY (k_codPostal) REFERENCES Ciudad (k_codPostal) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Ciudad_Tarifa ADD CONSTRAINT FK_Ciudad_Tarifa_Tarifa
	FOREIGN KEY (k_codigo) REFERENCES Tarifa (k_codigo) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Horario ADD CONSTRAINT FK_Horario_Mensajero
	FOREIGN KEY (n_tipoDocumentoMensajero,k_documentoMensajero) REFERENCES Mensajero (n_tipoDocumentoMensajero,k_documentoMensajero) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Indicación ADD CONSTRAINT FK_Indicación_Servicio
	FOREIGN KEY (k_idServicio) REFERENCES Servicio (k_idServicio) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Pago_Mensajero ADD CONSTRAINT FK_Pago_Mensajero_Mensajero
	FOREIGN KEY (n_tipoDocumentoMensajero,k_documentoMensajero) REFERENCES Mensajero (n_tipoDocumentoMensajero,k_documentoMensajero) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Pago_Servicio ADD CONSTRAINT FK_Pago_Servicio_Servicio
	FOREIGN KEY (k_idServicio) REFERENCES Servicio (k_idServicio) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Servicio ADD CONSTRAINT FK_Servicio_Ciudad
	FOREIGN KEY (k_codPostal) REFERENCES Ciudad (k_codPostal) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Servicio ADD CONSTRAINT FK_Servicio_Cliente
	FOREIGN KEY (k_documentoCliente,n_tipoDeDocumentoCliente) REFERENCES Cliente (k_documentoCliente,n_tipoDeDocumentoCliente) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Servicio ADD CONSTRAINT FK_Servicio_Mensajero
	FOREIGN KEY (n_tipoDocumentoMensajero,k_documentoMensajero) REFERENCES Mensajero (n_tipoDocumentoMensajero,k_documentoMensajero) ON DELETE No Action ON UPDATE No Action
;

/* Create Table Comments, Sequences for Autonumber Columns */

COMMENT ON COLUMN Calificacion.v_valor
	IS 'valor de la calificacion'
;

COMMENT ON COLUMN Calificacion.n_descripcion
	IS 'comentario que el usuario agrega a la calificacion'
;

 

 

 

 

 

 

 

 

 

 
