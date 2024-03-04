package exercise.connections;

import exercise.TcpConnection;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Connected implements Connection {
    private TcpConnection tcpConnection;
    private List<String> buffer = new ArrayList<>();

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error: connection already established");
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setConnection(new Disconnected(this.tcpConnection));
    }

    @Override
    public void write(String data) {
        buffer.add(data);
    }
}
// END
