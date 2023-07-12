package com.example.testjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;

public class ChatApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("ConnectingScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        try
        {
            ChatController.nickname = InetAddress.getLocalHost().toString();
        }
        catch(Exception ex)
        {
            //System.out.println(ex);
        }
        stage.setOnCloseRequest(windowEvent -> {
            System.out.println("closing...");
            javafx.application.Platform.exit();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}