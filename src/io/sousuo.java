package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//******Author：zhiminzhang
//******Data:2022/12/17 12:40
public class sousuo {
    List<String>filesspath=new ArrayList<String>();

    String name;

    public sousuo(String name) {
        File first = new File("filesystem");
        this.name = name;
        digui(first);
    }

    public void digui(File filea) {
        File[] listf = filea.listFiles();
        if (listf!=null) {
            for (File everf : listf) {
                if (everf.getName().contains(name)) {
                    filesspath.add(everf.getPath());
                }
                if (everf.isDirectory()) {
                    digui(everf);
                }

            }
        }
    }

    public List<String> getFilesspath() {
        return filesspath;
    }
}
