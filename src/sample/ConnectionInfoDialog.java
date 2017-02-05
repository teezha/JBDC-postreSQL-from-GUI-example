package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by A00987765 on 23/01/2017.
 */
public class ConnectionInfoDialog extends Stage{


    // ===========================================================
    // Private fields for a ConnectionInfo object
    // might need static
    // ===========================================================
    private ConnectionInfo connectionInfo;



// ===========================================================
// How we want to start the JavaFX application
// borrowed from the main of a JavaFX project
// changed the file name to "ConnInfoDialog.fxml"
// ===========================================================

    public ConnectionInfoDialog() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConnInfoDialog.fxml"));
        Parent root = fxmlLoader.load();
        setTitle("Connect to PostgreSQL ...");
        setScene(new Scene(root, 600, 400));
        ConnDialogController connDialogController = fxmlLoader.getController();
        this.setConnectionInfo(connDialogController.getConnectionInfo());
    }

    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }
}
