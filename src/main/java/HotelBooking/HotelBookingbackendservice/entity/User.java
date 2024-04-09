package HotelBooking.HotelBookingbackendservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "user_id", columnDefinition = "CHAR(255)")
    private String userId;

    private String username;

    private String password;

    private String name;

    private String token;

    @Column(name="token_expired_at")
    private Long tokenExpiredAt;

}
