package HotelBooking.HotelBookingbackendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("HotelBooking.repository")
public class HotelBookingRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingRestfulApiApplication.class, args);
	}

}
