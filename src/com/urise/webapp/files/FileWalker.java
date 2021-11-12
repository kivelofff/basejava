package com.urise.webapp.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWalker {


    public static List<String> getFiles(File file) {
        if (!file.isDirectory()) {

            return List.of(file.getAbsolutePath());

        } else {
            List<String> output = new ArrayList<>();
            String[] currentDir = file.list();
            if (currentDir != null) {
                for (int i = 0; i < currentDir.length; i++) {
                    File f = new File(currentDir[i]);
                    if (f.isFile()) {

                            output.add(f.getAbsolutePath());
                    } else {
                        output.addAll(getFiles(f));
                    }
                }
            }
            return output;
        }


    }

    public static void main(String[] args) {

        List<String> files = getFiles(new File(".//"));
        for (String s: files) {
            System.out.println(s);
        }
    }
}
