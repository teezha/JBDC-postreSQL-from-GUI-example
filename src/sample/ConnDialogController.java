package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by A00987765 on 23/01/2017.
 */
public class ConnDialogController implements Initializable{

    // ===========================================================
    // Private fields for a ConnectionInfo object
    // might need static
    // ===========================================================
    private ConnectionInfo connectionInfo;


    // ===========================================================
    // UI code hooks ... need to hook-back in scene builder
    // ===========================================================
    @FXML
    GridPane root;
    @FXML
    TextField txtConnectivityType;
    @FXML
    TextField txtDbmsVendorType;
    @FXML
    TextField txtServerNameOrIP;
    @FXML
    TextField txtServerPort;
    @FXML
    TextField txtDefaultDatabase;
    @FXML
    TextField txtUserName;
    @FXML
    PasswordField pwdUserPassword;


    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ===========================================================
        // now you can uncomment the line in ConnectionInfoDialog
        // ===========================================================
        this.connectionInfo = new ConnectionInfo();
        // ===========================================================
        // Bind the UI to the ConnectionInfo class
        // ===========================================================
        txtConnectivityType.textProperty().bindBidirectional(
                this.getConnectionInfo().connectivityTypeProperty());

        txtDbmsVendorType.textProperty().bindBidirectional(
                this.getConnectionInfo().dbmsVendorProperty());

        txtDefaultDatabase.textProperty().bindBidirectional(
                this.getConnectionInfo().defaultDatabaseProperty());

        txtServerNameOrIP.textProperty().bindBidirectional(
                this.getConnectionInfo().serverNameOrIPProperty());

        txtServerPort.textProperty().bindBidirectional(
                this.getConnectionInfo().serverPortProperty());

        txtUserName.textProperty().bindBidirectional(
                this.getConnectionInfo().userNameProperty());

        pwdUserPassword.textProperty().bindBidirectional(
                this.getConnectionInfo().userPasswordProperty());

    }
    public void dialogHide()
    {

        Stage stage = (Stage) root.getScene().getWindow();
        stage.hide();
    }

    public void cancel()
    {
        dialogHide();
    }

    public void testConnection()
    {
        this.getConnectionInfo().testConnection();
        if (this.getConnectionInfo().isValid())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"connected. yes");
            alert.showAndWait();
            dialogHide();
        }
    }
}
