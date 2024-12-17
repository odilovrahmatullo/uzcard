package uzcard.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateKeysInfo {

    @Pattern(regexp = "^\\+998\\d{9}$", message = "Phone number must start with +998")
    @Size(min = 13, max = 13, message = "Phone number must be exactly 13 characters")
    @NotBlank(message = "Fill all fields")
    private String phone;

    @Size(min = 14, max = 14, message = "Passport Series must contains 14 numbers")
    @NotBlank(message = "Fill all fields")
    private String passportSeries;

    @Pattern(regexp = "^[A-Z]{2}\\d{7}$", message = "Invalid passport number")
    @Size(min = 9, max = 9, message = "Invalid passport number")
    @NotBlank(message = "Fill all fields")
    private String passportNumber;
}

