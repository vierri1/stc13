package lesson8.sockets.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    public final static Integer SERVER_PORT = 4999;
    private static List<Socket> sockets = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            Thread th = new Thread(() -> {
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();
                        if (socket != null) {
                            sockets.add(socket);
                            String socketName = getSocketName(socket);
                            ServerListener listener = new ServerListener(socket);
                            LocalTime time;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            time = LocalTime.now();
                            listener.sendMessage(time.format(formatter) + " the user " + socketName + " has connected to the server!");
                            listener.start();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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


    private static String getSocketName(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.readLine();
    }


    private static class ServerListener extends Thread {
        private Socket socket;

        private ServerListener(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = socket.getInputStream()) {
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(inputStream));
                String message;
                while (!(message = clientReader.readLine()).endsWith("quit")) {
                    sendMessage(message);
                }
                LocalTime time;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                time = LocalTime.now();
                sockets.remove(socket);
                socket.close();
                socket = null;
                String[] str = message.split(" ");
                sendMessage(time.format(formatter) + " " + str[1] + " disconnects from the server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMessage(String message) {
            for (Socket socket : sockets) {
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

}
