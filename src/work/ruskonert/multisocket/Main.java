package work.ruskonert.multisocket;

public class Main {
    public static void main(String[] args)
    {
        MultiSocketReceiver server = new MultiSocketReceiver();
        server.startListen(9999);
    }
}
