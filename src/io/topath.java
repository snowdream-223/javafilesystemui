package io;

//******Author：zhiminzhang
//******Data:2022/12/18 15:01
public class topath {
    static String ss;
 //  static String s ;


    public static String to(String path) {
        int be = path.indexOf("{");
       // System.out.println(be);
        if (be != -1) {
            int end = path.indexOf("}");
            path = path.substring(0, be) + path.substring(end + 1);
            to(path);
        }
        if (be==-1){
            ss = path;
        }
return ss;
    }
}
