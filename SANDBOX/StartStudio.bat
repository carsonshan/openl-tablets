@echo off

rem set the classes
setlocal EnableDelayedExpansion

set SITE=../site

set CP=%SITE%/plugins

FOR %%c in ("%SITE%/plugins/*.jar") DO set CP=!CP!;%SITE%/plugins/%%c


FOR %%c in ("%SITE%/org.openl.lib.apache.commons/*.jar") DO set CP=!CP!;%SITE%/org.openl.lib.apache.commons/%%c

set CATALINA_HOME=../org.openl.lib.apache.tomcat/apache-tomcat-5.5.17

FOR %%c in ("%CATALINA_HOME%/common/lib/*.jar") DO set CP=!CP!;%CATALINA_HOME%/common/lib/%%c

FOR %%c in ("%CATALINA_HOME%/server/lib/*.jar") DO set CP=!CP!;%CATALINA_HOME%%CATALINA_HOME%/server/lib/%%c

set CP=%CP%;../org.openl.lib.apache.tomcat/apache-tomcat-5.5.17/bin/bootstrap.jar
set CP=%CP%;../org.openl.rules.webstudio/bin
set CP=%CP%;../org.openl.rules.webtools/bin
set CP=%CP%;../com.exigen.rules.constrainer/bin
set CP=%CP%;../org.openl.rules.validator/bin
<<<<<<< StartStudio.bat
set CP=%CP%;../org.openl.tablets.tutorial4/bin
set CP=%CP%;../org.openl.rules.examples.banking/bin
=======
set CP=%CP%;../TravelersPOC/bin
>>>>>>> 1.3

echo Classpath: %CP% > cp.log

java -Xms256M -Xmx1024M -cp %CP% org.openl.rules.webtools.StartTomcat

pause

