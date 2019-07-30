package com.demo.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-07-30
 * @time 19:15
 */
public class NioMain {

    public static void main(String[] args) {

        //bio();
        nio();
    }


    public static void bio() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("/Users/huipeizhu/git/java_demo/README.md"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);

                }
                bytesRead = in.read(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void nio() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("/Users/huipeizhu/git/java_demo/README.md", "rw");
            FileChannel fileChannel = aFile.getChannel();

            //分配空间
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //写入数据到Buffe
            int bytesRead = fileChannel.read(buf);


            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    //从Buffer中读取数据
                    System.out.print((char) buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
