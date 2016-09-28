package Mock;

import model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 28/09/16.
 */
public class MockClient {
    private List<Client> clients = new ArrayList<Client>();
    static MockClient instance;
    public static MockClient getInstance() {
        if (instance==null) {
            instance = new MockClient();
        }
        return instance;
    }
    protected MockClient() {

    }
    public void save(Client client) throws Exception {
        for (Client c: this.clients) {
          if (c.equals(client)) {
              throw new Exception("name and email already exist");
          }
        }
        getClients().add(client);
    }

    public List<Client> getByName(String name) {
        List<Client> clients = new ArrayList<Client>();
        for (Client c : this.clients) {
            if (c.getName().equals(name)) {
                clients.add(c);
            }
        }
        return clients;
    }

    public void update(Client client) throws Exception {
        for (Client c: this.clients) {
            if (c.equals(client)) {
                c.setName(client.getName());
                c.setAdress(client.getAdress());
                c.setEmail(client.getEmail());
                c.setCountry(client.getCountry());
                return;
            }
        }
        throw new Exception("Client not found");
    }

    public void delete(Client client) throws Exception {
        for (Client c: this.clients) {
            if (c.equals(client)) {
                this.clients.remove(client);
                return;
            }
        }
        throw new Exception("Client not found");
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
