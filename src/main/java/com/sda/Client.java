package com.sda;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.100.167", 8081);
        Scanner consoleScanner = new Scanner(System.in);
        String name = consoleScanner.nextLine();
        String message = consoleScanner.nextLine();


        OutputStream outputStream = socket.getOutputStream();
        PrintWriter output = new PrintWriter(outputStream); //tworzymy obiekt który umożliwia do zapisywania do strumienia

        output.println(name);
        output.println(message);
        output.flush();

        Scanner scanner = new Scanner(socket.getInputStream());
        String next = scanner.nextLine();//czytam to co przyszło ze skanera
        System.out.println(next);

        socket.close();
    }
}
