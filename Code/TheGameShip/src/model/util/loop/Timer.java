package model.util.loop;

public class Timer implements IObserver {

    private long millis;
    private long timer = 0;
        public long getTimer() {
        return timer;
    }
        public void resetTimer() { timer = 0; }

    public Timer(Loop loop) {
        millis=loop.getMillis();
    }

    @Override
    public void update() {
        timer += millis;
    }
}
