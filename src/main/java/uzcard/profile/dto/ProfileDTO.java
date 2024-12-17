package uzcard.profile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import uzcard.profile.enums.ProfileRole;
import uzcard.profile.enums.ProfileStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;
    @Enumerated(EnumType.STRING)
    private ProfileRole role;
    private LocalDateTime createdDate;
    private LocalDate fromDate;
    private LocalDate toDate;
}
