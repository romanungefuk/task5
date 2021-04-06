public class TimeManager {
    private long startTime;
    private long endTime;

    public void setStartTime() {
        this.startTime = System.nanoTime();
    }

    public void setEndTime() {
        this.endTime = System.nanoTime();
    }

    public long getRunTime() {
        return endTime - startTime;
    }
}
