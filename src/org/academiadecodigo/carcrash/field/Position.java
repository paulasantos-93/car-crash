package org.academiadecodigo.carcrash.field;

/**
 * Represents a position in a grid of columns and rows
 */
public class Position {

    private int row;
    private int col;

    public Position() {
        setRandom();
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRandom() {
        this.row = (int) (Math.random() * Field.getHeight());
        this.col = (int) (Math.random() * Field.getWidth());
    }

    public void moveDown() {
        if (this.row < Field.getHeight()) {
            this.row++;
        } else {
            this.row = Field.getHeight() - 1;
        }
    }

    public void moveUp() {
        if (this.row > 0) {
            this.row--;
        } else {
            this.row = 0;
        }
    }

    public void moveLeft() {
        if (this.col > 0) {
            this.col--;
        } else {
            this.col = 0;
        }
    }

    public void moveRight() {

        if (this.col < Field.getWidth()) {
            this.col++;
        } else {
            this.col = Field.getWidth() - 1;
        }
    }

    public void moveInDirection(Direction direction) {


        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public boolean isEdge(Direction direction) {

        return (direction == Direction.UP && row == 0) ||
                (direction == Direction.DOWN && row == Field.getHeight() - 1) ||
                (direction == Direction.LEFT && col == 0) ||
                (direction == Direction.RIGHT && col == Field.getWidth() - 1);
    }

    /**
     * Tests for position equality
     *
     * @param position The position to compare with
     * @return result of comparing positions
     */
    public boolean equals(Position position) {
        return col == position.getCol() &&
                row == position.getRow();
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
