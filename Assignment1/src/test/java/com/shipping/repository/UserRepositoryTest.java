//package com.shipping.repository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//public class UserRepositoryTest {
//
//    @Autowired
//    public UserRepository userRepository;
//    @Test
//    public void testFindByUsernameAndPassword() {
//        // 创建一个测试用户
//        User user = new User();
//        user.setUsername("testuser");
//        user.setPassword("password");
//        userRepository.save(user);
//
//        // 调用方法进行查找
//        User foundUser = userRepository.findByUsernameAndPassword("testuser", "password");
//
//        // 断言查找结果不为空
//        assertNotNull(foundUser);
//
//        // 断言查找结果与创建的用户对象相等
//        assertEquals(user.getUsername(), foundUser.getUsername());
//        assertEquals(user.getPassword(), foundUser.getPassword());
//    }
//}