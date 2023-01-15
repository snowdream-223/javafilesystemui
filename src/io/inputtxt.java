package io;

import java.io.*;

//******Author：zhiminzhang
//******Data:2023/1/8 17:13
public class inputtxt {
  public static  String input(String path){
     String cont ="";
      try {
          FileReader fr = new FileReader(path);
          BufferedReader bfr = new BufferedReader(fr);
String dd;

          while ((dd=bfr.readLine())!=null){

              cont=cont+dd+"\n";
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

      return cont;
  }
}
