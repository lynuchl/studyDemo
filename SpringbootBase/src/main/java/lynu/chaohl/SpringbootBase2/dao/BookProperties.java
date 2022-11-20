//package lynu.chaohl.SpringbootBase2.dao;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//
///**
// * 书属性
// *
// */
//@Component
//public class BookProperties implements Serializable {
//
//    /**
//     * 书名
//     */
//    @Value("${demo.book.name}")
//    private String name;
//
//    /**
//     * 作者
//     */
//    @Value("${demo.book.writer}")
//    private String writer;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getWriter() {
//        return writer;
//    }
//
//    public void setWriter(String writer) {
//        this.writer = writer;
//    }
//
//    @Override
//    public String toString() {
//        return "BookProperties{" +
//                "name='" + name + '\'' +
//                ", writer='" + writer + '\'' +
//                '}';
//    }
//}
