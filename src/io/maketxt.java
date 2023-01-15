package io;

import java.io.File;
import java.io.IOException;

public class maketxt {
    //d/f/g/h/new
    //      new.txt   d/f/g/new.txt
    public maketxt(String path , String name) throws IOException {
        if (name!=null) {
            File file = new File(path);
            if (file.isFile()) {
                File parentFile = file.getParentFile();
                String absolutePath = parentFile.getAbsolutePath()+"\\"+name+".txt";
                System.out.println(absolutePath);
                File file1 = new File(absolutePath);
                file1.createNewFile();
            }else if (file.isDirectory()){
                String s = file.getAbsolutePath() + "\\" + name+".txt";
                File file2 = new File(s);
                file2.createNewFile();
            }
        }
    }
}
