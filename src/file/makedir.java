package file;

import sun.plugin2.main.server.Plugin;

import java.io.File;

public class makedir {
    public makedir(String path ,String name){
        if (name!=null) {
            File file = new File(path);
            if (file.isFile()) {
                File parentFile = file.getParentFile();
                String absolutePath = parentFile.getAbsolutePath()+"\\"+name;
                System.out.println(absolutePath);
                File file1 = new File(absolutePath);
                file1.mkdirs();
            }else if (file.isDirectory()){
                String s = file.getAbsolutePath() + "\\" + name;
                File file2 = new File(s);
                file2.mkdirs();
            }
        }
    }
}
