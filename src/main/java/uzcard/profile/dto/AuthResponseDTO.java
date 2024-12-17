package uzcard.profile.dto;

import lombok.Getter;
import lombok.Setter;
import uzcard.profile.enums.ProfileRole;
@Getter
@Setter
public class AuthResponseDTO {
    private String name;
    private String surname;
    private String username;
    private ProfileRole role;
    private String jwt;
}
