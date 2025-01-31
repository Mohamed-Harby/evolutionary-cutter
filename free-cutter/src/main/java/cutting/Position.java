package cutting;

public class Position {
    Sheet sheet;
    long x;
    long y;

    public Position(Sheet sheet, long x, long y) {
        this.sheet = sheet;
        this.x = x;
        this.y = y;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "cutting.Position{" + "sheet=" + sheet + ", x=" + x + ", y=" + y + '}';
    }
}
