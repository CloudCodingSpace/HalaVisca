package org.hv.core;

import java.io.*;
import java.util.*;

public class Utils {

    public static List<String> ReadFile(String path) {
        List<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

            String line = "";
            while((line = reader.readLine()) != null) {
                line += "\n";
                lines.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public static String ListStrToStr(List<String> list) {
        String result = "";

        for(String str : list) {
            result += str;
        }

        return result;
    }
}
