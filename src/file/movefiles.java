package file;

import java.io.File;

public class movefiles {
    public static boolean move(String rootpath,String targetpath) {
        File file = new File(rootpath);
        boolean b = false;
        File tafile = new File(targetpath);
        if (tafile.isDirectory()) {
            String name = file.getName();
            String mubiaomulu = (targetpath.endsWith("\\") ? targetpath : targetpath + "\\") + name;
            System.out.println("移动最终路径"+mubiaomulu);
            b = file.renameTo(new File(mubiaomulu));

        }
        //s/d/f/g   s/d/f/a    s/g   g.txt   s/d/f/g.txt
        return b;
    }
}
