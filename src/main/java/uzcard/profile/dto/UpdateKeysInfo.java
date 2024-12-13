package uzcard.profile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateKeysInfo {
    @NotBlank(message = "Username must not be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = ".*[a-zA-Z].*", message = "Password must contain at least one letter")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character")
    private String password;


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
