package test;

import file.hidefiles;
import uitl.ExecUtil;

import java.io.IOException;

//******Author：zhiminzhang
//******Data:2023/1/5 20:13
public class cmdtest {
    public static void main(String[] args) throws IOException, InterruptedException {
       /* String ipconfig = ExecUtil.exec("ipconfig", 5);
        System.out.println(ipconfig);*/
        boolean hide = hidefiles.hide("D:\\IDEAPro\\filesystem\\filesystem");
        System.out.println(hide);
    }
}
