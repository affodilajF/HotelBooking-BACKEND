package HotelBooking.service;


import HotelBooking.entity.User;
import HotelBooking.exception.ApiException;
import HotelBooking.model.RegisterUserRequest;
import HotelBooking.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    public void register(RegisterUserRequest request){
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);
        if(constraintViolations.size() != 0){
//            error
            throw new ConstraintViolationException(constraintViolations);
        }

//        check didatabase dah ada belom user nya
        if(userRepository.existsById(request.getUsername())){
            throw new ApiException("Usn already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
//        user.setPassword();  
    }


}
