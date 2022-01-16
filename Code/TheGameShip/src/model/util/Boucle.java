package model.util;

import static java.lang.Thread.sleep;

public class Boucle extends Observable implements Runnable {
    private final long millis;
    private boolean isRunning = true;
    private long timer=0;
        public long getTimer() {
            return timer;
        }
        public void resetTimer(){timer=0;}

    public Boucle(long millis) {
        this.millis = millis;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                sleep(millis);
                timer+=millis;
                notifier();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void StopBoucle(){ isRunning = false; }
    public void StartBoucle(){
        isRunning = true;
    }
}