package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private Connection connection;

    public TcpConnection(String iP, int port) {
        this.connection = new Disconnected(this);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection(Connection connection)  {
        this.connection = connection;
    }

    public String getCurrentState() {
        return this.connection.getCurrentState();
    }
    public void connect() {
        this.connection.connect();
    }
    public void disconnect() {
        this.connection.disconnect();
    }
    public void write(String data) {
        this.connection.write(data);
    }
}
// END
