package part2;

public class Work {
    private final int workindex;
    private final double size;

    public Work(int workindex, double size) {
        this.workindex = workindex;
        this.size = size;
    }

    public int getWorkindex() {
        return workindex;
    }

    public double getSize() {
        return size;
    }
}
