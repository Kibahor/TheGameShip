package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import launch.Launcher;
import javafx.fxml.FXML;

public class Settings {

    @FXML
    private Slider difficultySlider;

    @FXML
    private Slider volumeSlider;

    public void initialize() {
        loadSliderVolume();
        loadSliderDifficulty();
    }

    public void difficulty(ActionEvent actionEvent) { System.out.println("Inopérant."); }     //TODO: garder ça en mémoire qq part
    public void volume(ActionEvent actionEvent) { System.out.println("Inopérant."); }         //TODO: garder ça en mémoire qq part

    public void menu(ActionEvent actionEvent){ Launcher.getViewManager().setView("Menu"); }
    public void reset(ActionEvent actionEvent) {
        difficultySlider.setValue(2);
        volumeSlider.setValue(50);
    }

    public void loadSliderDifficulty() {
        difficultySlider.setMin(1);
        difficultySlider.setMax(3);
        difficultySlider.setMajorTickUnit(1);
        difficultySlider.setBlockIncrement(1);
        difficultySlider.setMinorTickCount(0);
        volumeSlider.setSnapToTicks(true);
        volumeSlider.setShowTickLabels(true);
    }

    public void loadSliderVolume() {
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setMajorTickUnit(10);
        volumeSlider.setBlockIncrement(10);
        volumeSlider.setMinorTickCount(0);
        volumeSlider.setSnapToTicks(true);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setValue(50);
    }
}
