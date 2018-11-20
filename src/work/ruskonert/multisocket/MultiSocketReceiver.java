package work.ruskonert.multisocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiSocketReceiver extends Thread
{
    private List<Client> multipleClient = new ArrayList<>();
    private Boolean isExit = false;
    private ServerSocket serverSocket = null;

    public MultiSocketReceiver()
    {
        try {
            this.serverSocket = new ServerSocket();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopListen() { this.isExit = true; }

    @Override
    public final void run()
    {
        while(! this.isExit) {
            Socket socket;
            try
            {
                socket = serverSocket.accept();
                Client client = new Client(socket);
                client.start();
                this.multipleClient.add(client);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void startListen(int port)
    {
        try
        {
            this.serverSocket.bind(new InetSocketAddress(port));
            this.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}