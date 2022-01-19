package view;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class View {
    private Parent parent;
        public Parent getParent() {
            if(parent == null){
                int fontsize = 20;
                Pane pane = new Pane();
                Text texte = new Text(0,fontsize,"Impossible de charger la vue : "+ path);
                texte.setFill(Color.RED);
                texte.setFont(new Font(fontsize));
                pane.getChildren().add(texte);
                return pane;
            }
            return parent;
        }
        public void setParent(Parent parent) { this.parent = parent; }

    private Boolean initialize = false;
        public Boolean isInitialize() {return initialize;}

    private String path;
        public String getPath() {return path;}

    public View(String path) {
        this.path = path;
        this.initialize=true;
    }
}
