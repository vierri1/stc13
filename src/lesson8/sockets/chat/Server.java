package lesson8.sockets.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public final static Integer SERVER_PORT = 4999;
    private static ArrayList<Socket> clients = new ArrayList();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {

            Thread th = new Thread(() -> {
                while (true) {
                    Socket socket = null;
                    try {
                        socket = serverSocket.accept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (socket != null) {
                        clients.add(socket);
                        MessageListener listener = new MessageListener(socket);
                        listener.sendMessage("client joined");
                        listener.start();
                    }
                }
            });
            th.start();
            th.join();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Socket> getClients() {
        return clients;
    }
}
