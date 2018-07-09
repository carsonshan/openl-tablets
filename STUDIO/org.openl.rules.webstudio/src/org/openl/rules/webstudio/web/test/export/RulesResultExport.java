package org.openl.rules.webstudio.web.test.export;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openl.rules.testmethod.TestUnit;
import org.openl.rules.testmethod.TestUnitsResults;

public class RulesResultExport extends ResultExport {
    public RulesResultExport(TestUnitsResults results) {
        super(new TestUnitsResults[] { results }, -1);
    }

    @Override
    protected int writeInfo(Sheet sheet, TestUnitsResults result, int rowNum) {
        return rowNum;
    }

    @Override
    protected void writeResultHeader(TestUnitsResults result, Row row, int colNum) {
        createCell(row, colNum, "Result", styles.header);
    }

    @Override
    protected void writeResult(Row row, int colNum, TestUnit testUnit) {
        createCell(row, colNum, testUnit.getActualParam(), styles.resultSuccess);
    }
}