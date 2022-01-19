package model.util.loop;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

public class Loop extends Observable implements Runnable {

    private final long millis;
    private boolean isRunning = true;

    private long timer = 0;
        public long getTimer() {
            return timer;
        }
        public void resetTimer() { timer = 0; }

    public Loop(long millis) {
        this.millis = millis;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                sleep(millis);
                timer += millis;
                Platform.runLater(() -> notifier());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void StopBoucle(){ isRunning = false; }
    public void StartBoucle(){
        isRunning = true;
    }
}