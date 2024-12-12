package uzcard.profile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProfileCustomRepository {
    @Autowired
    private EntityManager entityManager;

    public FilterResultDTO<ProfileDTO> filter(ProfileDTO filter, Integer page, Integer size){
        StringBuilder condition = new StringBuilder();
        Map<String,Object> params = new HashMap<>();

        if(filter.getName()!=null){
            condition.append("and p.name ilike : name ");
            params.put("name","%" + filter.getName()+"%");
        }
        if(filter.getSurname()!=null){
            condition.append("and p.surname ilike : surname ");
            params.put("surname","%"+filter.getSurname()+"%");
        }
        if(filter.getRole()!=null){
            condition.append("and p.role ilike : role ");
            params.put("role","%"+filter.getRole()+"%");
        }
        if(filter.getUsername()!=null){
            condition.append("and p.username like : username ");
            params.put("username","%"+filter.getUsername()+"%");
        }
        if(filter.getStatus()!=null){
            condition.append("and p.status ilike : status ");
            params.put("status","%"+filter.getStatus()+"%");
        }
        if(filter.getFromDate()!=null){
            LocalDateTime fromDate = LocalDateTime.of(filter.getFromDate(), LocalTime.MIN);
            condition.append("and p.createdDate>=:from ");
            params.put("from",fromDate);
        }
        if(filter.getToDate()!=null) {
            condition.append("and p.createdDate<=:to ");
            LocalDateTime toDateTime = LocalDateTime.of(filter.getToDate(), LocalTime.MAX);
            params.put("to", toDateTime);
        }

        StringBuilder selectBuilder = new StringBuilder("From ProfileEntity as p where 1=1 ");
        selectBuilder.append(condition);
        StringBuilder countBuilder = new StringBuilder("Select count(*) from ProfileEntity as p where 1=1 ");
        countBuilder.append(condition);
        Query selectQuery = entityManager.createQuery(selectBuilder.toString(),ProfileEntity.class);
        selectQuery.setFirstResult(page*size);
        selectQuery.setMaxResults(size);
        Query countQuery = entityManager.createQuery(countBuilder.toString());
        for(Map.Entry<String,Object> entry : params.entrySet()) {
            countQuery.setParameter(entry.getKey(),entry.getValue());
            selectQuery.setParameter(entry.getKey(),entry.getValue());
        }

        List<ProfileEntity> list =selectQuery.getResultList();
        long total = (long) countQuery.getSingleResult();
        List<ProfileDTO> dtoList = list.stream().map(item -> mapperToDTO(item)).toList();
        return new FilterResultDTO<>(dtoList,total);
    }

    private ProfileDTO mapperToDTO(ProfileEntity entity){
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setName(entity.getName());
        profileDTO.setSurname(entity.getSurname());
        profileDTO.setCreatedDate(entity.getCreatedDate());
        profileDTO.setRole(entity.getRole());
        profileDTO.setStatus(entity.getStatus());
        profileDTO.setUsername(entity.getUsername());
        return profileDTO;
    }
}
