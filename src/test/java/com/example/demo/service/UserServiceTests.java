package com.example.demo.service;//package com.example.demo.service;
//
//import com.example.demo.entity.User;
//import com.example.demo.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    UserService userService;
//
////    @Disabled
////    @Test
//
//    @ParameterizedTest
//    @CsvSource({
//            "ram",
//            "Test",
//            "Prakash",
//            "Admin"
//    })
//    public void testFindByUserName(String username){
//        User user = userRepository.findByUsername(username);
//        Assertions.assertFalse(user.getUsername().isEmpty());
//    }
//
////    @ParameterizedTest
////    @CsvSource({
////            "1,1,2",
////            "2,2,4",
////            "2,3,2"
////    })
////    public void test(int a, int b, int expected){
////        Assertions.assertEquals(expected, a+b);
////    }
//
////    @ParameterizedTest
////    @ValueSource(strings = {
////            "1,1,2",
////            "2,2,4",
////            "2,3,2"
////    })
////    public void test(int a, int b, int expected){
////        Assertions.assertEquals(expected, a+b);
////    }
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testSaveNewUser(User user){
//        Assertions.assertTrue(userService.saveNewUser(user));
//    }
//}
