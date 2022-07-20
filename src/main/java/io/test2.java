package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("src/main/resources/output.txt")) {
            byte[] array = "JavaGuide".getBytes();
            output.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
