package com.example.clientchat.dialogs;


import com.example.clientchat.ClientChat;
import javafx.scene.control.Alert;

public class Dialogs {

    public enum AuthError {
        EMPTY_CREDENTIALS("Login and password must be specified"),
        INVALID_CREDENTIALS("Username and password are set incorrectly");

        private static final String TITLE = "Authentication error";
        private static final String TYPE = TITLE;

        private final String message;

        AuthError(String message) {
            this.message = message;
        }

        public void show() {
            showDialog(Alert.AlertType.ERROR, TITLE, TITLE, message);
        }
    }

    public enum NetworkError {
        SEND_MESSAGE("Failed to send a message!"),
        SERVER_CONNECT("Failed to establish a connection with the server!");

        private static final String TITLE = "Network error";
        private static final String TYPE = "Data transmission error over the network";
        private final String message ;

        NetworkError(String message) {
            this.message = message;
        }

        public void show() {
            showDialog(Alert.AlertType.ERROR, TITLE, TYPE, message);
        }

    }

    private static void showDialog(Alert.AlertType dialogType, String title, String type, String message) {
        Alert alert = new Alert(dialogType);
        alert.initOwner(ClientChat.getInstance().getChatStage());
        alert.setTitle(title);
        alert.setHeaderText(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}