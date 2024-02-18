package HotelBooking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegisterUserRequest  {

    @NotBlank
    @Size(max=100)
    private String username;

    @NotBlank
    @Size(max=100)
    private String password;

    @NotBlank
    @Size(max=100)
    private String name;

}
