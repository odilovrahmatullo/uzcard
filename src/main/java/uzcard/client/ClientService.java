package uzcard.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public ClientCreationDTO create(ClientCreationDTO client) {
        ClientEntity entity = new ClientEntity();
        entity.setName(client.getName());
        entity.setSurname(client.getSurname());
        entity.setMiddleName(client.getMiddleName());
        entity.setPhone(client.getPhone());
        entity.setPassportSeries(client.getPassportSeries());
        entity.setPassportNumber(client.getPassportNumber());
        entity.setStatus(ClientStatus.ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        clientRepository.save(entity);
        return client;
    }


    public String updateInfos(String clientId, UpdateInfoDTO dto) {
        return "UPDATED "+clientRepository.updateInfo(clientId,dto.getName(),dto.getSurname(),dto.getMiddleName());
    }

    public String updateKeys(String clientId,UpdateKeysInfo  dto) {
        return "UPDATED "+clientRepository.updateKeys(clientId,dto.getPassportSeries(),dto.getPassportNumber(),dto.getPhone());

    }
}
