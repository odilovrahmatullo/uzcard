package uzcard.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyCreationDTO {
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters")
    @Size(min = 3, max = 18, message = "The length of name must be between 3 and 18 letters")
    @NotBlank(message = "Fill all fields")
    private String name;
    @NotBlank(message = "Username must not be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = ".*[a-zA-Z].*", message = "Password must contain at least one letter")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character")
    private String password;
    @NotBlank(message = "Fill all fields")
    private String address;
    @NotBlank(message = "Fill all fields")
    @Size(min = 4,max = 13, message = "Invalid contact number")
    private String contact;
    @NotBlank(message = "Fill all fields")
    private CompanyRole role;
    private String code;
}
