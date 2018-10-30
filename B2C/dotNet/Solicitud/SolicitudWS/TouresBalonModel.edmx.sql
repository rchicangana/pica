
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, and Azure
-- --------------------------------------------------
-- Date Created: 10/28/2018 16:57:10
-- Generated from EDMX file: D:\Users\RuizAyala\Documents\GitHub\pica\B2C\dotNet\Solicitud\SolicitudWS\TouresBalonModel.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [touresbalon];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[SOLICITUD]', 'U') IS NOT NULL
    DROP TABLE [dbo].[SOLICITUD];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'SOLICITUD'
CREATE TABLE [dbo].[SOLICITUD] (
    [numerosolicitud] int  NOT NULL,
    [fechacreacion] datetime  NULL,
    [fechavencimiento] datetime  NULL,
    [valortotal] decimal(18,2)  NULL,
    [idusuario] int  NULL,
    [noorden] nvarchar(max)  NOT NULL,
    [estadoordencompraid] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'ESTADOORDENCOMPRAConjunto'
CREATE TABLE [dbo].[ESTADOORDENCOMPRAConjunto] (
    [Idestadoordencompra] int IDENTITY(1,1) NOT NULL,
    [estado] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'TIPOPRODUCTOConjunto'
CREATE TABLE [dbo].[TIPOPRODUCTOConjunto] (
    [Idtipoproducto] int IDENTITY(1,1) NOT NULL,
    [nombre] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'IMAGENPRODUCTOConjunto'
CREATE TABLE [dbo].[IMAGENPRODUCTOConjunto] (
    [Idimagenproducto] int IDENTITY(1,1) NOT NULL,
    [imagen] nvarchar(max)  NOT NULL,
    [esprincipal] int  NOT NULL
);
GO

-- Creating table 'PRODUCTOConjunto'
CREATE TABLE [dbo].[PRODUCTOConjunto] (
    [Idproducto] int IDENTITY(1,1) NOT NULL,
    [tipoproductoid] nvarchar(max)  NOT NULL,
    [nombreproducto] nvarchar(max)  NOT NULL,
    [fechasalida] nvarchar(max)  NOT NULL,
    [fechallegada] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'DETALLEORDENCOMPRAConjunto'
CREATE TABLE [dbo].[DETALLEORDENCOMPRAConjunto] (
    [Iddetalleorden] int IDENTITY(1,1) NOT NULL,
    [productoid] nvarchar(max)  NOT NULL,
    [valor] nvarchar(max)  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [numerosolicitud] in table 'SOLICITUD'
ALTER TABLE [dbo].[SOLICITUD]
ADD CONSTRAINT [PK_SOLICITUD]
    PRIMARY KEY CLUSTERED ([numerosolicitud] ASC);
GO

-- Creating primary key on [Idestadoordencompra] in table 'ESTADOORDENCOMPRAConjunto'
ALTER TABLE [dbo].[ESTADOORDENCOMPRAConjunto]
ADD CONSTRAINT [PK_ESTADOORDENCOMPRAConjunto]
    PRIMARY KEY CLUSTERED ([Idestadoordencompra] ASC);
GO

-- Creating primary key on [Idtipoproducto] in table 'TIPOPRODUCTOConjunto'
ALTER TABLE [dbo].[TIPOPRODUCTOConjunto]
ADD CONSTRAINT [PK_TIPOPRODUCTOConjunto]
    PRIMARY KEY CLUSTERED ([Idtipoproducto] ASC);
GO

-- Creating primary key on [Idimagenproducto] in table 'IMAGENPRODUCTOConjunto'
ALTER TABLE [dbo].[IMAGENPRODUCTOConjunto]
ADD CONSTRAINT [PK_IMAGENPRODUCTOConjunto]
    PRIMARY KEY CLUSTERED ([Idimagenproducto] ASC);
GO

-- Creating primary key on [Idproducto] in table 'PRODUCTOConjunto'
ALTER TABLE [dbo].[PRODUCTOConjunto]
ADD CONSTRAINT [PK_PRODUCTOConjunto]
    PRIMARY KEY CLUSTERED ([Idproducto] ASC);
GO

-- Creating primary key on [Iddetalleorden] in table 'DETALLEORDENCOMPRAConjunto'
ALTER TABLE [dbo].[DETALLEORDENCOMPRAConjunto]
ADD CONSTRAINT [PK_DETALLEORDENCOMPRAConjunto]
    PRIMARY KEY CLUSTERED ([Iddetalleorden] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------