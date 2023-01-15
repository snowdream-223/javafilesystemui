package file;

import uitl.ExecUtil;

import java.io.IOException;

public class hidefiles {

    public static boolean hide(String filepath) throws IOException, InterruptedException {
        String dd="attrib +H "+filepath+"  /d";

        // /S 处理当前文件夹及其所有子文件夹中的匹配文件。
        //  /D 也处理文件夹。
        String exec = ExecUtil.exec(dd, 5);
        return exec.isEmpty();

    }
}
