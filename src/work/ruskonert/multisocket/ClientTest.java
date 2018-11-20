package work.ruskonert.multisocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest
{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 9999));
        while(true)
        {
            System.out.print("message: ");
            byte c[] = new Scanner(System.in).nextLine().getBytes();
            socket.getOutputStream().write(c, 0, c.length);
        }
    }
}
