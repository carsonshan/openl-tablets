package org.openl.rules.tableeditor.model.ui;

import org.openl.rules.table.ui.ICellFont;
import org.openl.rules.table.ui.IColorFilter;

public class CellModelDelegator implements ICellModel {
    CellModel model;

    public CellModelDelegator(CellModel model) {
        this.model = model;
    }

    public BorderStyle[] getBorderStyle() {
        return model.getBorderStyle();
    }

    public int getColspan() {
        return model.getColspan();
    }

    public String getContent() {
        return model.getContent();
    }

    public ICellFont getFont() {
        return model.getFont();
    }

    public int getIdent() {
        return model.getIdent();
    }

    public CellModel getModel() {
        return model;
    }

    public short[] getRgbBackground() {
        return model.getRgbBackground();
    }

    public int getRowspan() {
        return model.getRowspan();
    }

    public boolean isReal() {
        return false;
    }

    public void setBorderStyle(BorderStyle[] borderStyle) {
        model.setBorderStyle(borderStyle);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.openl.rules.ui.ICellModel#setColorFilter(org.openl.rules.ui.IColorFilter[])
     */
    public void setColorFilter(IColorFilter[] filter) {
        // TODO Auto-generated method stub

    }

    public void setColspan(int colspan) {
        model.setColspan(colspan);
    }

    public void setContent(String content) {
        model.setContent(content);
    }

    public void setFont(ICellFont font) {
        model.setFont(font);
    }

    public void setIdent(int ident) {
        model.setIdent(ident);
    }

    public void setRgbBackground(short[] rgbBackground) {
        model.setRgbBackground(rgbBackground);
    }

    public void setRowspan(int rowspan) {
        model.setRowspan(rowspan);
    }

    public void toHtmlString(StringBuffer buf, TableModel table) {
        model.toHtmlString(buf, table);
    }
}
