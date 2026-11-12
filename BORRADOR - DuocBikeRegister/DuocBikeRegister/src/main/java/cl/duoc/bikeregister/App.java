package cl.duoc.bikeregister;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static final String VISTA = "/cl/duoc/bikeregister/view/main-view.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(VISTA));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Duoc Bike Register | Registro de bicicletas");
        stage.setMinWidth(1050);
        stage.setMinHeight(700);
        stage.setScene(scene);
        stage.show();
    }
}
