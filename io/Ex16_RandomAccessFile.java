/****************** Exercise 16 *****************
 * Look up RandomAccessFile in the JDK
 * documentation. Starting with
 * UsingRandomAccessFile.java, create a program
 * that stores and then retrieves all the different
 * possible types provided by the RandomAccessFile
 * class. Verify that the values are stored and
 * retrieved accurately.
 ***********************************************/
package biz.markov.thinking.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex16_RandomAccessFile {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");

        accessFile.writeBoolean(true);
        accessFile.writeByte(32);
        accessFile.writeShort(8989);
        accessFile.writeChar('Ы');
        accessFile.writeInt(58922);
        accessFile.writeLong(75002332L);
        accessFile.writeUTF("AFafe afejoie3w asfsaf");
        accessFile.writeChars("abc");
        accessFile.writeFloat(83.890F);
        accessFile.writeDouble(9320.883202);
        accessFile.seek(0L);

        System.out.println(accessFile.readBoolean());
        System.out.println(accessFile.readByte());
        System.out.println(accessFile.readShort());
        System.out.println(accessFile.readChar());
        System.out.println(accessFile.readInt());
        System.out.println(accessFile.readLong());
        System.out.println(accessFile.readUTF());
        System.out.println(accessFile.readChar());
        System.out.println(accessFile.readChar());
        System.out.println(accessFile.readChar());
        System.out.println(accessFile.readFloat());
        System.out.println(accessFile.readDouble());
        accessFile.close();
    }
}
