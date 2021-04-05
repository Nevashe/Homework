package level2.homework6.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ConsoleServer {

    private final int SERVER_PORT = 8189;

    private DataInputStream in;
    private DataOutputStream out;
    private Scanner sc = new Scanner(System.in);;
    private boolean check = true;
    private ServerSocket server;
    private Socket socket;
    public ConsoleServer() {
        server = null;
        socket = null;
        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запушен");

            socket = server.accept();
            System.out.printf("Клиент [%s] подключен\n", socket.getInetAddress());

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            inpMsg();
            sendMsg();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            allClose();
        }
    }

    private void sendMsg() {
        while (check) {
            try {
                String str = sc.nextLine();
                if(!check){
                    break;
                }else if (str.equals("/bye")) {
                    out.writeUTF("/bye");
                    check = false;
                    allClose();
                    break;
                }else if(!str.equals("")) {
                    out.writeUTF("Server: " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void inpMsg() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (check) {
                    try {
                        String str = in.readUTF();
                        if (!check) {
                            break;
                        }
                        if (str.equals("/bye")) {
                            check = false;
                            break;
                        }
                        System.out.println(str);
                    }catch (SocketException e){
                        System.out.println("Соединение разорвано");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void allClose(){
        sc.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ConsoleServer();
            }
        }).start();
    }
}