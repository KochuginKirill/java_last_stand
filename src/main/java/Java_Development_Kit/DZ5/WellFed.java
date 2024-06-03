package Java_Development_Kit.DZ5;

public class WellFed {

    private volatile int wellFed;
    private int maxFed;

    public void WellFedIncrease() {
        this.wellFed++;
    }

    public WellFed(int maxFed) {
        this.wellFed = 0;
        this.maxFed = maxFed;
    }

    public int getWellFed() {
        return wellFed;
    }

    public int getMaxFed() {
        return maxFed;
    }

}
