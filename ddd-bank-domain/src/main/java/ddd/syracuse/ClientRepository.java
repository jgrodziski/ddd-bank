package ddd.syracuse;

import ddd.syracuse.exception.NotFoundException;

/**
 *
 */
public interface ClientRepository {

    public ClientSiretise find(SIRET siret) throws NotFoundException;

}
