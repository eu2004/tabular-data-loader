# xlsx database tool
Tries to be a handy tool for users that use xlsx files (for the moment), by helping them to access the data from these files in a "sql" manner (the xlsx files are actually treated like database tables). 
The tool contains the following modules: 

1. xlsxdb - module that contains the "core" functionality for loading xlsx files into a database or exporting to sql script files - like a database table export. The module can be used in any DI environment such as (Spring, J2EE). More info about how this module can be used are the src/test package.

2. xlsxdb_app - module that defines a default tool of using the xlsxdb application.  In order to build the tool just need to run: "mvn clean install" and go to target/dist folder. 
The tool functions in the following ways:
 - loading mode: must received as arguments from command line two arguments: "\<folder path\> load". The "load.bat" script can be used to launch this command.
 By default, the xlsx files are loaded into a local hsql db (in persisted mode, called "xslxDataSource"). The URL to access this database is: jdbc:hsqldb:hsql://localhost:9001/xdb; The user is "sa" without any password. To launch the hsql db server from command use "startDB.bat". In order to change the database, please check the jdbc.properties file and make sure you add the corresponding driver jar file to the tool classpath (see load.bat file).
 - exporting mode: must received as arguments from command line two arguments: "\<folder path\> export", the output will be an .sql script file per each xlsx file, containing sql commands like: create table and insert. To execute this command, the "export.bat" file can be also used.
