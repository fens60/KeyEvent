package es.ieslosmontecillos.keyevent;
/*
* @author Shangfeng Shan
* @date 02/10/2024
* */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEvent extends Application {
    @Override
    public void start(Stage primaryStage) {
        //crear un objeto Text en la posición (20, 20) con el texto "A"
        Text text = new Text(20, 20, "A");

        //crear un Pane y añadir el Text
        Pane pane = new Pane();
        pane.getChildren().add(text);

        //registrar el manejador de evento de teclado en el Text
        text.setOnKeyPressed(event -> {
            //obtener la tecla presionada
            KeyCode keyCode = event.getCode();

            switch (keyCode) {
                case DOWN:
                    text.setY(text.getY() + 10); //mueve el texto 10 posiciones abajo
                    break;
                case UP:
                    text.setY(text.getY() - 10); //mueve el texto 10 posiciones arriba
                    break;
                case RIGHT:
                    text.setX(text.getX() + 10); //mueve el texto 10 posiciones a la derecha
                    break;
                case LEFT:
                    text.setX(text.getX() - 10); //mueve el texto 10 posiciones a la izquierda
                    break;
                default:
                    //si se presiona una letra o un dígito, cambiar el contenido del Text
                    if (event.getText().matches("[a-zA-Z0-9]")) {
                        text.setText(event.getText());
                    }
                    break;
            }
        });

        //crear una escena con el Pane
        Scene scene = new Scene(pane, 400, 300);

        //establecer el foco en el texto para capturar eventos de teclado
        text.setFocusTraversable(true);

        //configurar la ventana principal
        primaryStage.setTitle("KeyEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}