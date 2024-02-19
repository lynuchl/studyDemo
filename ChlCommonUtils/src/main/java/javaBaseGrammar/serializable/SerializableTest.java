package javaBaseGrammar.serializable;

import org.junit.Test;

import java.io.*;
//import
public class SerializableTest {

//    public static void main(String[] args) {
//
//        // 实现Serializable接口进行序列化测试
//        MyClass object = new MyClass();
//        try {
//            FileOutputStream file = new FileOutputStream("E:\\StudyDemo\\Java_Demo\\ChlCommonUtils\\src\\main\\java\\javaBaseGrammar\\serializable\\myfile");
//            ObjectOutputStream out = new ObjectOutputStream(file);
//            out.writeObject(object);
//            out.close();
//            file.close();
//        }
//        catch (IOException ex) {
//            System.out.println("IOException is caught");
//        }
//
//        // 实现Serializable接口进行反序列化测试
//        try {
//            FileInputStream file = new FileInputStream("E:\\StudyDemo\\Java_Demo\\ChlCommonUtils\\src\\main\\java\\javaBaseGrammar\\serializable\\myfile");
//            ObjectInputStream out = new ObjectInputStream(file);
//
//            object= (MyClass)out.readObject();
//            System.out.println("read object:"+object.i);
//
//            out.close();
//            file.close();
//        }
//        catch (Exception ex) {
//            System.out.println("IOException is caught");
//        }
//    }

//    测试类的方法名不能使用test
    @Test
    public void test11(){

        System.out.println("hello wrold");
    }

}
