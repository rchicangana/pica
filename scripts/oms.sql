--------------------------------------------------------
-- Archivo creado  - domingo-septiembre-02-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUDITORIA_VENTAS
--------------------------------------------------------

  CREATE TABLE "AUDITORIA_VENTAS" 
   (	"ID_AUDITORIA" NUMBER(18,0), 
	"FECHA_ACCION" DATE, 
	"ID_PRODUCTO" NUMBER(18,0)
   )
--------------------------------------------------------
--  DDL for Table CAMPANNA
--------------------------------------------------------

  CREATE TABLE "CAMPANNA" 
   (	"ID_CAMPANNA" NUMBER(18,0), 
	"NOMBRE_CAMPANNA" VARCHAR2(200), 
	"FECHA_CAMPANNA" DATE, 
	"FECHA_VENCIMEINTO" DATE, 
	"ID_PRODUCTO" NUMBER(18,0)
   )
--------------------------------------------------------
--  DDL for Table CIUDAD
--------------------------------------------------------

  CREATE TABLE "CIUDAD" 
   (	"ID_CIUDAD" NUMBER(18,0), 
	"NOMBRE" VARCHAR2(300), 
	"ID_PAIS" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table CONSTANTES
--------------------------------------------------------

  CREATE TABLE "CONSTANTES" 
   (	"NOMBRE" VARCHAR2(50), 
	"VALOR" VARCHAR2(100), 
	"ESTADO" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table DETALLE_ORDEN_COMPRA
--------------------------------------------------------

  CREATE TABLE "DETALLE_ORDEN_COMPRA" 
   (	"ID_DETALLE_ORDEN" NUMBER(18,0), 
	"NO_ORDEN" NUMBER(18,0), 
	"ID_PRODUCTO" NUMBER(18,0), 
	"VALOR" NUMBER(18,2)
   )
--------------------------------------------------------
--  DDL for Table EMPRESA
--------------------------------------------------------

  CREATE TABLE "EMPRESA" 
   (	"ID_EMPRESA" VARCHAR2(15), 
	"NOMBRE" VARCHAR2(200), 
	"URL_ENDPOINT" VARCHAR2(200)
   )
--------------------------------------------------------
--  DDL for Table ESTADO_ORDEN_COMPRA
--------------------------------------------------------

  CREATE TABLE "ESTADO_ORDEN_COMPRA" 
   (	"ID_ESTADO_ORDEN_COMPRA" NUMBER(10,0), 
	"ESTADO" VARCHAR2(60)
   )
--------------------------------------------------------
--  DDL for Table ESTADO_TIPO_PRODUCTO
--------------------------------------------------------

  CREATE TABLE "ESTADO_TIPO_PRODUCTO" 
   (	"ID_ESTADO_TIPO_PRODUCTO" NUMBER(10,0), 
	"ESTADO" VARCHAR2(200)
   )
--------------------------------------------------------
--  DDL for Table ESTADO_TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "ESTADO_TRANSPORTE" 
   (	"ID_ESTADO_TRANSPORTE" NUMBER(10,0), 
	"ESTADO" VARCHAR2(90)
   )
--------------------------------------------------------
--  DDL for Table ESTADO_USER
--------------------------------------------------------

  CREATE TABLE "ESTADO_USER" 
   (	"ID_ESTADO_USER" NUMBER(10,0), 
	"ESTADO" VARCHAR2(100)
   )
--------------------------------------------------------
--  DDL for Table HABITACION
--------------------------------------------------------

  CREATE TABLE "HABITACION" 
   (	"ID_HABITACION" NUMBER(18,0), 
	"ID_TIPO_HABITACION" NUMBER(10,0), 
	"ID_HOSPEDAJE" NUMBER(18,0), 
	"NUMERO" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table HOSPEDAJE
--------------------------------------------------------

  CREATE TABLE "HOSPEDAJE" 
   (	"ID_HOSPEDAJE" NUMBER(18,0), 
	"NOMBRE" VARCHAR2(200), 
	"ESTRELLAS" NUMBER(10,0), 
	"ID_CIUDAD" NUMBER(18,0)
   )
--------------------------------------------------------
--  DDL for Table IMAGEN_HABITACION
--------------------------------------------------------

  CREATE TABLE "IMAGEN_HABITACION" 
   (	"ID_IMAGEN_HABITACION" NUMBER(10,0), 
	"ID_HABITACION" NUMBER(10,0), 
	"IMAGEN" VARCHAR2(200), 
	"ESPRINCIPAL" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table IMAGEN_HOSPEDAJE
--------------------------------------------------------

  CREATE TABLE "IMAGEN_HOSPEDAJE" 
   (	"ID_IMAGEN_HOSPEDAJE" NUMBER(10,0), 
	"ID_HOSPEDAJE" NUMBER(18,0), 
	"IMAGEN" VARCHAR2(200), 
	"ESPRINCIPAL" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table IMAGEN_PRODUCTO
--------------------------------------------------------

  CREATE TABLE "IMAGEN_PRODUCTO" 
   (	"ID_IMAGEN_PRODUCTO" NUMBER(18,0), 
	"IMAGEN" VARCHAR2(200), 
	"ESPRINCIPAL" NUMBER(10,0), 
	"ID_PRODUCTO" NUMBER(18,0)
   )
--------------------------------------------------------
--  DDL for Table ITINERARIO
--------------------------------------------------------

  CREATE TABLE "ITINERARIO" 
   (	"ID_ITINERARIO" NUMBER(18,0), 
	"ID_PRODUCTO" NUMBER(18,0), 
	"ID_HOSPEDAJE" NUMBER(18,0), 
	"ID_CIUDAD" NUMBER(18,0)
   )
--------------------------------------------------------
--  DDL for Table LOG_CONSUMI_WS
--------------------------------------------------------

  CREATE TABLE "LOG_CONSUMI_WS" 
   (	"ID" NUMBER(18,0), 
	"FECHA_ACCION" DATE, 
	"IP" VARCHAR2(50), 
	"END_POINT" VARCHAR2(300), 
	"REQUEST" VARCHAR2(300), 
	"RESPONSE" VARCHAR2(300), 
	"USER_ID" VARCHAR2(30)
   )
--------------------------------------------------------
--  DDL for Table ORDEN_COMPRA
--------------------------------------------------------

  CREATE TABLE "ORDEN_COMPRA" 
   (	"NO_ORDEN" NUMBER(18,0), 
	"FECHA_CREACION" DATE, 
	"FECHA_VENCIMIENTO" DATE, 
	"NUMERO_SOLICITUD" NUMBER(18,0), 
	"VALOR_TOTAL" NUMBER(18,2), 
	"ID_ESTADO_ORDEN_COMPRA" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table PAIS
--------------------------------------------------------

  CREATE TABLE "PAIS" 
   (	"ID_PAIS" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(300)
   )
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PRODUCTO" 
   (	"ID_PRODUCTO" NUMBER(18,0), 
	"NOMBRE_PRODUCTO" VARCHAR2(200), 
	"ID_TIPO_PRODUCTO" NUMBER(18,0), 
	"FECHA_SALIDA" DATE, 
	"FECHA_LLEGADA" DATE
   )
--------------------------------------------------------
--  DDL for Table RUTA
--------------------------------------------------------

  CREATE TABLE "RUTA" 
   (	"ID_RUTA" NUMBER(18,0), 
	"ID_EMPRESA" VARCHAR2(15), 
	"ID_CIUDAD_ORIGEN" NUMBER(6,0), 
	"ID_CIUDAD_DESTINO" NUMBER(6,0), 
	"DESCRIPCION" VARCHAR2(200)
   )
--------------------------------------------------------
--  DDL for Table TARIFA_HOSPEDAJE
--------------------------------------------------------

  CREATE TABLE "TARIFA_HOSPEDAJE" 
   (	"ID_TARIFA_HOSPEDAJE" NUMBER(18,0), 
	"PRECIO" NUMBER(18,2), 
	"ID_HABITACION" NUMBER(10,0), 
	"FECHA_VIGENCIA" DATE
   )
--------------------------------------------------------
--  DDL for Table TARIFA_TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "TARIFA_TRANSPORTE" 
   (	"ID_TARIFA_TRANSPORTE" NUMBER(18,0), 
	"PRECIO" NUMBER(18,2), 
	"FECHA_VIGENCIA" DATE, 
	"ID_RUTA" NUMBER(18,0)
   )
--------------------------------------------------------
--  DDL for Table TIPO_HABITACION
--------------------------------------------------------

  CREATE TABLE "TIPO_HABITACION" 
   (	"ID_TIPO_HABITACION" NUMBER(10,0), 
	"TIPO" VARCHAR2(200)
   )
--------------------------------------------------------
--  DDL for Table TIPO_PRODUCTO
--------------------------------------------------------

  CREATE TABLE "TIPO_PRODUCTO" 
   (	"ID_TIPO_PRODUCTO" NUMBER(18,0), 
	"NOMBRE" VARCHAR2(200), 
	"ID_ESTADO_TIPO_PRODUCTO" NUMBER(10,0)
   )
--------------------------------------------------------
--  DDL for Table TIPO_TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "TIPO_TRANSPORTE" 
   (	"ID_TIPO_TRANSPORTE" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(200)
   )
--------------------------------------------------------
--  DDL for Table TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "TRANSPORTE" 
   (	"ID_TRANSPORTE" NUMBER(18,0), 
	"ID_TIPO_TRANSPORTE" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(200), 
	"ID_EMPRESA" VARCHAR2(15), 
	"ID_ESTADO_TRANSPORTE" NUMBER(10,0)
   )
REM INSERTING into AUDITORIA_VENTAS
SET DEFINE OFF;
REM INSERTING into CAMPANNA
SET DEFINE OFF;
REM INSERTING into CIUDAD
SET DEFINE OFF;
REM INSERTING into CONSTANTES
SET DEFINE OFF;
REM INSERTING into DETALLE_ORDEN_COMPRA
SET DEFINE OFF;
REM INSERTING into EMPRESA
SET DEFINE OFF;
REM INSERTING into ESTADO_ORDEN_COMPRA
SET DEFINE OFF;
REM INSERTING into ESTADO_TIPO_PRODUCTO
SET DEFINE OFF;
REM INSERTING into ESTADO_TRANSPORTE
SET DEFINE OFF;
REM INSERTING into ESTADO_USER
SET DEFINE OFF;
REM INSERTING into HABITACION
SET DEFINE OFF;
REM INSERTING into HOSPEDAJE
SET DEFINE OFF;
REM INSERTING into IMAGEN_HABITACION
SET DEFINE OFF;
REM INSERTING into IMAGEN_HOSPEDAJE
SET DEFINE OFF;
REM INSERTING into IMAGEN_PRODUCTO
SET DEFINE OFF;
REM INSERTING into ITINERARIO
SET DEFINE OFF;
REM INSERTING into LOG_CONSUMI_WS
SET DEFINE OFF;
REM INSERTING into ORDEN_COMPRA
SET DEFINE OFF;
REM INSERTING into PAIS
SET DEFINE OFF;
REM INSERTING into PRODUCTO
SET DEFINE OFF;
REM INSERTING into RUTA
SET DEFINE OFF;
REM INSERTING into TARIFA_HOSPEDAJE
SET DEFINE OFF;
REM INSERTING into TARIFA_TRANSPORTE
SET DEFINE OFF;
REM INSERTING into TIPO_HABITACION
SET DEFINE OFF;
REM INSERTING into TIPO_PRODUCTO
SET DEFINE OFF;
REM INSERTING into TIPO_TRANSPORTE
SET DEFINE OFF;
REM INSERTING into TRANSPORTE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index CONSTANTES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CONSTANTES_PK" ON "CONSTANTES" ("NOMBRE", "VALOR", "ESTADO")
--------------------------------------------------------
--  DDL for Index SYS_C007712
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007712" ON "AUDITORIA_VENTAS" ("ID_AUDITORIA")
--------------------------------------------------------
--  DDL for Index SYS_C007684
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007684" ON "CAMPANNA" ("ID_CAMPANNA")
--------------------------------------------------------
--  DDL for Index SYS_C007614
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007614" ON "CIUDAD" ("ID_CIUDAD")
--------------------------------------------------------
--  DDL for Index SYS_C007700
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007700" ON "DETALLE_ORDEN_COMPRA" ("ID_DETALLE_ORDEN")
--------------------------------------------------------
--  DDL for Index SYS_C007619
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007619" ON "EMPRESA" ("ID_EMPRESA")
--------------------------------------------------------
--  DDL for Index SYS_C007687
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007687" ON "ESTADO_ORDEN_COMPRA" ("ID_ESTADO_ORDEN_COMPRA")
--------------------------------------------------------
--  DDL for Index SYS_C007641
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007641" ON "ESTADO_TIPO_PRODUCTO" ("ID_ESTADO_TIPO_PRODUCTO")
--------------------------------------------------------
--  DDL for Index SYS_C007609
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007609" ON "ESTADO_TRANSPORTE" ("ID_ESTADO_TRANSPORTE")
--------------------------------------------------------
--  DDL for Index SYS_C007723
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007723" ON "ESTADO_USER" ("ID_ESTADO_USER")
--------------------------------------------------------
--  DDL for Index SYS_C007677
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007677" ON "HABITACION" ("ID_HABITACION")
--------------------------------------------------------
--  DDL for Index SYS_C007656
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007656" ON "HOSPEDAJE" ("ID_HOSPEDAJE")
--------------------------------------------------------
--  DDL for Index SYS_C007751
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007751" ON "IMAGEN_HABITACION" ("ID_IMAGEN_HABITACION")
--------------------------------------------------------
--  DDL for Index SYS_C007662
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007662" ON "IMAGEN_HOSPEDAJE" ("ID_IMAGEN_HOSPEDAJE")
--------------------------------------------------------
--  DDL for Index SYS_C007707
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007707" ON "IMAGEN_PRODUCTO" ("ID_IMAGEN_PRODUCTO")
--------------------------------------------------------
--  DDL for Index SYS_C007668
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007668" ON "ITINERARIO" ("ID_ITINERARIO")
--------------------------------------------------------
--  DDL for Index SYS_C007716
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007716" ON "LOG_CONSUMI_WS" ("ID")
--------------------------------------------------------
--  DDL for Index SYS_C007694
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007694" ON "ORDEN_COMPRA" ("NO_ORDEN")
--------------------------------------------------------
--  DDL for Index SYS_C007611
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007611" ON "PAIS" ("ID_PAIS")
--------------------------------------------------------
--  DDL for Index SYS_C007650
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007650" ON "PRODUCTO" ("ID_PRODUCTO")
--------------------------------------------------------
--  DDL for Index SYS_C007631
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007631" ON "RUTA" ("ID_RUTA")
--------------------------------------------------------
--  DDL for Index SYS_C007757
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007757" ON "TARIFA_HOSPEDAJE" ("ID_TARIFA_HOSPEDAJE")
--------------------------------------------------------
--  DDL for Index SYS_C007638
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007638" ON "TARIFA_TRANSPORTE" ("ID_TARIFA_TRANSPORTE")
--------------------------------------------------------
--  DDL for Index SYS_C007672
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007672" ON "TIPO_HABITACION" ("ID_TIPO_HABITACION")
--------------------------------------------------------
--  DDL for Index SYS_C007644
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007644" ON "TIPO_PRODUCTO" ("ID_TIPO_PRODUCTO")
--------------------------------------------------------
--  DDL for Index SYS_C007617
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007617" ON "TIPO_TRANSPORTE" ("ID_TIPO_TRANSPORTE")
--------------------------------------------------------
--  DDL for Index SYS_C007623
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007623" ON "TRANSPORTE" ("ID_TRANSPORTE")
--------------------------------------------------------
--  Constraints for Table AUDITORIA_VENTAS
--------------------------------------------------------

  ALTER TABLE "AUDITORIA_VENTAS" MODIFY ("ID_AUDITORIA" NOT NULL ENABLE)
  ALTER TABLE "AUDITORIA_VENTAS" MODIFY ("FECHA_ACCION" NOT NULL ENABLE)
  ALTER TABLE "AUDITORIA_VENTAS" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "AUDITORIA_VENTAS" ADD PRIMARY KEY ("ID_AUDITORIA")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table CAMPANNA
--------------------------------------------------------

  ALTER TABLE "CAMPANNA" MODIFY ("ID_CAMPANNA" NOT NULL ENABLE)
  ALTER TABLE "CAMPANNA" MODIFY ("NOMBRE_CAMPANNA" NOT NULL ENABLE)
  ALTER TABLE "CAMPANNA" MODIFY ("FECHA_CAMPANNA" NOT NULL ENABLE)
  ALTER TABLE "CAMPANNA" MODIFY ("FECHA_VENCIMEINTO" NOT NULL ENABLE)
  ALTER TABLE "CAMPANNA" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "CAMPANNA" ADD PRIMARY KEY ("ID_CAMPANNA")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table CIUDAD
--------------------------------------------------------

  ALTER TABLE "CIUDAD" MODIFY ("ID_CIUDAD" NOT NULL ENABLE)
  ALTER TABLE "CIUDAD" MODIFY ("ID_PAIS" NOT NULL ENABLE)
  ALTER TABLE "CIUDAD" ADD PRIMARY KEY ("ID_CIUDAD")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table CONSTANTES
--------------------------------------------------------

  ALTER TABLE "CONSTANTES" MODIFY ("NOMBRE" NOT NULL ENABLE)
  ALTER TABLE "CONSTANTES" MODIFY ("VALOR" NOT NULL ENABLE)
  ALTER TABLE "CONSTANTES" MODIFY ("ESTADO" NOT NULL ENABLE)
  ALTER TABLE "CONSTANTES" ADD CONSTRAINT "CONSTANTES_PK" PRIMARY KEY ("NOMBRE", "VALOR", "ESTADO")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table DETALLE_ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "DETALLE_ORDEN_COMPRA" MODIFY ("ID_DETALLE_ORDEN" NOT NULL ENABLE)
  ALTER TABLE "DETALLE_ORDEN_COMPRA" MODIFY ("NO_ORDEN" NOT NULL ENABLE)
  ALTER TABLE "DETALLE_ORDEN_COMPRA" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "DETALLE_ORDEN_COMPRA" MODIFY ("VALOR" NOT NULL ENABLE)
  ALTER TABLE "DETALLE_ORDEN_COMPRA" ADD PRIMARY KEY ("ID_DETALLE_ORDEN")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table EMPRESA
--------------------------------------------------------

  ALTER TABLE "EMPRESA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE)
  ALTER TABLE "EMPRESA" ADD PRIMARY KEY ("ID_EMPRESA")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table ESTADO_ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "ESTADO_ORDEN_COMPRA" MODIFY ("ID_ESTADO_ORDEN_COMPRA" NOT NULL ENABLE)
  ALTER TABLE "ESTADO_ORDEN_COMPRA" ADD PRIMARY KEY ("ID_ESTADO_ORDEN_COMPRA")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table ESTADO_TIPO_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "ESTADO_TIPO_PRODUCTO" MODIFY ("ID_ESTADO_TIPO_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "ESTADO_TIPO_PRODUCTO" ADD PRIMARY KEY ("ID_ESTADO_TIPO_PRODUCTO")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table ESTADO_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "ESTADO_TRANSPORTE" MODIFY ("ID_ESTADO_TRANSPORTE" NOT NULL ENABLE)
  ALTER TABLE "ESTADO_TRANSPORTE" ADD PRIMARY KEY ("ID_ESTADO_TRANSPORTE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table ESTADO_USER
--------------------------------------------------------

  ALTER TABLE "ESTADO_USER" MODIFY ("ID_ESTADO_USER" NOT NULL ENABLE)
  ALTER TABLE "ESTADO_USER" MODIFY ("ESTADO" NOT NULL ENABLE)
  ALTER TABLE "ESTADO_USER" ADD PRIMARY KEY ("ID_ESTADO_USER")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table HABITACION
--------------------------------------------------------

  ALTER TABLE "HABITACION" MODIFY ("ID_HABITACION" NOT NULL ENABLE)
  ALTER TABLE "HABITACION" MODIFY ("ID_TIPO_HABITACION" NOT NULL ENABLE)
  ALTER TABLE "HABITACION" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE)
  ALTER TABLE "HABITACION" MODIFY ("NUMERO" NOT NULL ENABLE)
  ALTER TABLE "HABITACION" ADD PRIMARY KEY ("ID_HABITACION")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "HOSPEDAJE" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE)
  ALTER TABLE "HOSPEDAJE" MODIFY ("NOMBRE" NOT NULL ENABLE)
  ALTER TABLE "HOSPEDAJE" MODIFY ("ESTRELLAS" NOT NULL ENABLE)
  ALTER TABLE "HOSPEDAJE" MODIFY ("ID_CIUDAD" NOT NULL ENABLE)
  ALTER TABLE "HOSPEDAJE" ADD PRIMARY KEY ("ID_HOSPEDAJE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table IMAGEN_HABITACION
--------------------------------------------------------

  ALTER TABLE "IMAGEN_HABITACION" MODIFY ("ID_IMAGEN_HABITACION" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HABITACION" MODIFY ("ID_HABITACION" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HABITACION" MODIFY ("IMAGEN" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HABITACION" MODIFY ("ESPRINCIPAL" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HABITACION" ADD PRIMARY KEY ("ID_IMAGEN_HABITACION")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table IMAGEN_HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "IMAGEN_HOSPEDAJE" MODIFY ("ID_IMAGEN_HOSPEDAJE" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HOSPEDAJE" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HOSPEDAJE" MODIFY ("IMAGEN" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HOSPEDAJE" MODIFY ("ESPRINCIPAL" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_HOSPEDAJE" ADD PRIMARY KEY ("ID_IMAGEN_HOSPEDAJE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table IMAGEN_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "IMAGEN_PRODUCTO" MODIFY ("ID_IMAGEN_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_PRODUCTO" MODIFY ("IMAGEN" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_PRODUCTO" MODIFY ("ESPRINCIPAL" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_PRODUCTO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "IMAGEN_PRODUCTO" ADD PRIMARY KEY ("ID_IMAGEN_PRODUCTO")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table ITINERARIO
--------------------------------------------------------

  ALTER TABLE "ITINERARIO" MODIFY ("ID_ITINERARIO" NOT NULL ENABLE)
  ALTER TABLE "ITINERARIO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "ITINERARIO" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE)
  ALTER TABLE "ITINERARIO" MODIFY ("ID_CIUDAD" NOT NULL ENABLE)
  ALTER TABLE "ITINERARIO" ADD PRIMARY KEY ("ID_ITINERARIO")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table LOG_CONSUMI_WS
--------------------------------------------------------

  ALTER TABLE "LOG_CONSUMI_WS" MODIFY ("ID" NOT NULL ENABLE)
  ALTER TABLE "LOG_CONSUMI_WS" MODIFY ("FECHA_ACCION" NOT NULL ENABLE)
  ALTER TABLE "LOG_CONSUMI_WS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "ORDEN_COMPRA" MODIFY ("NO_ORDEN" NOT NULL ENABLE)
  ALTER TABLE "ORDEN_COMPRA" MODIFY ("FECHA_CREACION" NOT NULL ENABLE)
  ALTER TABLE "ORDEN_COMPRA" MODIFY ("FECHA_VENCIMIENTO" NOT NULL ENABLE)
  ALTER TABLE "ORDEN_COMPRA" MODIFY ("NUMERO_SOLICITUD" NOT NULL ENABLE)
  ALTER TABLE "ORDEN_COMPRA" MODIFY ("VALOR_TOTAL" NOT NULL ENABLE)
  ALTER TABLE "ORDEN_COMPRA" MODIFY ("ID_ESTADO_ORDEN_COMPRA" NOT NULL ENABLE)
  ALTER TABLE "ORDEN_COMPRA" ADD PRIMARY KEY ("NO_ORDEN")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table PAIS
--------------------------------------------------------

  ALTER TABLE "PAIS" MODIFY ("ID_PAIS" NOT NULL ENABLE)
  ALTER TABLE "PAIS" ADD PRIMARY KEY ("ID_PAIS")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PRODUCTO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTO" MODIFY ("ID_TIPO_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTO" MODIFY ("FECHA_SALIDA" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTO" MODIFY ("FECHA_LLEGADA" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTO" ADD PRIMARY KEY ("ID_PRODUCTO")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table RUTA
--------------------------------------------------------

  ALTER TABLE "RUTA" MODIFY ("ID_RUTA" NOT NULL ENABLE)
  ALTER TABLE "RUTA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE)
  ALTER TABLE "RUTA" MODIFY ("ID_CIUDAD_ORIGEN" NOT NULL ENABLE)
  ALTER TABLE "RUTA" MODIFY ("ID_CIUDAD_DESTINO" NOT NULL ENABLE)
  ALTER TABLE "RUTA" ADD PRIMARY KEY ("ID_RUTA")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table TARIFA_HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "TARIFA_HOSPEDAJE" MODIFY ("ID_TARIFA_HOSPEDAJE" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_HOSPEDAJE" MODIFY ("PRECIO" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_HOSPEDAJE" MODIFY ("ID_HABITACION" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_HOSPEDAJE" MODIFY ("FECHA_VIGENCIA" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_HOSPEDAJE" ADD PRIMARY KEY ("ID_TARIFA_HOSPEDAJE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table TARIFA_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "TARIFA_TRANSPORTE" MODIFY ("ID_TARIFA_TRANSPORTE" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_TRANSPORTE" MODIFY ("PRECIO" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_TRANSPORTE" MODIFY ("ID_RUTA" NOT NULL ENABLE)
  ALTER TABLE "TARIFA_TRANSPORTE" ADD PRIMARY KEY ("ID_TARIFA_TRANSPORTE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table TIPO_HABITACION
--------------------------------------------------------

  ALTER TABLE "TIPO_HABITACION" MODIFY ("ID_TIPO_HABITACION" NOT NULL ENABLE)
  ALTER TABLE "TIPO_HABITACION" MODIFY ("TIPO" NOT NULL ENABLE)
  ALTER TABLE "TIPO_HABITACION" ADD PRIMARY KEY ("ID_TIPO_HABITACION")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table TIPO_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "TIPO_PRODUCTO" MODIFY ("ID_TIPO_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "TIPO_PRODUCTO" MODIFY ("ID_ESTADO_TIPO_PRODUCTO" NOT NULL ENABLE)
  ALTER TABLE "TIPO_PRODUCTO" ADD PRIMARY KEY ("ID_TIPO_PRODUCTO")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table TIPO_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "TIPO_TRANSPORTE" MODIFY ("ID_TIPO_TRANSPORTE" NOT NULL ENABLE)
  ALTER TABLE "TIPO_TRANSPORTE" ADD PRIMARY KEY ("ID_TIPO_TRANSPORTE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Constraints for Table TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "TRANSPORTE" MODIFY ("ID_TRANSPORTE" NOT NULL ENABLE)
  ALTER TABLE "TRANSPORTE" MODIFY ("ID_TIPO_TRANSPORTE" NOT NULL ENABLE)
  ALTER TABLE "TRANSPORTE" MODIFY ("ID_ESTADO_TRANSPORTE" NOT NULL ENABLE)
  ALTER TABLE "TRANSPORTE" ADD PRIMARY KEY ("ID_TRANSPORTE")
  USING INDEX  ENABLE
--------------------------------------------------------
--  Ref Constraints for Table AUDITORIA_VENTAS
--------------------------------------------------------

  ALTER TABLE "AUDITORIA_VENTAS" ADD CONSTRAINT "ID_PRODUCTO_FK_AUDITORIA_VENTAS" FOREIGN KEY ("ID_PRODUCTO")
	  REFERENCES "PRODUCTO" ("ID_PRODUCTO") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table CAMPANNA
--------------------------------------------------------

  ALTER TABLE "CAMPANNA" ADD CONSTRAINT "ID_PRODUCTO_FK_CAMPANNA" FOREIGN KEY ("ID_PRODUCTO")
	  REFERENCES "PRODUCTO" ("ID_PRODUCTO") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table CIUDAD
--------------------------------------------------------

  ALTER TABLE "CIUDAD" ADD CONSTRAINT "ID_PAIS_FK_CIUDAD" FOREIGN KEY ("ID_PAIS")
	  REFERENCES "PAIS" ("ID_PAIS") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table DETALLE_ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "DETALLE_ORDEN_COMPRA" ADD CONSTRAINT "ID_PRODUCTO_FK_DETALLE_ORDEN_COMPRA" FOREIGN KEY ("ID_PRODUCTO")
	  REFERENCES "PRODUCTO" ("ID_PRODUCTO") ENABLE
  ALTER TABLE "DETALLE_ORDEN_COMPRA" ADD CONSTRAINT "NO_ORDEN_FK_DETALLE_ORDEN_COMPRA" FOREIGN KEY ("NO_ORDEN")
	  REFERENCES "ORDEN_COMPRA" ("NO_ORDEN") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table HABITACION
--------------------------------------------------------

  ALTER TABLE "HABITACION" ADD CONSTRAINT "ID_TIPO_HABITACION_FK_HABITACION" FOREIGN KEY ("ID_TIPO_HABITACION")
	  REFERENCES "TIPO_HABITACION" ("ID_TIPO_HABITACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "HOSPEDAJE" ADD CONSTRAINT "ID_CIUDAD_FK_HOSPEDAJE" FOREIGN KEY ("ID_CIUDAD")
	  REFERENCES "CIUDAD" ("ID_CIUDAD") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table IMAGEN_HABITACION
--------------------------------------------------------

  ALTER TABLE "IMAGEN_HABITACION" ADD CONSTRAINT "ID_HABITACION_FK_IMAGEN_HABITACION" FOREIGN KEY ("ID_HABITACION")
	  REFERENCES "HABITACION" ("ID_HABITACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table IMAGEN_HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "IMAGEN_HOSPEDAJE" ADD CONSTRAINT "IMAGEN_HOSPEDAJE_FK_IMAGEN_HOSPEDAJE" FOREIGN KEY ("ID_HOSPEDAJE")
	  REFERENCES "HOSPEDAJE" ("ID_HOSPEDAJE") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table IMAGEN_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "IMAGEN_PRODUCTO" ADD CONSTRAINT "ID_PRODUCTO_FK_IMAGEN_IMAGEN_PRODUCTO" FOREIGN KEY ("ID_PRODUCTO")
	  REFERENCES "PRODUCTO" ("ID_PRODUCTO") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table ITINERARIO
--------------------------------------------------------

  ALTER TABLE "ITINERARIO" ADD CONSTRAINT "ID_CIUDAD_FK_ITINERARIO" FOREIGN KEY ("ID_CIUDAD")
	  REFERENCES "CIUDAD" ("ID_CIUDAD") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "ORDEN_COMPRA" ADD CONSTRAINT "ID_ESTADO_ORDEN_COMPRA_FK_ORDEN_COMPRA" FOREIGN KEY ("ID_ESTADO_ORDEN_COMPRA")
	  REFERENCES "ESTADO_ORDEN_COMPRA" ("ID_ESTADO_ORDEN_COMPRA") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PRODUCTO" ADD CONSTRAINT "ID_TIPO_PRODUCTO_FK_PRODUCTO" FOREIGN KEY ("ID_TIPO_PRODUCTO")
	  REFERENCES "TIPO_PRODUCTO" ("ID_TIPO_PRODUCTO") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table RUTA
--------------------------------------------------------

  ALTER TABLE "RUTA" ADD CONSTRAINT "ID_EMPRESA_FK_RUTA" FOREIGN KEY ("ID_EMPRESA")
	  REFERENCES "EMPRESA" ("ID_EMPRESA") ENABLE
  ALTER TABLE "RUTA" ADD CONSTRAINT "ID_CIUDAD_ORIGEN_FK_RUTA" FOREIGN KEY ("ID_CIUDAD_ORIGEN")
	  REFERENCES "CIUDAD" ("ID_CIUDAD") ENABLE
  ALTER TABLE "RUTA" ADD CONSTRAINT "ID_CIUDAD_DESTINO_FK_RUTA" FOREIGN KEY ("ID_CIUDAD_DESTINO")
	  REFERENCES "CIUDAD" ("ID_CIUDAD") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table TARIFA_HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "TARIFA_HOSPEDAJE" ADD CONSTRAINT "ID_HABITACION_FK_HABITACION" FOREIGN KEY ("ID_HABITACION")
	  REFERENCES "HABITACION" ("ID_HABITACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table TARIFA_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "TARIFA_TRANSPORTE" ADD CONSTRAINT "ID_RUTA_FK_TARIFA_TRANSPORTE" FOREIGN KEY ("ID_RUTA")
	  REFERENCES "RUTA" ("ID_RUTA") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table TIPO_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "TIPO_PRODUCTO" ADD CONSTRAINT "ID_ESTADO_TIPO_PRODUCTO_FK" FOREIGN KEY ("ID_ESTADO_TIPO_PRODUCTO")
	  REFERENCES "ESTADO_TIPO_PRODUCTO" ("ID_ESTADO_TIPO_PRODUCTO") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "TRANSPORTE" ADD CONSTRAINT "ID_EMPRESA_FK" FOREIGN KEY ("ID_EMPRESA")
	  REFERENCES "EMPRESA" ("ID_EMPRESA") ENABLE
  ALTER TABLE "TRANSPORTE" ADD CONSTRAINT "ID_TIPO_TRANSPORTE_FK" FOREIGN KEY ("ID_TIPO_TRANSPORTE")
	  REFERENCES "TIPO_TRANSPORTE" ("ID_TIPO_TRANSPORTE") ENABLE
  ALTER TABLE "TRANSPORTE" ADD CONSTRAINT "ID_ESTADO_TRANSPORTE_FK" FOREIGN KEY ("ID_ESTADO_TRANSPORTE")
	  REFERENCES "ESTADO_TRANSPORTE" ("ID_ESTADO_TRANSPORTE") ENABLE
