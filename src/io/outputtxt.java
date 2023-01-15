package io;

import java.io.*;

//******Author：zhiminzhang
//******Data:2023/1/8 16:19
public class outputtxt {
    public outputtxt(String path, String content) throws FileNotFoundException {

        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
