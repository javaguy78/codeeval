package code.eval.medium;

import java.nio.ByteOrder;

// Endianness of the system
public class Challenge15 {

    public static void main(String[] args) {
       if (java.nio.ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
           System.out.println("LittleEndian");
       } else {
           System.out.println("BigEndian");
       }
    }
}
