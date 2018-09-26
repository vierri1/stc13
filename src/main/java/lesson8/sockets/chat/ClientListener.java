package lesson8.sockets.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientListener extends Thread {
    private Socket socket;

    public ClientListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream()) {
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(inputStream));
            String message;

            while (socket != null) {
                if ((message = clientReader.readLine()) != null) {
                    System.out.println(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
