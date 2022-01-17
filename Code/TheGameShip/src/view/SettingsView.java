package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import launch.Launcher;
import javafx.fxml.FXML;
import model.util.settings.Settings;

public class SettingsView {

    @FXML
    private Slider difficultySlider;

    @FXML
    private Slider volumeSlider;

    private Settings settings;

    public void initialize() {
        loadSliderVolume();
        loadSliderDifficulty();

        settings = new Settings();
        difficultySlider.valueProperty().bindBidirectional(settings.difficultyProperty());
        volumeSlider.valueProperty().bindBidirectional(settings.volumeProperty());
    }

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
}
