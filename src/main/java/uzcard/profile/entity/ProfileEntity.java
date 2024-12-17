package uzcard.profile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uzcard.profile.enums.ProfileRole;
import uzcard.profile.enums.ProfileStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "profile_status")
    private ProfileStatus status;
    @Enumerated(EnumType.STRING)
    @Column(name = "profile_role")
    private ProfileRole role;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
