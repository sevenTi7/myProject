package com.seven;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class TestHeap {
    public static void main(String[] args) throws Exception{
        List<ByteBuffer> moc = new ArrayList<>();
        int count = 1;
        while (true) {
            //moc.add(addToHeap(10 * 1024 * 1024));
            //moc.add(addToOffHeap(10 * 1024 * 1024));
            moc.add(addToMMap(300 * 1024 * 1024));
            count++;
            //TimeUnit.MILLISECONDS.sleep(200);
        }
    }

    private static ByteBuffer addToHeap(int size) {
        return ByteBuffer.allocate(size);
    }

    private static ByteBuffer addToOffHeap(int size) {

        return ByteBuffer.allocateDirect(size);
    }

    private static ByteBuffer addToMMap(int size) {
        try {
            RandomAccessFile raf = new RandomAccessFile(new File("/home/caowenyuan/test.log"), "rw");
            FileChannel channel = raf.getChannel();
            MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_WRITE, 0, 500 * 1024 * 1024);
            buff.put(new byte[size]);
            channel.close();
            raf.close();
            return buff;
        } catch (Exception e) {

        }
        return null;
    }
}
