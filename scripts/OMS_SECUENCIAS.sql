--------------------------------------------------------
-- Archivo creado  - domingo-septiembre-02-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUDITORIA_VENTAS
--------------------------------------------------------

CREATE TABLE "PICAOMS"."AUDITORIA_VENTAS" 
   (	"ID_AUDITORIA" NUMBER(18,0), 
	"FECHA_ACCION" DATE, 
	"ID_PRODUCTO" NUMBER(18,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
-- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_AUDI_VENTAS_ID_AUDITORIA --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_AUDI_VENTAS_ID_AUDI_SEQ
  BEFORE INSERT ON "PICAOMS"."AUDITORIA_VENTAS" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_AUDI_VENTAS_ID_AUDITORIA.nextval INTO :new.ID_AUDITORIA FROM dual;
    END;
  
  
--------------------------------------------------------
--  DDL for Table CAMPANNA
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."CAMPANNA" 
   (	"ID_CAMPANNA" NUMBER(18,0), 
	"NOMBRE_CAMPANNA" VARCHAR2(200 BYTE), 
	"FECHA_CAMPANNA" DATE, 
	"FECHA_VENCIMEINTO" DATE, 
	"ID_PRODUCTO" NUMBER(18,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
  
  -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_CAMPANNA_ID_CAMPANNA --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_CAMPANNA_ID_CAMPANNA
  BEFORE INSERT ON "PICAOMS"."CAMPANNA" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_CAMPANNA_ID_CAMPANNA.nextval INTO :new.ID_CAMPANNA FROM dual;
    END;
  
  
  
--------------------------------------------------------
--  DDL for Table CONSTANTES
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."CONSTANTES" 
   (	"NOMBRE" VARCHAR2(50 BYTE), 
	"VALOR" VARCHAR2(100 BYTE), 
	"ESTADO" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TARIFA_HOSPEDAJE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."TARIFA_HOSPEDAJE" 
   (	"ID_TARIFA_HOSPEDAJE" NUMBER(18,0), 
	"PRECIO" NUMBER(18,2), 
	"ID_HABITACION" NUMBER(10,0), 
	"FECHA_VIGENCIA" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
  
    -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_TARIFA_HOSPEDAJE_ID_TARIFA_HOSPEDAJE --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_TARIFA_HOSPEDAJE_ID_TARIFA_HOSPEDAJE
  BEFORE INSERT ON "PICAOMS"."TARIFA_HOSPEDAJE" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_TARIFA_HOSPEDAJE_ID_TARIFA_HOSPEDAJE.nextval INTO :new.ID_TARIFA_HOSPEDAJE FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Table HABITACION
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."HABITACION" 
   (	"ID_HABITACION" NUMBER(18,0), 
	"ID_TIPO_HABITACION" NUMBER(10,0), 
	"ID_HOSPEDAJE" NUMBER(18,0), 
	"NUMERO" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
    -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_HABITACION_ID_HABITACION --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_HABITACION_ID_HABITACION
  BEFORE INSERT ON "PICAOMS"."TARIFA_HOSPEDAJE" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_HABITACION_ID_HABITACION.nextval INTO :new.ID_HABITACION FROM dual;
    END;
  
  
--------------------------------------------------------
--  DDL for Table DETALLE_ORDEN_COMPRA
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."DETALLE_ORDEN_COMPRA" 
   (	"ID_DETALLE_ORDEN" NUMBER(18,0), 
	"NO_ORDEN" NUMBER(18,0), 
	"ID_PRODUCTO" NUMBER(18,0), 
	"VALOR" NUMBER(18,2)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
     -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_DETALLE_ORDEN_COMPRA_ID_DETALLE_ORDEN --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_DETALLE_ORDEN_COMPRA_ID_DETALLE_ORDEN
  BEFORE INSERT ON "PICAOMS"."DETALLE_ORDEN_COMPRA" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_DETALLE_ORDEN_COMPRA_ID_DETALLE_ORDEN.nextval INTO :new.ID_DETALLE_ORDEN FROM dual;
    END;
 
--------------------------------------------------------
--  DDL for Table ESTADO_TIPO_PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."ESTADO_TIPO_PRODUCTO" 
   (	"ID_ESTADO_TIPO_PRODUCTO" NUMBER(10,0), 
	"ESTADO" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."TRANSPORTE" 
   (	"ID_TRANSPORTE" NUMBER(18,0), 
	"ID_TIPO_TRANSPORTE" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(200 BYTE), 
	"ID_EMPRESA" VARCHAR2(15 BYTE), 
	"ID_ESTADO_TRANSPORTE" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ORDEN_COMPRA
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."ORDEN_COMPRA" 
   (	"NO_ORDEN" NUMBER(18,0), 
	"FECHA_CREACION" DATE, 
	"FECHA_VENCIMIENTO" DATE, 
	"NUMERO_SOLICITUD" NUMBER(18,0), 
	"VALOR_TOTAL" NUMBER(18,2), 
	"ID_ESTADO_ORDEN_COMPRA" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
     -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_ORDEN_COMPRA_NO_ORDEN --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_ORDEN_COMPRA_NO_ORDEN
  BEFORE INSERT ON "PICAOMS"."ORDEN_COMPRA" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_ORDEN_COMPRA_NO_ORDEN.nextval INTO :new.NO_ORDEN FROM dual;
    END;
 
  
--------------------------------------------------------
--  DDL for Table ESTADO_TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."ESTADO_TRANSPORTE" 
   (	"ID_ESTADO_TRANSPORTE" NUMBER(10,0), 
	"ESTADO" VARCHAR2(90 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TIPO_HABITACION
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."TIPO_HABITACION" 
   (	"ID_TIPO_HABITACION" NUMBER(10,0), 
	"TIPO" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TIPO_PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."TIPO_PRODUCTO" 
   (	"ID_TIPO_PRODUCTO" NUMBER(18,0), 
	"NOMBRE" VARCHAR2(200 BYTE), 
	"ID_ESTADO_TIPO_PRODUCTO" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOG_CONSUMI_WS
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."LOG_CONSUMI_WS" 
   (	"ID" NUMBER(18,0), 
	"FECHA_ACCION" DATE, 
	"IP" VARCHAR2(50 BYTE), 
	"END_POINT" VARCHAR2(300 BYTE), 
	"REQUEST" VARCHAR2(300 BYTE), 
	"RESPONSE" VARCHAR2(300 BYTE), 
	"USER_ID" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
       -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_LOG_CONSUMI_WS_ID --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_LOG_CONSUMI_WS_ID
  BEFORE INSERT ON "PICAOMS"."LOG_CONSUMI_WS" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_LOG_CONSUMI_WS_ID.nextval INTO :new.ID FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."PRODUCTO" 
   (	"ID_PRODUCTO" NUMBER(18,0), 
	"NOMBRE_PRODUCTO" VARCHAR2(200 BYTE), 
	"ID_TIPO_PRODUCTO" NUMBER(18,0), 
	"FECHA_SALIDA" DATE, 
	"FECHA_LLEGADA" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
       -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_PRODUCTO_ID_PRODUCTO --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_PRODUCTO_ID_PRODUCTO
  BEFORE INSERT ON "PICAOMS"."PRODUCTO" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_PRODUCTO_ID_PRODUCTO.nextval INTO :new.ID_PRODUCTO FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Table TARIFA_TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."TARIFA_TRANSPORTE" 
   (	"ID_TARIFA_TRANSPORTE" NUMBER(18,0), 
	"PRECIO" NUMBER(18,2), 
	"FECHA_VIGENCIA" DATE, 
	"ID_RUTA" NUMBER(18,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table IMAGEN_PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."IMAGEN_PRODUCTO" 
   (	"ID_IMAGEN_PRODUCTO" NUMBER(18,0), 
	"IMAGEN" VARCHAR2(200 BYTE), 
	"ESPRINCIPAL" NUMBER(10,0), 
	"ID_PRODUCTO" NUMBER(18,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
         -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_IMAGEN_PRODUCTO_ID_IMAGEN_PRODUCTO --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_IMAGEN_PRODUCTO_ID_IMAGEN_PRODUCTO
  BEFORE INSERT ON "PICAOMS"."IMAGEN_PRODUCTO" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_IMAGEN_PRODUCTO_ID_IMAGEN_PRODUCTO.nextval INTO :new.ID_IMAGEN_PRODUCTO FROM dual;
    END;
--------------------------------------------------------
--  DDL for Table ESTADO_ORDEN_COMPRA
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."ESTADO_ORDEN_COMPRA" 
   (	"ID_ESTADO_ORDEN_COMPRA" NUMBER(10,0), 
	"ESTADO" VARCHAR2(60 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PAIS
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."PAIS" 
   (	"ID_PAIS" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(300 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table IMAGEN_HABITACION
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."IMAGEN_HABITACION" 
   (	"ID_IMAGEN_HABITACION" NUMBER(10,0), 
	"ID_HABITACION" NUMBER(10,0), 
	"IMAGEN" VARCHAR2(200 BYTE), 
	"ESPRINCIPAL" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
           -- Se crea la secuencia para el campo ID_AUDITORIA
CREATE SEQUENCE SEQ_IMAGEN_IMAGEN_HABITACION_ID_IMAGEN_HABITACION --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_IMAGEN_HABITACION_ID_IMAGEN_HABITACION
  BEFORE INSERT ON "PICAOMS"."IMAGEN_HABITACION" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_IMAGEN_IMAGEN_HABITACION_ID_IMAGEN_HABITACION.nextval INTO :new.ID_IMAGEN_HABITACION FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Table TIPO_TRANSPORTE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."TIPO_TRANSPORTE" 
   (	"ID_TIPO_TRANSPORTE" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CIUDAD
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."CIUDAD" 
   (	"ID_CIUDAD" NUMBER(18,0), 
	"NOMBRE" VARCHAR2(300 BYTE), 
	"ID_PAIS" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HOSPEDAJE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."HOSPEDAJE" 
   (	"ID_HOSPEDAJE" NUMBER(18,0), 
	"NOMBRE" VARCHAR2(200 BYTE), 
	"ESTRELLAS" NUMBER(10,0), 
	"ID_CIUDAD" NUMBER(18,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
  
  CREATE SEQUENCE SEQ_HOSPEDAJE_ID_HOSPEDAJE --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_HOSPEDAJE_ID_HOSPEDAJE
  BEFORE INSERT ON "PICAOMS"."HOSPEDAJE" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_HOSPEDAJE_ID_HOSPEDAJE.nextval INTO :new.ID_HOSPEDAJE FROM dual;
    END;
  
  
--------------------------------------------------------
--  DDL for Table ITINERARIO
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."ITINERARIO" 
   (	"ID_ITINERARIO" NUMBER(18,0), 
	"ID_PRODUCTO" NUMBER(18,0), 
	"ID_HOSPEDAJE" NUMBER(18,0), 
	"ID_CIUDAD" NUMBER(18,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
    CREATE SEQUENCE SEQ_ITINERARIO_ID_ITINERARIO --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_ITINERARIO_ID_ITINERARIO
  BEFORE INSERT ON "PICAOMS"."ITINERARIO" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_ITINERARIO_ID_ITINERARIO.nextval INTO :new.ID_ITINERARIO FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Table IMAGEN_HOSPEDAJE
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."IMAGEN_HOSPEDAJE" 
   (	"ID_IMAGEN_HOSPEDAJE" NUMBER(10,0), 
	"ID_HOSPEDAJE" NUMBER(18,0), 
	"IMAGEN" VARCHAR2(200 BYTE), 
	"ESPRINCIPAL" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
    CREATE SEQUENCE SEQ_IMAGEN_HOSPEDAJE_ID_IMAGEN_HOSPEDAJE --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_IMAGEN_HOSPEDAJE_ID_IMAGEN_HOSPEDAJE
  BEFORE INSERT ON "PICAOMS"."IMAGEN_HOSPEDAJE" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_IMAGEN_HOSPEDAJE_ID_IMAGEN_HOSPEDAJE.nextval INTO :new.ID_IMAGEN_HOSPEDAJE FROM dual;
    END;
  
  
--------------------------------------------------------
--  DDL for Table EMPRESA
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."EMPRESA" 
   (	"ID_EMPRESA" VARCHAR2(15 BYTE), 
	"NOMBRE" VARCHAR2(200 BYTE), 
	"URL_ENDPOINT" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
      CREATE SEQUENCE SEQ_EMPRESA_ID_EMPRESA --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_EMPRESA_ID_EMPRESAE
  BEFORE INSERT ON "PICAOMS"."EMPRESA" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_EMPRESA_ID_EMPRESA.nextval INTO :new.ID_EMPRESA FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Table RUTA
--------------------------------------------------------

  CREATE TABLE "PICAOMS"."RUTA" 
   (	"ID_RUTA" NUMBER(18,0), 
	"ID_EMPRESA" VARCHAR2(15 BYTE), 
	"ID_CIUDAD_ORIGEN" NUMBER(6,0), 
	"ID_CIUDAD_DESTINO" NUMBER(6,0), 
	"DESCRIPCION" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
       CREATE SEQUENCE SEQ_EMPRESA_ID_EMPRESA --nombre de la secuencia
START WITH 1 --la secuencia empieza por 1
INCREMENT BY 1 --se incrementa de uno en uno
NOMAXVALUE; --no tiene valor maximo

-- Se crea un trigger para que el ID_RETIRO sea incrementado automaticamente.
CREATE TRIGGER TRIG_EMPRESA_ID_EMPRESAE
  BEFORE INSERT ON "PICAOMS"."EMPRESA" 
  FOR EACH ROW
    BEGIN
        SELECT SEQ_EMPRESA_ID_EMPRESA.nextval INTO :new.ID_EMPRESA FROM dual;
    END;
  
--------------------------------------------------------
--  DDL for Index SYS_C007712
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007712" ON "PICAOMS"."AUDITORIA_VENTAS" ("ID_AUDITORIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007684
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007684" ON "PICAOMS"."CAMPANNA" ("ID_CAMPANNA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CONSTANTES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."CONSTANTES_PK" ON "PICAOMS"."CONSTANTES" ("NOMBRE", "VALOR", "ESTADO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007757
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007757" ON "PICAOMS"."TARIFA_HOSPEDAJE" ("ID_TARIFA_HOSPEDAJE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007677
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007677" ON "PICAOMS"."HABITACION" ("ID_HABITACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007700
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007700" ON "PICAOMS"."DETALLE_ORDEN_COMPRA" ("ID_DETALLE_ORDEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007641
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007641" ON "PICAOMS"."ESTADO_TIPO_PRODUCTO" ("ID_ESTADO_TIPO_PRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007623
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007623" ON "PICAOMS"."TRANSPORTE" ("ID_TRANSPORTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007694
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007694" ON "PICAOMS"."ORDEN_COMPRA" ("NO_ORDEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007609
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007609" ON "PICAOMS"."ESTADO_TRANSPORTE" ("ID_ESTADO_TRANSPORTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007672
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007672" ON "PICAOMS"."TIPO_HABITACION" ("ID_TIPO_HABITACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007644
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007644" ON "PICAOMS"."TIPO_PRODUCTO" ("ID_TIPO_PRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007716
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007716" ON "PICAOMS"."LOG_CONSUMI_WS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007650
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007650" ON "PICAOMS"."PRODUCTO" ("ID_PRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007638
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007638" ON "PICAOMS"."TARIFA_TRANSPORTE" ("ID_TARIFA_TRANSPORTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007707
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007707" ON "PICAOMS"."IMAGEN_PRODUCTO" ("ID_IMAGEN_PRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007687
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007687" ON "PICAOMS"."ESTADO_ORDEN_COMPRA" ("ID_ESTADO_ORDEN_COMPRA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007611
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007611" ON "PICAOMS"."PAIS" ("ID_PAIS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007751
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007751" ON "PICAOMS"."IMAGEN_HABITACION" ("ID_IMAGEN_HABITACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007617
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007617" ON "PICAOMS"."TIPO_TRANSPORTE" ("ID_TIPO_TRANSPORTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007614
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007614" ON "PICAOMS"."CIUDAD" ("ID_CIUDAD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007656
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007656" ON "PICAOMS"."HOSPEDAJE" ("ID_HOSPEDAJE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007668
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007668" ON "PICAOMS"."ITINERARIO" ("ID_ITINERARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007662
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007662" ON "PICAOMS"."IMAGEN_HOSPEDAJE" ("ID_IMAGEN_HOSPEDAJE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007619
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007619" ON "PICAOMS"."EMPRESA" ("ID_EMPRESA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007631
--------------------------------------------------------

  CREATE UNIQUE INDEX "PICAOMS"."SYS_C007631" ON "PICAOMS"."RUTA" ("ID_RUTA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table AUDITORIA_VENTAS
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."AUDITORIA_VENTAS" MODIFY ("ID_AUDITORIA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."AUDITORIA_VENTAS" MODIFY ("FECHA_ACCION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."AUDITORIA_VENTAS" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."AUDITORIA_VENTAS" ADD PRIMARY KEY ("ID_AUDITORIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CAMPANNA
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."CAMPANNA" MODIFY ("ID_CAMPANNA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CAMPANNA" MODIFY ("NOMBRE_CAMPANNA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CAMPANNA" MODIFY ("FECHA_CAMPANNA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CAMPANNA" MODIFY ("FECHA_VENCIMEINTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CAMPANNA" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CAMPANNA" ADD PRIMARY KEY ("ID_CAMPANNA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONSTANTES
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."CONSTANTES" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CONSTANTES" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CONSTANTES" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CONSTANTES" ADD CONSTRAINT "CONSTANTES_PK" PRIMARY KEY ("NOMBRE", "VALOR", "ESTADO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TARIFA_HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."TARIFA_HOSPEDAJE" MODIFY ("ID_TARIFA_HOSPEDAJE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_HOSPEDAJE" MODIFY ("PRECIO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_HOSPEDAJE" MODIFY ("ID_HABITACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_HOSPEDAJE" MODIFY ("FECHA_VIGENCIA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_HOSPEDAJE" ADD PRIMARY KEY ("ID_TARIFA_HOSPEDAJE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table HABITACION
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."HABITACION" MODIFY ("ID_HABITACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HABITACION" MODIFY ("ID_TIPO_HABITACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HABITACION" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HABITACION" MODIFY ("NUMERO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HABITACION" ADD PRIMARY KEY ("ID_HABITACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DETALLE_ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."DETALLE_ORDEN_COMPRA" MODIFY ("ID_DETALLE_ORDEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."DETALLE_ORDEN_COMPRA" MODIFY ("NO_ORDEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."DETALLE_ORDEN_COMPRA" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."DETALLE_ORDEN_COMPRA" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."DETALLE_ORDEN_COMPRA" ADD PRIMARY KEY ("ID_DETALLE_ORDEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ESTADO_TIPO_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."ESTADO_TIPO_PRODUCTO" MODIFY ("ID_ESTADO_TIPO_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ESTADO_TIPO_PRODUCTO" ADD PRIMARY KEY ("ID_ESTADO_TIPO_PRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."TRANSPORTE" MODIFY ("ID_TRANSPORTE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TRANSPORTE" MODIFY ("ID_TIPO_TRANSPORTE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TRANSPORTE" MODIFY ("ID_ESTADO_TRANSPORTE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TRANSPORTE" ADD PRIMARY KEY ("ID_TRANSPORTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" MODIFY ("NO_ORDEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" MODIFY ("FECHA_CREACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" MODIFY ("FECHA_VENCIMIENTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" MODIFY ("NUMERO_SOLICITUD" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" MODIFY ("VALOR_TOTAL" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" MODIFY ("ID_ESTADO_ORDEN_COMPRA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ORDEN_COMPRA" ADD PRIMARY KEY ("NO_ORDEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ESTADO_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."ESTADO_TRANSPORTE" MODIFY ("ID_ESTADO_TRANSPORTE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ESTADO_TRANSPORTE" ADD PRIMARY KEY ("ID_ESTADO_TRANSPORTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPO_HABITACION
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."TIPO_HABITACION" MODIFY ("ID_TIPO_HABITACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TIPO_HABITACION" MODIFY ("TIPO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TIPO_HABITACION" ADD PRIMARY KEY ("ID_TIPO_HABITACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPO_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."TIPO_PRODUCTO" MODIFY ("ID_TIPO_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TIPO_PRODUCTO" MODIFY ("ID_ESTADO_TIPO_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TIPO_PRODUCTO" ADD PRIMARY KEY ("ID_TIPO_PRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOG_CONSUMI_WS
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."LOG_CONSUMI_WS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."LOG_CONSUMI_WS" MODIFY ("FECHA_ACCION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."LOG_CONSUMI_WS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."PRODUCTO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."PRODUCTO" MODIFY ("ID_TIPO_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."PRODUCTO" MODIFY ("FECHA_SALIDA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."PRODUCTO" MODIFY ("FECHA_LLEGADA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."PRODUCTO" ADD PRIMARY KEY ("ID_PRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TARIFA_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."TARIFA_TRANSPORTE" MODIFY ("ID_TARIFA_TRANSPORTE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_TRANSPORTE" MODIFY ("PRECIO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_TRANSPORTE" MODIFY ("ID_RUTA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TARIFA_TRANSPORTE" ADD PRIMARY KEY ("ID_TARIFA_TRANSPORTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table IMAGEN_PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."IMAGEN_PRODUCTO" MODIFY ("ID_IMAGEN_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_PRODUCTO" MODIFY ("IMAGEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_PRODUCTO" MODIFY ("ESPRINCIPAL" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_PRODUCTO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_PRODUCTO" ADD PRIMARY KEY ("ID_IMAGEN_PRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ESTADO_ORDEN_COMPRA
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."ESTADO_ORDEN_COMPRA" MODIFY ("ID_ESTADO_ORDEN_COMPRA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ESTADO_ORDEN_COMPRA" ADD PRIMARY KEY ("ID_ESTADO_ORDEN_COMPRA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PAIS
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."PAIS" MODIFY ("ID_PAIS" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."PAIS" ADD PRIMARY KEY ("ID_PAIS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table IMAGEN_HABITACION
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."IMAGEN_HABITACION" MODIFY ("ID_IMAGEN_HABITACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HABITACION" MODIFY ("ID_HABITACION" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HABITACION" MODIFY ("IMAGEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HABITACION" MODIFY ("ESPRINCIPAL" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HABITACION" ADD PRIMARY KEY ("ID_IMAGEN_HABITACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TIPO_TRANSPORTE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."TIPO_TRANSPORTE" MODIFY ("ID_TIPO_TRANSPORTE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."TIPO_TRANSPORTE" ADD PRIMARY KEY ("ID_TIPO_TRANSPORTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CIUDAD
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."CIUDAD" MODIFY ("ID_CIUDAD" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CIUDAD" MODIFY ("ID_PAIS" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."CIUDAD" ADD PRIMARY KEY ("ID_CIUDAD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."HOSPEDAJE" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HOSPEDAJE" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HOSPEDAJE" MODIFY ("ESTRELLAS" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HOSPEDAJE" MODIFY ("ID_CIUDAD" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."HOSPEDAJE" ADD PRIMARY KEY ("ID_HOSPEDAJE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ITINERARIO
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."ITINERARIO" MODIFY ("ID_ITINERARIO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ITINERARIO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ITINERARIO" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ITINERARIO" MODIFY ("ID_CIUDAD" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."ITINERARIO" ADD PRIMARY KEY ("ID_ITINERARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table IMAGEN_HOSPEDAJE
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."IMAGEN_HOSPEDAJE" MODIFY ("ID_IMAGEN_HOSPEDAJE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HOSPEDAJE" MODIFY ("ID_HOSPEDAJE" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HOSPEDAJE" MODIFY ("IMAGEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HOSPEDAJE" MODIFY ("ESPRINCIPAL" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."IMAGEN_HOSPEDAJE" ADD PRIMARY KEY ("ID_IMAGEN_HOSPEDAJE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPRESA
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."EMPRESA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."EMPRESA" ADD PRIMARY KEY ("ID_EMPRESA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RUTA
--------------------------------------------------------

  ALTER TABLE "PICAOMS"."RUTA" MODIFY ("ID_RUTA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."RUTA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."RUTA" MODIFY ("ID_CIUDAD_ORIGEN" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."RUTA" MODIFY ("ID_CIUDAD_DESTINO" NOT NULL ENABLE);
  ALTER TABLE "PICAOMS"."RUTA" ADD PRIMARY KEY ("ID_RUTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
