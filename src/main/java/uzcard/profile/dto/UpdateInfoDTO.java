package uzcard.profile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateInfoDTO {
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters")
    private String name;

    @NotBlank(message = "Surname must not be empty")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname can only contain letters")
    private String surname;

    public @NotBlank(message = "Name must not be empty") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name must not be empty") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Surname must not be empty") @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters") @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname can only contain letters") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Surname must not be empty") @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters") @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname can only contain letters") String surname) {
        this.surname = surname;
    }

}
