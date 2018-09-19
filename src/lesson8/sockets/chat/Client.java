package lesson8.sockets.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static String clientName = "MyMy";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", Server.SERVER_PORT)) {
            ClientListener listener = new ClientListener(clientSocket);
            MessageSender sender = new MessageSender(clientSocket, clientName);
            sendSocketName(clientSocket, clientName);
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

    private static void sendSocketName(Socket socket, String clientName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(clientName);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }



}
