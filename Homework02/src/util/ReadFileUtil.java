package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ReadFileUtil {

    Path filePath;

    public ReadFileUtil(String path) {
        filePath = Path.of(path);
        if (!Files.exists(filePath)) throw new IllegalArgumentException("Wrong path!");
    }

   public String readFile() {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
            br.lines().forEach(ln -> {
                sb.append(ln).append("\n");
            });
        } catch (IOException e) { e.printStackTrace(); }
        return sb.toString();
    }

}
