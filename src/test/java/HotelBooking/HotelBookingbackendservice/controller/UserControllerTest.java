package HotelBooking.HotelBookingbackendservice.controller;

import static org.junit.jupiter.api.Assertions.*;


import HotelBooking.HotelBookingbackendservice.entity.User;
import HotelBooking.HotelBookingbackendservice.model.User.RegisterUserRequest;
import HotelBooking.HotelBookingbackendservice.model.WebResponse;
import HotelBooking.HotelBookingbackendservice.repository.UserRepository;
import HotelBooking.HotelBookingbackendservice.security.BCrypt;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@EnableWebMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void testSignUpSuccess() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("test_usn");
        request.setName("test_name");
        request.setPassword("test_passwd");

        mockMvc.perform(
                        post("/api/v1/user-registration")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON_VALUE) // Explicitly set content type
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
                    assertEquals("OK", response.getData());
                });
    }

    @Test
    void testSignUpDuplicate() throws Exception {

        User user = new User();
        user.setUsername("test_usn");
        user.setName("test_name");
        user.setPassword(BCrypt.hashpw("test_passwd", BCrypt.gensalt()));
        userRepository.save(user);

        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("test_usn");
        request.setName("test_name");
        request.setPassword("test_passwd");

        mockMvc.perform(
                        post("/api/v1/user-registration")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON_VALUE) // Explicitly set content type
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(
                        status().isBadRequest()
                )
                .andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
                    assertNotNull(response.getErrors());
                });
    }

    @Test
    void testSignUpInvalidData() throws Exception {

        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("");
        request.setName("");
        request.setPassword("test_passwd");

        mockMvc.perform(
                        post("/api/v1/user-registration")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON_VALUE) // Explicitly set content type
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(
                        status().isBadRequest()
                )
                .andDo(result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
                    assertNotNull(response.getErrors());
                });
    }

}