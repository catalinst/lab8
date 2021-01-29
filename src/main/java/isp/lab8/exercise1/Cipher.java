package isp.lab8.exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cipher {

    public void encrypt(String fileName) throws IOException {
        StringBuffer result = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
        String currentLine = reader.readLine();
        reader.close();
        FileWriter writer = new FileWriter(fileName + ".enc");

        for (int i = 0; i < currentLine.length(); i++) {
            if (currentLine.charAt(i) == ' ') {
                result.append(currentLine.charAt(i));
            } else {
                if (Character.isUpperCase(currentLine.charAt(i))) {
                    char ch = (char) (((int) currentLine.charAt(i) + 1 - 65) % 26 + 65);
                    result.append(ch);
                } else {
                    char ch = (char) (((int) currentLine.charAt(i) + 1 - 97) % 26 + 97);
                    result.append(ch);
                }
            }
        }

        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
    }

    public void decrypt(String fileName) throws IOException {
        StringBuffer result = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(fileName + ".enc"));
        String currentLine = reader.readLine();
        reader.close();
        FileWriter writer = new FileWriter(fileName + ".dec");

        for (int i = 0; i < currentLine.length(); i++) {
            if (currentLine.charAt(i) == ' ') {
                result.append(currentLine.charAt(i));
            } else {
                if (Character.isUpperCase(currentLine.charAt(i))) {
                    char ch = (char) (((int) currentLine.charAt(i) - 1 - 65) % 26 + 65);
                    result.append(ch);
                } else {
                    char ch = (char) (((int) currentLine.charAt(i) - 1 - 97) % 26 + 97);
                    result.append(ch);
                }
            }
        }

        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
    }
}
