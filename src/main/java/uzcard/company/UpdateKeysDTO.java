package uzcard.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateKeysDTO {
    @NotBlank(message = "Username must not be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = ".*[a-zA-Z].*", message = "Password must contain at least one letter")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character")
    private String password;
}
