package uzcard.client;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity,String> {

    @Modifying
    @Transactional
    @Query("UPDATE ClientEntity SET name = ?1, surname = ?2, middleName = ?3 where id = ?1")
    Integer updateInfo(String clientId, String name, String surname, String middleName);

    @Modifying
    @Transactional
    @Query("Update ClientEntity  set passportNumber = ?3,phone = ?4,passportSeries = ?2 where id = ?1")
    Integer updateKeys(String clientId, String passportSeries, String passportNumber, String phone);
}
