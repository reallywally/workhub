package com.wally.workhub.domain.user.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class UserControllerTest {
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Test
//    public void testRegisterUser_Success() {
//        User user = User.builder()
//                .username("testUser")
//                .email("test@email.com")
//                .password("testpassword")
//                .build();
//
//        when(userService.registerUser(any(User.class))).thenReturn(user);
//
//        ResponseEntity<?> response = userController.registerUser(user);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals("User registered successfully", response.getBody());
//    }
//
//    @Test
//    public void testRegisterUser_UsernameExists() {
//        User user = User.builder()
//                .username("testUser")
//                .email("test@email.com")
//                .password("testpassword")
//                .build();
//
//        when(userService.registerUser(any(User.class))).thenThrow(new RuntimeException("Username already exists"));
//
//        ResponseEntity<?> response = userController.registerUser(user);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Username already exists", response.getBody());
//    }
//
//    @Test
//    public void testRegisterUser_EmailExists() {
//        User user = User.builder()
//                .username("testUser")
//                .email("test@email.com")
//                .password("testpassword")
//                .build();
//
//        when(userService.registerUser(any(User.class))).thenThrow(new RuntimeException("Email already exists"));
//
//        ResponseEntity<?> response = userController.registerUser(user);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Email already exists", response.getBody());
//    }
}