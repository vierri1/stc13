package lesson8.sockets.chat;

import java.io.*;
import java.net.Socket;

public class MessageListener extends Thread {
    private Socket socket;

    public MessageListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream()) {
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            while ((message = clientReader.readLine()) != null) {
                System.out.println(message);
                sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        for (Socket socket : Server.getClients()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
