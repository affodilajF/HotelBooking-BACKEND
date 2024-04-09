package HotelBooking.HotelBookingbackendservice.controller;

import HotelBooking.HotelBookingbackendservice.model.User.RegisterUserRequest;
import HotelBooking.HotelBookingbackendservice.model.WebResponse;
import HotelBooking.HotelBookingbackendservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService ;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/api/v1/user-registration",
                        consumes = MediaType.APPLICATION_JSON_VALUE,
                        produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        userService.register(registerUserRequest);

        return WebResponse.<String>builder().data("OK").build();
    }


}
