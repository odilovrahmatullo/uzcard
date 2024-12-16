package uzcard.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateInfoDTO {
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters")
    @Size(min = 3, max = 18, message = "The length of name must be between 3 and 18 letters")
    @NotBlank(message = "Fill all fields")
    private String name;

    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Surname must contain only letters and spaces")
    @Size(min = 3, max = 18, message = "The length of surname must be between 3 and 18 letters")
    @NotBlank(message = "Fill all fields")
    private String surname;

    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Middle name must contain only letters")
    @Size(min = 3, max = 18, message = "The length of middle name must be between 3 and 18 letters")
    @NotBlank(message = "Fill all fields")
    private String middleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}