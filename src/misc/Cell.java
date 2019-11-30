package misc;
// This class implements a Map cell

public final class Cell {
    private String type;
    private int xPos;
    private int yPos;

    Cell(final int xPos, final int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Cell(final int xPos, final int yPos, final String type) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPosVal) {
        this.xPos = xPosVal;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPosVal) {
        this.yPos = yPosVal;
    }
}
