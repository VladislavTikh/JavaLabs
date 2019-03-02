package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyGUI extends Application {

    @Override

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        GUICreator View=new GUICreator();
        primaryStage.setScene(View.CreateScene());
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}