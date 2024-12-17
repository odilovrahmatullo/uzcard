package uzcard.company;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "company")
@Getter
@Setter
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String address;
    private String contact;
    @Column(name = "company_role")
    @Enumerated(EnumType.STRING)
    private CompanyRole role;
    private String code;
    private Boolean visible;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
