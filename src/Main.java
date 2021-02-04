import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket datagramSocket = null;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        try {

            datagramSocket = new DatagramSocket(8080);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] receive = new byte[65535];
        DatagramPacket datagramPacket = new DatagramPacket(receive, receive.length);
        datagramSocket.receive(datagramPacket);
        byteArrayInputStream = new ByteArrayInputStream(receive);
        objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Message message = (Message) objectInputStream.readObject();
        assert datagramSocket != null;

        System.out.println("Client: " + message.getId());
        System.out.println("Client: " + message.getMsg());
        datagramSocket.close();
    }


}

