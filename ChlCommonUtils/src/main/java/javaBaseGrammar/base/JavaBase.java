package javaBaseGrammar.base;

import org.junit.Test;

public class JavaBase {

//    字符串拼接
//    在大量的字符串拼接操作时，可提升性能
    @Test
    public void stringTest(){

        StringBuilder sb = new StringBuilder("Hello");
        int a = 20;
        int b = 30;

        sb.append(a).append(" + ").append(b).append(" = ").append(a + b);
        sb.append(" World"); //adds to the end
        System.out.println(sb); //prints Hello World
    }

}
