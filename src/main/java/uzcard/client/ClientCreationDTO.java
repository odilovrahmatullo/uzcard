package uzcard.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientCreationDTO {

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

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getPassportSeries() {
      return passportSeries;
   }

   public void setPassportSeries(String passportSeries) {
      this.passportSeries = passportSeries;
   }

   public String getPassportNumber() {
      return passportNumber;
   }

   public void setPassportNumber(String passportNumber) {
      this.passportNumber = passportNumber;
   }
}
