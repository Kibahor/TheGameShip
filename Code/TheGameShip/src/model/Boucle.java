package model;

public class Boucle extends Thread {

    public void run()
    {
        // Faudra arranger ça
        while (true) {
            try {
                sleep(50);
                //update();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
