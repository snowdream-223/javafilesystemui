package io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//******Author：zhiminzhang
//******Data:2022/12/18 16:57
public class stringtolong {

   public static long to(String data) throws ParseException {
       SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      long s=sim.parse(data).getTime();
      return s;
   }
}
