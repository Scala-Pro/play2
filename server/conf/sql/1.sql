CREATE ROLE admin WITH CREATEDB CREATEROLE LOGIN ENCRYPTED PASSWORD '123';
CREATE DATABASE playexample WITH OWNER admin;

CREATE TABLE "user" ("id" SERIAL PRIMARY KEY, "name" VARCHAR);