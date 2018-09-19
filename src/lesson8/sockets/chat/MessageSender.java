package lesson8.sockets.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender extends Thread {

    private Socket socket;
    private String user;

    public MessageSender(Socket socket, String user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() {
        try (OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream())) {
            Scanner scanner = new Scanner(System.in);
            String str;
            while (!(str = scanner.nextLine()).equals("")) {
                BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
                bufferedWriter.write(user + " написал: " + str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
