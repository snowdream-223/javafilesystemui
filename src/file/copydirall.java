package file;

import java.io.*;


public class copydirall {
   /* public static void main(String[] args) {
        File rootdir = new File("D:\\IDEAPro\\JAVAIO\\lib");
        File targetdir = new File("D:\\Desktop");
        copy(rootdir, targetdir);
    }*/
    public static boolean copdir(String rootpath,String targetpath){
        File rootdir = new File(rootpath);
        File targetdir = new File(targetpath);
        copy(rootdir, targetdir, derootpal(rootdir,targetdir));

        return true;
    }
 static int  derootpal(File root,File target){
//        删除原路径的字符数
     int namelenght = root.getName().length();
     int rootal = root.getAbsolutePath().length();
     int aa=rootal-namelenght;
     return aa;
 }
 //a/c/v/b     final:a/c/v/b/y/k/l/o
    //d/g/j/l/u/y
//d:s/d/f/g/h 目标
//c:d/d/f/gh /k/l/o 原    final d:s/d/f/g/h/gh/k/l/o
    static void copy(File root, File target,int length ) {

        if (root.isFile()) {
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
              /*  String tardira = (target.getAbsolutePath().endsWith("\\") ? target.getAbsolutePath() : target.getAbsolutePath() + "\\") + root.getAbsolutePath().substring(18);*/
                String tardira = (target.getAbsolutePath().endsWith("\\") ? target.getAbsolutePath() : target.getAbsolutePath() + "\\") + root.getAbsolutePath().substring(length);
                in = new FileInputStream(root);
                out = new FileOutputStream(tardira);

                byte[] bytes = new byte[1024 * 1024];
                int ch;
                while ((ch = in.read(bytes)) != -1) {
                    out.write(bytes, 0, ch);
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return ;
        }
        if (root.isDirectory()) {
            String tardir = (target.getAbsolutePath().endsWith("\\") ? target.getAbsolutePath() : target.getAbsolutePath() + "\\") +root.getAbsolutePath().substring(length);
            File newdir = new File(tardir);
            if (!newdir.exists()) {
                // System.out.println(newdir.getAbsolutePath());
                if (newdir.mkdirs()) {
                    System.out.println("创建  " + newdir.getAbsolutePath() + "成功");
                } else {
                    System.out.println("创建  " + newdir.getAbsolutePath() + "失败");
                }
            }
        }
        File[] files = root.listFiles();
        if (files != null) {
            for (File filee : files) {
                copy(filee, target,length);
            }
        }

    }
}

