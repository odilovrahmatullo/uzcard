package uzcard.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Getter
@Service
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

}
