package com.sda;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        boolean b = true;
        while (b) { //pętla na całym kodzie odpowiedzialny za obsługę socketu - pobiera wartość i dalej działa, zamykamy połączenie, a nie serwer
            try { //serwer teraz przyjmuje zapytanie, dodaje nowy wątek, czeka na kolejne połączenie
                Socket socket = serverSocket.accept();
                ServerTask serverTask = new ServerTask(socket);
                new Thread(serverTask).start();
            } catch (Exception e) {

            }
        }
        serverSocket.close();
    }
}
