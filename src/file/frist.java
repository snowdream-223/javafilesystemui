package file;

import io.loguitl;
/*
* hide show
*
*
*
*
* */
import java.io.File;
import java.io.IOException;

public class frist {
   public String rootdir="filesystem";
   public String logpath="filesystem/log.txt";
   public  String user="filesystem/user.txt";
    public  frist() throws IOException {
        File rootdri = new File(rootdir);
        File log=new File(logpath);
        File userlog = new File(user);
        if (rootdri.exists()){
//            存在但不目录
            if (!rootdri.isDirectory()){
//                不是目录
                boolean surootmk = rootdri.mkdir();
                loguitl.logger("源文件目录创建", surootmk);
                boolean sulogmk = log.createNewFile();
                loguitl.logger("log文件创建", sulogmk);
                boolean suuserlogmk = userlog.createNewFile();
                loguitl.logger("用户文件信息创建", suuserlogmk);
            }else {
//                是目录创建log
                boolean sulogmk = log.createNewFile();
                loguitl.logger("log文件创建", sulogmk);
                boolean suuserlogmk = userlog.createNewFile();
                loguitl.logger("用户文件信息创建", suuserlogmk);

            }
        }else {
            boolean surootmk = rootdri.mkdir();
            loguitl.logger("源文件目录创建", surootmk);
            boolean sulogmk = log.createNewFile();
            loguitl.logger("log文件创建", true);
            boolean suuserlogmk = userlog.createNewFile();
            loguitl.logger("用户文件信息创建", suuserlogmk);
        }


    }
}
