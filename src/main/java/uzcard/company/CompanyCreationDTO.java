package uzcard.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
    private String contact;
    @NotBlank(message = "Fill all fields")
    private CompanyRole role;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public CompanyRole getRole() {
        return role;
    }

    public void setRole(CompanyRole role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
