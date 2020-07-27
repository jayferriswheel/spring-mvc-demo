package com.carto.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * blocking io
 *
 * @author yangjie263
 * @date 2020/6/30 17:38
 */
public class BIO {

    /**
     * blocking io，可以看到client和server都处于等待状态；
     */
    public void bio() {
        int port = 8001;
        Thread thread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                while (true) {
                    Socket socket = serverSocket.accept();
                    while (true) {
                        Thread handlerThread = new Thread(() -> {
                            try {
                                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                                printWriter.println("hello again");
                                printWriter.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("客户端： " + s));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
