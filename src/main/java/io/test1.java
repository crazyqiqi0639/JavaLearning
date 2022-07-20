package io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test1 {
    public static void main(String[] args) {
        try (InputStream fis = Files.newInputStream(Paths.get("src/main/resources/input.txt"))) {
                System.out.println("Number of remaining bytes:"
                        + fis.available());
             int content;
             long skip = fis.skip(2);
             System.out.println("The actual number of bytes skipped:" + skip);
             System.out.print("The content read from file:");
    while ((content = fis.read()) != -1) {
            System.out.print((char) content);
        }
    } catch (
    IOException e) {
        e.printStackTrace();
    }
}
}
