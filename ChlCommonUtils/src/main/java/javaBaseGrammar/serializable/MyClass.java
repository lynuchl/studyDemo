package javaBaseGrammar.serializable;

import java.io.*;

//继承接口标识可序列化类
public class MyClass implements Serializable {

//    序列化标识
    private static final long serialVersionUID = 1L;

    int i = 100;
    int j = 200;
}
