--prompt Ausgaben werden in Logdatei 'bld_matura' geschrieben
--prompt <Taste druecken zum Beginnen>
--pause
--spool c:\temp\bld_matura.log


ALTER SESSION SET CURRENT_SCHEMA=SYS;
--@@deptemp_dr_ts.sql
@@deptemp_cr_ts.sql
@@deptemp_cr_user.sql
@@deptemp_user2ts.sql
pause nun als DEMO_DEPTEMP einloggen
-- conn demo_deptemp/passme@oracledb
ALTER SESSION SET CURRENT_SCHEMA=DEMO_DEPTEMP;
@@deptemp
--conn sys@oracledb as sysdba
ALTER SESSION SET CURRENT_SCHEMA=SYS;
GRANT SELECT on demo_deptemp.dept TO PUBLIC;
GRANT SELECT on demo_deptemp.emp TO PUBLIC;
GRANT SELECT on demo_deptemp.salgrade TO PUBLIC;
--prompt *** password fuer SYS eingeben ***
alter user demo_deptemp account lock;
--spool off
prompt *** fertig ***
