package biz.markov.thinking.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Ex23_CharBufferContents {
    static String ENCODING = System.getProperty("file.encoding");

    public static void main(String[] args) throws IOException {
        String str = "3c82t c3tc32t \u0000hv3tchwe";
        FileChannel fc = new FileOutputStream(args[0]).getChannel();

        fc.write(ByteBuffer.wrap(str.getBytes()));
        fc.close();

        ByteBuffer buffer = ByteBuffer.allocate(64);

        fc = new FileInputStream(args[0]).getChannel();
        fc.read(buffer);
        fc.close();

        buffer.flip();
        System.out.println(Charset.forName(ENCODING).decode(buffer));

        buffer.rewind();
        print(Charset.forName(ENCODING).decode(buffer));
    }

    static void print(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            char ch = charBuffer.get();
            if (ch < 32 || ch > 127) {
                break;
            }
            System.out.print(ch);
        }
    }
}
