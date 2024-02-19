package javaBaseGrammar.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTest {

    public static void  main(String [] args){

//        格式化日期对象
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(formatter.format(new Date()));

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter1.format(new Date()));
    }

}
