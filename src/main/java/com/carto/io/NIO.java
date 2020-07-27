package com.carto.io;

import com.carto.juc.ThreadPoolExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * no blocking io
 *
 * @author yangjie263
 * @date 2020/6/30 17:49
 */
public class NIO {
    /**
     * 服务端仅在select过程是阻塞的，在实际应用中，会采用reactor模型，只有监听连接的才是阻塞的，处理请求的都是非阻塞的；这只是nio+io多路复用的一种组合方式
     * 客户端仍然是阻塞的
     */
    public void nio() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(() -> {
            try (Selector selector = Selector.open(); ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
                serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 9901));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                while (true) {
                    selector.select(); // 阻塞等待就绪的channel
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        try (SocketChannel channel = (SocketChannel) key.channel()) {
                            channel.write(Charset.defaultCharset().encode("你好，世界"));
                        }
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try (Socket cSocket = new Socket(InetAddress.getLocalHost(), 9901)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("NIO客户端：" + s));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
