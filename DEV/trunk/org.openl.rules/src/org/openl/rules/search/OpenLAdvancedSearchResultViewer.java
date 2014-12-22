/**
 * Created May 14, 2007
 */
package org.openl.rules.search;

import org.openl.rules.table.CompositeGrid;
import org.openl.rules.table.IGridRegion;
import org.openl.rules.table.IGridTable;
import org.openl.rules.table.TransposedGridTable;

/**
 * @author snshor
 * 
 */
@Deprecated
public class OpenLAdvancedSearchResultViewer {

    public OpenLAdvancedSearchResultViewer() {}

    private IGridTable align(IGridTable rowTable, boolean isVertical) {
        return isVertical == isVertical(rowTable) ? rowTable : new TransposedGridTable(rowTable);
    }

    private boolean isVertical(IGridTable t) {
        return IGridRegion.Tool.width(t.getRegion()) >= IGridRegion.Tool.height(t.getRegion());
    }

    public CompositeGrid makeGrid(ISearchTableRow[] rows) {
        if (rows.length == 0) {
            return null;
        }

        IGridTable header = rows[0].getTableSearchInfo().getHeader();
        boolean hasHeader = header != null;
        IGridTable[] tables = new IGridTable[rows.length + (hasHeader ? 1 : 0)];
        if (header != null) {
            tables[0] = header;
        }

        // boolean isVertical = rows[0].getRowTable().isNormalOrientation();

        boolean isVertical = isVertical(rows[0].getRowTable());

        for (int i = 0; i < rows.length; i++) {
            tables[(hasHeader ? 1 : 0) + i] = align(rows[i].getRowTable(), isVertical);
        }

        return new CompositeGrid(tables, isVertical);
    }

}