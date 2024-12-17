package uzcard.company;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInfoDTO {
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters")
    @Size(min = 3, max = 18, message = "The length of name must be between 3 and 18 letters")
    @NotBlank(message = "Fill all fields")
    private String name;
    private String address;
    @NotBlank(message = "Fill all fields")
    @Size(min = 4,max = 13, message = "Invalid contact number")
    private String contact;
    @NotBlank(message = "Fill all fields")
    @Enumerated(EnumType.STRING)
    private CompanyRole role;
    private String code;
}
