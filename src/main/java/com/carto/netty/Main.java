package com.carto.netty;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Main {
    public static void copyFileWithFileChannel(String srcFileName, String destFileName) throws IOException {
        RandomAccessFile srcFile = new RandomAccessFile(srcFileName, "r");
        FileChannel srcFileChannel = srcFile.getChannel();

        RandomAccessFile destFile = new RandomAccessFile(destFileName, "rw");
        FileChannel destFileChannel = destFile.getChannel();

        long position = 0;
        long count = srcFileChannel.size();

        srcFileChannel.transferTo(position, count, destFileChannel);
    }
}
