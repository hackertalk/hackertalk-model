-- Isolate different databases by environment
CREATE DATABASE hackertalk;

-- By default, no schema with the same name as the user name exists. So the
-- public schema becomes the default schema whenever an unqualified object name
-- is used. Because of this, when a user tries to create a new table without
-- specifying the schema name, the table gets created in the public schema. As
-- mentioned earlier, by default, all users have access to create objects in the
-- public schema, and therefore the table is created successfully.
-- Revoke privileges from 'public' role
REVOKE CREATE ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON DATABASE hackertalk FROM public;

-- create readonly, readwrite roles
CREATE ROLE hackertalk_reader_role;
CREATE ROLE hackertalk_writer_role;

-- Grant roles permission to connect to database
GRANT CONNECT ON DATABASE hackertalk TO hackertalk_reader_role;
GRANT CONNECT ON DATABASE hackertalk TO hackertalk_writer_role;

-- create users
CREATE USER hackertalk_application_user WITH PASSWORD 'example_password';
CREATE USER hackertalk_reporting_user WITH PASSWORD 'example_password';
GRANT hackertalk_writer_role TO hackertalk_application_user;
GRANT hackertalk_reader_role TO hackertalk_reporting_user;

\connect hackertalk; -- input password
CREATE SCHEMA application; -- create schema on database
GRANT USAGE ON SCHEMA application TO hackertalk_reader_role;
GRANT SELECT ON ALL TABLES IN SCHEMA application TO hackertalk_reader_role;
-- Ensure that new tables and views are also accessible
ALTER DEFAULT PRIVILEGES IN SCHEMA application GRANT SELECT ON TABLES TO hackertalk_reader_role;
GRANT USAGE ON SCHEMA application TO hackertalk_writer_role;
-- allow this role to create new objects like tables in schema
GRANT USAGE, CREATE ON SCHEMA application TO hackertalk_writer_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA application TO hackertalk_writer_role;
-- Automatically grant permissions on tables and views added in the future
ALTER DEFAULT PRIVILEGES IN SCHEMA application GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO hackertalk_writer_role;
-- For read/write roles, there is normally a requirement to use sequences
GRANT USAGE ON ALL SEQUENCES IN SCHEMA application TO hackertalk_writer_role;
-- Automatically grant permissions to sequences added in the future
ALTER DEFAULT PRIVILEGES IN SCHEMA application GRANT USAGE ON SEQUENCES TO hackertalk_writer_role;
