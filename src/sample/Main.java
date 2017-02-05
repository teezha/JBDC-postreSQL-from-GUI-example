package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements EventHandler<WindowEvent> {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GIST 8010 Mod 3");
        primaryStage.setScene(new Scene(root,800, 600));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/Map_32x32.png")));
        primaryStage.show();
        primaryStage.setOnCloseRequest(this);
    }


//===========================================================
// The following block does ....
//===========================================================

    public static void main(String[] args) {
        launch(args);
    }
//===========================================================
// The following block does ....
//===========================================================

    @Override
    public void handle(WindowEvent event) {
        System.exit(0);
    }
}