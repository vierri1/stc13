package lesson8.sockets.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", Server.SERVER_PORT)) {
            MessageListener listener = new MessageListener(clientSocket);
            MessageSender sender = new MessageSender(clientSocket, "User3");
            listener.start();
            sender.start();
            listener.join();
            sender.join();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
