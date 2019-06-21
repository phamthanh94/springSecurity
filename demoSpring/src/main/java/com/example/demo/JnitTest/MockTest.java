//package com.example.demo.JnitTest;
//
//import com.example.demo.dao.UserRepository;
//import com.example.demo.service.UserServiceImpl;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class MockTest {
//
//
//    @Mock UserRepository userRepository;
//
//    @InjectMocks UserServiceImpl userService;
//
//
//    @Test
//    public void testGetAllUser(){
//        Mockito.when(userRepository.createUser("thanhpv","12","ds","A")).thenReturn(1);
//        int result = userService.createUser("thanhpv","12","ds","A");
//        Assert.assertEquals(result,1);
//    }
//
//}
