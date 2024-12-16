package uzcard.client;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientCreationDTO> create(@Valid @RequestBody ClientCreationDTO client){
        return ResponseEntity.ok(clientService.create(client));
    }

    @PutMapping("/info")
    public ResponseEntity<String> updateInfos(@Valid @RequestBody UpdateInfoDTO dto,
                                                    @RequestParam String clientId){
        return ResponseEntity.ok(clientService.updateInfos(clientId,dto));
    }


    @PutMapping("/keys")
    public ResponseEntity<String> updateKeys(@Valid @RequestBody UpdateKeysInfo dto,
                                             @RequestParam String clientId){
        return ResponseEntity.ok(clientService.updateKeys(clientId,dto));
    }






}

