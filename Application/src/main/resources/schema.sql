/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ryank
 * Created: May 10, 2020
 */

-- CREATE ROLE thesupermarket WITH
-- 	LOGIN
-- 	NOSUPERUSER
-- 	CREATEDB
-- 	CREATEROLE
-- 	INHERIT
-- 	REPLICATION
-- 	CONNECTION LIMIT -1
-- 	PASSWORD 'xxxxxx';
-- COMMENT ON ROLE thesupermarket IS 'user for 4PROJ';
-- 
-- CREATE DATABASE account_thesupermarket
--     WITH 
--     OWNER = thesupermarket
--     ENCODING = 'UTF8'
--     CONNECTION LIMIT = -1;
-- 
-- COMMENT ON DATABASE nn
--     IS '4PROJ';