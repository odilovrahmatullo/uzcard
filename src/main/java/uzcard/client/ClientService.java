package uzcard.client;

import jakarta.validation.Valid;
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


}
