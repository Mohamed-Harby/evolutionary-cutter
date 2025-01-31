package cutting;

public class Sheet {
    private final long width;
    private final long height;

    public Sheet(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public long getWidth() {
        return width;
    }


    public long getHeight() {
        return height;
    }



    @Override
    public String toString() {
        return "cutting.Sheet{" + "width=" + width + ", height=" + height + '}';
    }
}
