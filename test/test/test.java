package test;

import file.*;

import io.loguitl;
import io.sousuo;
import io.stringtolong;
import ui.mainui;
import uitl.ExecUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        new mainui().init();
//hidefiles.hide("sdfsd");
       /* long to = stringtolong.to("2001-02-01 22:12:23");
        System.out.println(to);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(to);
        System.out.println(format);*/
    }
}
