package misc;
// This class implements a Map cell

public final class Cell {
    private char type;
    private int xPos;
    private int yPos;

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
