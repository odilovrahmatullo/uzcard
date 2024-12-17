package uzcard.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Table(name = "client")
@Entity
@Getter
@Setter
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private String surname;
  @Column(name = "middle_name")
  private String middleName;
  @Column(unique = true)
  private String phone;
  @Column(name = "password_series",unique = true)
  private String passportSeries;
  @Column(name = "password_number",unique = true)
  private String passportNumber;
  @Column(name = "client_status")
  private ClientStatus status;
  @Column(name = "created_date")
  private LocalDateTime createdDate;
}
