package HotelBooking.HotelBookingbackendservice.repository;

import HotelBooking.HotelBookingbackendservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String > {

    boolean existsByUsername(String username);

}
