package model;

import java.util.List;

public interface ClientDao {
    List<Client> read();

    List<Client> readBy(String name);

}
