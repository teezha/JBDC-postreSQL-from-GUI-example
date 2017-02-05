package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;


// ==========================================================================
// ==================== Section:     Constructors============================
// ==========================================================================


/**
 * Created by A00987765 on 23/01/2017.
 */
public class ConnectionInfo {

    // ===========================================================
    // A series of vars to store connection information
    // ===========================================================
    private StringProperty connectivityType;
    private StringProperty dbmsVendor;
    private StringProperty serverNameOrIP;
    private StringProperty serverPort;
    private StringProperty defaultDatabase;
    private StringProperty userName;
    private StringProperty userPassword;
    private boolean isValid;
    private Connection connection;

    public ConnectionInfo() {



        // ==========================================================================
        // ==================== Section:   Setr n Getr ============================
        // ==========================================================================

        // ===========================================================
        // Set the default values on the String Property vars
        // Switch these to your account info while you are testing
        // ===========================================================
        this.connectivityType = new SimpleStringProperty("jdbc");
        this.dbmsVendor = new SimpleStringProperty("postgresql");
        this.serverNameOrIP = new SimpleStringProperty("gamma.athena.bcit.ca");
        this.serverPort = new SimpleStringProperty("5432");
        this.defaultDatabase = new SimpleStringProperty("a00987765");
        this.userName = new SimpleStringProperty("a00987765");
        this.userPassword = new SimpleStringProperty("******");
        this.isValid = false;
        this.connection = null;
    }


    // ==========================================================================
    // ==================== Section:    more             ============================
    // ==========================================================================

    public String getConnectivityType() {
        return connectivityType.get();
    }

    public StringProperty connectivityTypeProperty() {
        return connectivityType;
    }

    public void setConnectivityType(String connectivityType) {
        this.connectivityType.set(connectivityType);
    }

    public String getDbmsVendor() {
        return dbmsVendor.get();
    }

    public StringProperty dbmsVendorProperty() {
        return dbmsVendor;
    }

    public void setDbmsVendor(String dbmsVendor) {
        this.dbmsVendor.set(dbmsVendor);
    }

    public String getServerNameOrIP() {
        return serverNameOrIP.get();
    }

    public StringProperty serverNameOrIPProperty() {
        return serverNameOrIP;
    }

    public void setServerNameOrIP(String serverNameOrIP) {
        this.serverNameOrIP.set(serverNameOrIP);
    }

    public String getServerPort() {
        return serverPort.get();
    }

    public StringProperty serverPortProperty() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort.set(serverPort);
    }

    public String getDefaultDatabase() {
        return defaultDatabase.get();
    }

    public StringProperty defaultDatabaseProperty() {
        return defaultDatabase;
    }

    public void setDefaultDatabase(String defaultDatabase) {
        this.defaultDatabase.set(defaultDatabase);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserPassword() {
        return userPassword.get();
    }

    public StringProperty userPasswordProperty() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.set(userPassword);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }



    // ==========================================================================
    // ==================== Section:                 ============================
    // ==========================================================================

    // ===========================================================
    // Convenience getter for a correctly formated JDBC URL
    // ===========================================================
    public String getDatabaseURL() {
        return (String.format("%s:%s://%s:%s/%s", this.connectivityType.get(),
                this.dbmsVendor.get(), this.serverNameOrIP.get(),
                this.serverPort.get(), this.defaultDatabase.get()));
    }


    // ==========================================================================
    // ==================== Section:      regmeth           ============================
    // ==========================================================================


    public void testConnection()
    {
        try {

            this.setValid(false);
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(this.getDatabaseURL(), this.getUserName(), this.getUserPassword());
            this.setValid(true);
            this.setConnection(connection);


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, e.getMessage());
            alert.showAndWait();
        }

    }




}
