package uzcard.profile.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uzcard.profile.entity.ProfileEntity;
import uzcard.profile.enums.ProfileStatus;

public interface ProfileRepository extends CrudRepository<ProfileEntity,String> {
    @Query("from ProfileEntity where username = ?1 and status = 'ACTIVE' ")
    ProfileEntity findByUsername(String username);

    @Modifying
    @Transactional
    @Query("Update ProfileEntity Set name = ?2,surname = ?3 where id = ?1")
    Integer updateInfo(String profileId,String name,String surname);

    @Modifying
    @Transactional
    @Query("Update ProfileEntity Set username = ?2,password = ?3 where id = ?1")
    Integer updateKeys(String profileId,String username,String password);

    @Modifying
    @Transactional
    @Query("Update ProfileEntity Set status = ?2 where id = ?1 ")
    Integer changeStatus(String id, ProfileStatus status);
}
