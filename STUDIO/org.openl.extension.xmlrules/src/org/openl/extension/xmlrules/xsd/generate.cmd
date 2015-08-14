@echo on
rem  Generate ServiceModel XSD file using JDK schemagen utility
rem  Before running - correct JDK_HOME
SET CP=..\..\..\..\..\..\target\classes
SET OUT=.

schemagen.exe -cp %CP% -d %OUT% org.openl.extension.xmlrules.model.single.ExtensionModuleInfo
IF EXIST model.xsd del /F model.xsd
rename schema1.xsd model.xsd

schemagen.exe -cp %CP% -d %OUT% org.openl.extension.xmlrules.model.single.TypeImpl
IF EXIST type.xsd del /F type.xsd
rename schema1.xsd type.xsd

schemagen.exe -cp %CP% -d %OUT% org.openl.extension.xmlrules.model.single.DataInstanceImpl
IF EXIST data-instance.xsd del /F data-instance.xsd
rename schema1.xsd data-instance.xsd

schemagen.exe -cp %CP% -d %OUT% org.openl.extension.xmlrules.model.single.TableImpl
IF EXIST table.xsd del /F table.xsd
rename schema1.xsd table.xsd

schemagen.exe -cp %CP% -d %OUT% org.openl.extension.xmlrules.model.single.FunctionImpl
IF EXIST function.xsd del /F function.xsd
rename schema1.xsd function.xsd

schemagen.exe -cp %CP% -d %OUT% org.openl.extension.xmlrules.model.single.Cells
IF EXIST cells.xsd del /F cells.xsd
rename schema1.xsd cells.xsd