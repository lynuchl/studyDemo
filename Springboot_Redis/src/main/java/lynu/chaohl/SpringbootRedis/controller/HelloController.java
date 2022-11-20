//package lynu.chaohl.controller;
//
////import FirstTests.Hello;
////import FirstTests.Hello;
////import FirstTests.Hello;
////import FirstTests.Hello;
////import FirstTests.Hello;
////import lynu.ChlUtils
////import FirstTests.Hello;
////import FirstTests.Hello;
//import Tests.HelloTests;
//import lynu.chaohl.dao.BookComponent;
//import BookProperties;
////import lynu.chaohl.dao.UserTest;
////import lynu.chaohl.service.UserController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.awt.print.Book;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//
// */
//@RestController
//@RequestMapping("/Hello")
//public class HelloController {
//
////    @Autowired
////   public BookProperties bookProperties;
////
//////    @Autowired
//////    UserController userService;          // 用户服务层
////    /**
////     * 本地包导入测试
////     * @return
////     */
////    @RequestMapping("/hello")
////    public String Hello(){
////
////
////        System.out.println("hello wrold");
////        HelloTests helloTest=new HelloTests();
////       int c= helloTest.add(3,4);
////       System.out.println(c);
////        return "hello world";
////    }
////
////    /**
////     * GET请求
////     */
////    @RequestMapping(method = RequestMethod.GET)
////    public String getBookList() {
////        return "hello get request";
////    }
////
////    /**
////     * 带参数的GET请求
////     */
////    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
////    public String getBook(@PathVariable Long id) {
////        return "hello get request and param";
////    }
////
////    /**
////     *
////     */
////    @RequestMapping(value = "/create", method = RequestMethod.POST)
////    public ResponseEntity postBook(@RequestBody BookComponent book) {
////
//////        List<BookProperties> bookProperties= new ArrayList<>();
////        BookProperties bookProperties1=new BookProperties();
////        return  ResponseEntity.getResponse(200,"测试成功",bookProperties);
////    }
////
////    /**
////     */
////    @RequestMapping(value = "/update", method = RequestMethod.PUT)
////    public String putBook(@RequestBody BookComponent book) {
////        return "";
////    }
////
////    /**
////     */
////    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
////    public String deleteBook(@PathVariable Long id) {
////        return "";
////    }
//
//
//
//    /**
//     *  获取用户分页列表
//     *    处理 "/users" 的 GET 请求，用来获取用户分页列表
//     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
//     *
//     *    Pageable 支持的分页参数如下
//     *    page - 当前页 从 0 开始
//     *    size - 每页大小 默认值在 application.properties 配置
//     */
////    @RequestMapping(value = "paging_sorting",method = RequestMethod.GET)
////    public Page<UserTest> getUserPage(Pageable pageable) {
////        return userService.findByPage(pageable);
////    }
////
////    /**
////     *  创建用户
////     *    处理 "/users" 的 POST 请求，用来获取用户列表
////     *    通过 @RequestBody 绑定实体类参数
////     */
////    @RequestMapping(value = "/create_paging_sorting", method = RequestMethod.POST)
////    public UserTest postUser(@RequestBody UserTest user) {
////        return userService.insertByUser(user);
////    }
//}
