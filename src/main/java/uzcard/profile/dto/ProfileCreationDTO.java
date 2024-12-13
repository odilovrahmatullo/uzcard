package uzcard.profile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class ProfileCreationDTO {
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters")
    private String name;

    @NotBlank(message = "Surname must not be empty")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname can only contain letters")
    private String surname;

    @NotBlank(message = "Username must not be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = ".*[a-zA-Z].*", message = "Password must contain at least one letter")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character")
    private String password;

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

    public @NotBlank(message = "Username must not be empty") @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username must not be empty") @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters") String username) {
        this.username = username;
    }

    public @Size(min = 8, message = "Password must be at least 8 characters long") @Pattern(regexp = ".*[a-zA-Z].*", message = "Password must contain at least one letter") @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, message = "Password must be at least 8 characters long") @Pattern(regexp = ".*[a-zA-Z].*", message = "Password must contain at least one letter") @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character") String password) {
        this.password = password;
    }
}
