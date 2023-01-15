package file;

import uitl.ExecUtil;

import java.io.IOException;

public class showfiles {
    public static boolean show(String filepath) throws IOException, InterruptedException {
        String dd="attrib -H "+filepath+"  /d";
        String exec = ExecUtil.exec(dd, 5);
        return exec.isEmpty();
    }
}
