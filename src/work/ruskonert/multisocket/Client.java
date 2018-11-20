package work.ruskonert.multisocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client extends Thread
{
    private Socket socket = null;
    private InputStream stream = null;

    public Client(Socket socket)
    {
        this.socket = socket;
        try {
            this.stream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void run() {
        while (true)
        {
            try
            {
                StringBuilder builder = new StringBuilder();
                int MAX_LEN = 2048;
                byte data[] = new byte[MAX_LEN];
                stream.read(data, 0, data.length);
                builder.append(new String(data));
                synchronized (Client.class) {
                    System.out.println(String.format("The client %s send the message: %s", this.socket.getInetAddress().toString(), builder.toString()));
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
}
