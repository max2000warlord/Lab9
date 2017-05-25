import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class StoreApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        Parent root = loader.load();
		stage.setTitle("Store");
		stage.setScene(new Scene(root));
		stage.sizeToScene();
		stage.show();
                
        // Add code here to load the root node from the FXML file
        // and show it
    }
}
