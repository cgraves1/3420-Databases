DATABASE AND APPLICATION INSTRUCTIONS:

1. In PSQL, create database titled 'plumbingdb'
2. Create a user 'plumbingdb' with password 'tokyo18'
3. Recover the database using the following command:
	pg_dump plumbingdb > plumbingdb_backup
4. Grant user 'plumbingdb' access to all tables in database using:
	grant all privileges on all tables in schema public to plumbingdb;
5. Start 3420.jar application. 'Connected' should show on bottom left and data should 
   be in tables.