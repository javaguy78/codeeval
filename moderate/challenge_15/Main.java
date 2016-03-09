package code.eval.medium.challenge_15;

import java.nio.ByteOrder;

// Challenge 15: Endianness of the system
public class Main {

    public static void main(String[] args) {
       if (java.nio.ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
           System.out.println("LittleEndian");
       } else {
           System.out.println("BigEndian");
       }
    }
}
