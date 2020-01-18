/****************** Exercise 15 *****************
 * Look up DataOutputStream and DataInputStream in
 * the JDK documentation. Starting with
 * StoringAndRecoveringData.java, create a program
 * that stores and then retrieves all the different
 * possible types provided by the DataOutputStream
 * and DataInputStream classes. Verify that the
 * values are stored and retrieved accurately.
 ***********************************************/
package biz.markov.thinking.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Ex15_DataStoring {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(byteOut));

        out.writeBoolean(true);
        out.writeByte(32);
        out.writeShort(8989);
        out.writeChar('Ы');
        out.writeInt(58922);
        out.writeLong(75002332L);
        out.writeUTF("AFafe afejoie3w asfsaf");
        out.writeChars("abc");
        out.writeFloat(83.890F);
        out.writeDouble(9320.883202);
        out.close();

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        DataInputStream in = new DataInputStream(new BufferedInputStream(byteIn));

        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
        System.out.println(in.readShort());
        System.out.println(in.readChar());
        System.out.println(in.readInt());
        System.out.println(in.readLong());
        System.out.println(in.readUTF());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readFloat());
        System.out.println(in.readDouble());
        in.close();
    }
}
