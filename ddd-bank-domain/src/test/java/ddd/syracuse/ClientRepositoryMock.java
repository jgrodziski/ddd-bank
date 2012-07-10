package ddd.syracuse;

import ddd.syracuse.exception.NotFoundException;
import static org.mockito.Mockito.*;


/**
 *
 */
public class ClientRepositoryMock {

    public ClientRepository getInstance(){
        ClientRepository clientRepo = mock(ClientRepository.class);
        //when(clientRepo.find(new SIRET(new SIREN("552032534"), new NIC("00646")))).thenReturn(new ClientSiretise());
        return null;
    }
}
