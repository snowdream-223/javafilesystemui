package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class loguitl {
    public static void logger(String msg,boolean ch) throws FileNotFoundException {
//        静态方法不用new对象可以直接使用
        System.setOut(new PrintStream(new FileOutputStream("filesystem/log.txt",true)));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        //日期格式化
        String format = simpleDateFormat.format(date);
        if (ch){
            System.out.println(format+"："+msg+"  成功");
        }else {
            System.out.println(format+"："+msg+"  失败");
        }

    }
    public static void logger(String msg) throws FileNotFoundException {
//        静态方法不用new对象可以直接使用
        System.setOut(new PrintStream(new FileOutputStream("filesystem/log.txt",true)));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        //日期格式化
        String format = simpleDateFormat.format(date);

            System.out.println(format+"："+msg);


    }
}
