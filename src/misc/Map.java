package misc;

import java.util.ArrayList;

public final class Map {
    private static Map instance = null;
    private ArrayList<ArrayList<Cell>> cellMap;
    private int xSize;
    private int ySize;

    private Map() {
        //
    }
    public void createCellMap() {
        cellMap = new ArrayList<>();
        for (int i = 0; i < xSize; ++i) {
            cellMap.add(new ArrayList<>());
        }

        for (int i = 0; i < xSize; ++i) {
            for (int j = 0; j < ySize; ++j) {
                cellMap.get(i).add(new Cell(i, j));
            }
        }
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public void setCellTypes(final ArrayList<ArrayList<String>> cellTypes) {
        for (int i = 0; i < xSize; ++i) {
            for (int j = 0; j < ySize; ++j) {
                cellMap.get(i).get(j).setType(cellTypes.get(i).get(j));
            }
        }
    }

    public void printCellMap() {
        for (int i = 0; i < xSize; ++i) {
            for (int j = 0; j < ySize; ++j) {
                System.out.print(cellMap.get(i).get(j).getType() + " ");
            }
            System.out.println();
        }
    }

    public int getXSize() {
        return xSize;
    }

    public void setXSize(final int xSizeVal) {
        xSize = xSizeVal;
    }

    public int getYSize() {
        return ySize;
    }

    public void setYSize(final int ySizeVal) {
        ySize = ySizeVal;
    }

    public Cell getCell(final int xPos, final int yPos) {
        return cellMap.get(xPos).get(yPos);
    }
}
