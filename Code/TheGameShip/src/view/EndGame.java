package view;

import javafx.event.ActionEvent;
import launch.Launcher;

public class EndGame {

    public void initialize() {}

    public void Retry(ActionEvent actionEvent) {}   //TODO: Trouver comment trouver le niveau actif ou sinon envoyer au choix des niveaux
    public void RageQuit(ActionEvent actionEvent) { Launcher.getStage().close(); }
}
