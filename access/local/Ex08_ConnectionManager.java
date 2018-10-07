package biz.markov.thinking.access.local;

class Ex08_Connection {
    boolean isOn;
    int id;

    Ex08_Connection(int numConnections) {
        isOn = true;
        id = numConnections;
    }

    protected void finalize() {
        isOn = false;
    }
}

public class Ex08_ConnectionManager {
    Ex08_ConnectionManager() {}

    static Ex08_Connection[] connections = new Ex08_Connection[4];
    static int numConnections = 0;

    public static Ex08_Connection connect() {
        if (numConnections < connections.length) {
            connections[numConnections] = new Ex08_Connection(numConnections);
            System.out.println("Connection " + numConnections + " created");
            return connections[numConnections++];
        } else {
            System.out.println("Can't create new connection");
            return null;
        }
    }

    public static void disconnect(int connection) {
        connections[connection].isOn = false;
        connections[connection] = null;
        System.out.println("Connection " + connection + " aborted");
    }

    public static boolean test(int connection) {
        if (connections[connection] != null) {
            System.out.println("Connection " + connection + " is on");
            return true;
        } else {
            System.out.println("Connection " + connection + " is off");
            return false;
        }
    }
}
