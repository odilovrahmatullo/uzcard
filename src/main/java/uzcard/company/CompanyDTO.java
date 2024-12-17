package uzcard.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {
    private String id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String contact;
    private CompanyRole role;
    private String code;
}
