package uzcard.util.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDTO {
    private String username;
    private String role;

    public JwtDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
