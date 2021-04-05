package level2.homework6.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ConsoleClient {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Scanner sc ;
    private final String USERNAME = "Aleksey";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean check = true;
    private final String x = "/bye";
    private ConsoleClient() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
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
        sc = new Scanner(System.in);
        while (check) {
            try {
                String str = sc.nextLine();
                if(!check){
                    break;
                }else if (str.equals(x)) {
                    out.writeUTF(x);
                    check = false;
                    allClose();
                    break;
                }else if(!str.equals("")) {
                    out.writeUTF(USERNAME + ": " + str);
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
                        if(!check){
                            break;
                        }
                        if (str.equals("/bye")) {
                            System.out.println("Server disconnected");
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
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ConsoleClient();
            }
        }).start();
    }
}
