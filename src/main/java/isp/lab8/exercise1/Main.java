package isp.lab8.exercise1;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String file = args[0];
        String operation = args[1];
        Cipher cipher = new Cipher();

        try {
            if (operation.equals("encrypt")) {
                cipher.encrypt(file);
            } else if (operation.equals("decrypt")) {
                cipher.decrypt(file);
            } else {
                System.out.println("This operation is not available");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
