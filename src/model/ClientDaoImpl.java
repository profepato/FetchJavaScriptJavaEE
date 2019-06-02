package model;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao{
    @Override
    public List<Client> read() {
        List<Client> clients = new ArrayList<>();

        Client c1, c2, c3, c4;

        c1 = new Client();
        c2 = new Client();
        c3 = new Client();
        c4 = new Client();

        c1.setName("Jaime Soto");
        c1.setAge(35);

        c2.setName("Krakenpolo1");
        c2.setAge(10);

        c3.setName("Mike");
        c3.setAge(30);

        c4.setName("Thom twd");
        c4.setAge(450);

        clients.add(c1);
        clients.add(c2);
        clients.add(c3);
        clients.add(c4);

        return clients;
    }

    @Override
    public List<Client> readBy(String name) {
        List<Client> clients = new ArrayList<>();

        for(Client c : read()){
            if(c.getName().toLowerCase().contains(name.toLowerCase())){
                clients.add(c);
            }
        }

        return clients;
    }
}
