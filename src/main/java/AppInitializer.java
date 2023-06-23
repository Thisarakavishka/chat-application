import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Server.fxml"))));
        stage.setTitle("Server");
        stage.show();

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Client.fxml"))));
        stage1.setTitle("Client");
        stage1.show();
    }
}
