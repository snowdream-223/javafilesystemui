package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class runtime {
    public static void main(String[] args) throws IOException {
        Process exec = Runtime.getRuntime().exec("ipconfig");
        InputStream inputStream = exec.getInputStream();
        byte[] bytes = new byte[1024];
            int read;
        while ((read = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read,"GBK"));
        }


    }
}
