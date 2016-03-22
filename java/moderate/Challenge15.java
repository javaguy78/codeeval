package moderate;

import java.nio.ByteOrder;

/**
 * Challenge 15 : Endianness
 * Created by cschalk on 3/21/16.
 */
public class Challenge15 {

    public static void main(String[] args) {
       if (java.nio.ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
           System.out.println("LittleEndian");
       } else {
           System.out.println("BigEndian");
       }
    }
}
