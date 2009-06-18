package org.openl.rules.liveexcel.formula.lookup;

public class Grid {

    private String[][] grid;

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }

    public String getValue(int x, int y) {
        return grid[x][y];
    }

}
