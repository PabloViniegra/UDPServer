import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(8080);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] receive = new byte[65535];



        DatagramPacket datagramPacket = new DatagramPacket(receive, receive.length);
        assert datagramSocket != null;
        datagramSocket.receive(datagramPacket);
        String textReceived = new String(receive);
        System.out.println("Client: " + textReceived);


        datagramSocket.close();
    }


}

