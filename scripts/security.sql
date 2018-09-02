--------------------------------------------------------
-- Archivo creado  - domingo-septiembre-02-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ESTADO_USER
--------------------------------------------------------

  CREATE TABLE "ESTADO_USER" 
   (	"ID_ESTADO_USER" NUMBER(10,0), 
	"ESTADO" VARCHAR2(100)
   );
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "USUARIO" 
   (	"ID_USUARIO" NUMBER(10) NOT NULL, 
	"NOMBRE" VARCHAR2(100) NOT NULL,  
	"EMAIL" VARCHAR2(100) NOT NULL, 
	"ID_ESTADO_USER" NUMBER(10,0) NOT NULL, 
	"LOGIN" VARCHAR2(50) NOT NULL
   );
--------------------------------------------------------
--  DDL for Table USUARIO_ROLE
--------------------------------------------------------

  CREATE TABLE "USUARIO_ROLE" 
   (	"ID" NUMBER(18,0), 
	"ID_USUARIO" NUMBER(10), 
	"ID_ROLE" NUMBER(10,0)
   );
--------------------------------------------------------
--  DDL for Table ROLE
--------------------------------------------------------

  CREATE TABLE "ROLE" 
   (	"ID_ROLE" NUMBER(10,0), 
	"ROLE" VARCHAR2(100)
   );
--------------------------------------------------------
--  DDL for Table MENU_ROLE
--------------------------------------------------------

  CREATE TABLE "MENU_ROLE" 
   (	"ID_ROLE" NUMBER(10,0), 
	"ID_MENU" NUMBER(10,0)
   );
--------------------------------------------------------
--  DDL for Table MENU
--------------------------------------------------------

  CREATE TABLE "MENU" 
   (	"ID_MENU" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(50), 
	"URL" VARCHAR2(210), 
	"ID_MENU_PADRE" NUMBER(10,0), 
    "ULTIMO_NIVEL" VARCHAR2(1), 
	"ESTADO" NUMBER(10,0)
   );
REM INSERTING into ESTADO_USER
SET DEFINE OFF;
REM INSERTING into USUARIO
SET DEFINE OFF;
REM INSERTING into USUARIO_ROLE
SET DEFINE OFF;
REM INSERTING into ROLE
SET DEFINE OFF;
REM INSERTING into MENU_ROLE
SET DEFINE OFF;
REM INSERTING into MENU
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index MENU_ROLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MENU_ROLE_PK" ON "MENU_ROLE" ("ID_ROLE", "ID_MENU");
--------------------------------------------------------
--  DDL for Index SYS_C007723
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007723" ON "ESTADO_USER" ("ID_ESTADO_USER");
--------------------------------------------------------
--  DDL for Index SYS_C007728
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007728" ON "USUARIO" ("ID_USUARIO");
--------------------------------------------------------
--  DDL for Index SYS_C007736
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007736" ON "USUARIO_ROLE" ("ID");
--------------------------------------------------------
--  DDL for Index SYS_C007732
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007732" ON "ROLE" ("ID_ROLE");
--------------------------------------------------------
--  DDL for Index SYS_C007741
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007741" ON "MENU" ("ID_MENU");
--------------------------------------------------------
--  Constraints for Table ESTADO_USER
--------------------------------------------------------

  ALTER TABLE "ESTADO_USER" MODIFY ("ID_ESTADO_USER" NOT NULL ENABLE);
  ALTER TABLE "ESTADO_USER" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "ESTADO_USER" ADD PRIMARY KEY ("ID_ESTADO_USER")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "USUARIO" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "USUARIO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "USUARIO" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "USUARIO" MODIFY ("ID_ESTADO_USER" NOT NULL ENABLE);
  ALTER TABLE "USUARIO" ADD PRIMARY KEY ("ID_USUARIO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO_ROLE
--------------------------------------------------------

  ALTER TABLE "USUARIO_ROLE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_ROLE" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_ROLE" MODIFY ("ID_ROLE" NOT NULL ENABLE);
  ALTER TABLE "USUARIO_ROLE" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROLE
--------------------------------------------------------

  ALTER TABLE "ROLE" MODIFY ("ID_ROLE" NOT NULL ENABLE);
  ALTER TABLE "ROLE" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "ROLE" ADD PRIMARY KEY ("ID_ROLE")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table MENU_ROLE
--------------------------------------------------------

  ALTER TABLE "MENU_ROLE" MODIFY ("ID_ROLE" NOT NULL ENABLE);
  ALTER TABLE "MENU_ROLE" MODIFY ("ID_MENU" NOT NULL ENABLE);
  ALTER TABLE "MENU_ROLE" ADD CONSTRAINT "MENU_ROLE_PK" PRIMARY KEY ("ID_ROLE", "ID_MENU")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table MENU
--------------------------------------------------------

  ALTER TABLE "MENU" MODIFY ("ID_MENU" NOT NULL ENABLE);
  ALTER TABLE "MENU" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "MENU" MODIFY ("URL" NOT NULL ENABLE);
  ALTER TABLE "MENU" ADD PRIMARY KEY ("ID_MENU")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "USUARIO" ADD CONSTRAINT "ID_ESTADO_USER_FK_USUARIO" FOREIGN KEY ("ID_ESTADO_USER")
	  REFERENCES "ESTADO_USER" ("ID_ESTADO_USER") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO_ROLE
--------------------------------------------------------

  ALTER TABLE "USUARIO_ROLE" ADD CONSTRAINT "ID_USUARIO_FK_USUARIO_ROLE" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "USUARIO" ("ID_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MENU_ROLE
--------------------------------------------------------

  ALTER TABLE "MENU_ROLE" ADD CONSTRAINT "ID_ROLE_FK_MENU_ROLE" FOREIGN KEY ("ID_ROLE")
	  REFERENCES "ROLE" ("ID_ROLE") ENABLE;
  ALTER TABLE "MENU_ROLE" ADD CONSTRAINT "ID_MENU_FK_MENU_ROLE" FOREIGN KEY ("ID_MENU")
	  REFERENCES "MENU" ("ID_MENU") ENABLE;
