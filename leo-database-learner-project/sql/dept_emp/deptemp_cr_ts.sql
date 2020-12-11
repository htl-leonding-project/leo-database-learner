PROMPT TABLESPACE anlegen
pause Wird der Tablespace auch im richtigen Verzeichnis angelegt?

CREATE SMALLFILE TABLESPACE TS_DEMO_DEPTEMP 
--DATAFILE '/u01/app/oracle/oradata/zeusdb/TS_DEMO_DEPTEMP.DBF' 
DATAFILE '/u01/app/oracle/oradata/delphidb/TS_DEMO_DEPTEMP.DBF' 
SIZE 500k REUSE;


PROMPT Fuer den temporaren Tablespace wird TEMP verwendet

 
 
