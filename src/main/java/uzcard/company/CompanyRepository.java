package uzcard.company;


import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CompanyRepository extends CrudRepository<CompanyEntity,String>,
                                           PagingAndSortingRepository<CompanyEntity,String> {


     CompanyEntity getByUsernameAndVisibleTrue(String username);

     @Modifying
     @Transactional
     @Query("Update CompanyEntity Set code = ?2,contact = ?3,name = ?4,address = ?5,role = ?6 where id = ?1")
     Integer updateInfos(String id, String code,String contact,String name, String address, CompanyRole role);

     @Modifying
     @Transactional
     @Query("UPDATE CompanyEntity SET password = ?2,username = ?3 where id = ?1")
     Integer updateKeys(String id,String password,String username);

     @Query("FROM CompanyEntity where visible = true")
     Page<CompanyEntity> getByPagination(Pageable pageable);
}
