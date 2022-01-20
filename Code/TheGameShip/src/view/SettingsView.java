package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import launch.Launcher;
import javafx.fxml.FXML;
import model.util.data.Settings;
import model.util.save.PersistenceManager;

public class SettingsView {

    @FXML private Slider difficultySlider;
    @FXML private Slider volumeSlider;

    @FXML private Label up;
    @FXML private Label left;
    @FXML private Label down;
    @FXML private Label right;
    @FXML private Label shoot;

    private Settings settings;

    //TODO : Mettre dans le FXML
    public void loadSliderDifficulty() {
        difficultySlider.setMin(1);
        difficultySlider.setMax(3);
        difficultySlider.setMajorTickUnit(1);
        difficultySlider.setBlockIncrement(1);
        difficultySlider.setMinorTickCount(0);
        difficultySlider.setSnapToTicks(true);
        difficultySlider.setShowTickLabels(true);
    }

    public void loadSliderVolume() {
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setMajorTickUnit(10);
        volumeSlider.setBlockIncrement(10);
        volumeSlider.setMinorTickCount(0);
        volumeSlider.setSnapToTicks(true);
        volumeSlider.setShowTickLabels(true);
    }

    public void initialize() {
        settings = Launcher.getPersistenceManager().getSettings();

        loadSliderVolume();
        loadSliderDifficulty();

        difficultySlider.valueProperty().bindBidirectional(settings.difficultyProperty());
        volumeSlider.valueProperty().bindBidirectional(settings.volumeProperty());

        up.textProperty().bindBidirectional(settings.upProperty());
        left.textProperty().bindBidirectional(settings.leftProperty());
        down.textProperty().bindBidirectional(settings.downProperty());
        right.textProperty().bindBidirectional(settings.rightProperty());
        shoot.textProperty().bindBidirectional(settings.shootProperty());
    }

    public void menu(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("MenuView");
        Launcher.getPersistenceManager().saveSettings(settings);
    }

    public void reset(ActionEvent actionEvent) {
        difficultySlider.setValue(2);
        volumeSlider.setValue(50);
        up.setText("UP");
        left.setText("LEFT");
        down.setText("DOWN");
        right.setText("RIGHT");
        shoot.setText("SPACE");
    }

    public void changeUp(ActionEvent actionEvent) { System.out.println("up"); }         //TODO: Faire apparaitre une petite fenêtre où sera inscrit appuyez sur une touche. La touche sera ensuite assigné à la commande correspondante.
    public void changeLeft(ActionEvent actionEvent) { System.out.println("left"); }
    public void changeDown(ActionEvent actionEvent) { System.out.println("down"); }
    public void changeRight(ActionEvent actionEvent) { System.out.println("right"); }
    public void changeShoot(ActionEvent actionEvent) { System.out.println("shoot"); }
}
