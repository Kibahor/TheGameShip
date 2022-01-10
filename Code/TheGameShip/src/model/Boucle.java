package model;

public abstract class Boucle extends Thread {

    public void run()
    {
        // TODO : Il faut créer une méthode qui permet de s'abonner a un eventHandler et notifier tout les abonnés
        while (true) {
            try {
                sleep(50);
                update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public abstract void update() throws Exception;

}
