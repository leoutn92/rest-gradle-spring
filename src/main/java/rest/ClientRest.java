package rest;

import Mock.MockClient;
import model.Client;
import model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * Created by developer on 28/09/16.
 */
@RestController
public class ClientRest {
    MockClient mock= MockClient.getInstance();

    @RequestMapping(value="/Client",method = RequestMethod.POST)
    public ResponseEntity<Message> save(@RequestBody Client client)  {
        Message message = new Message();
        try {
            mock.save(client);
        } catch (Exception e) {
            message.setMessage(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }
        message.setMessage("Client saved succesfully");
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @RequestMapping(value="/Client",method = RequestMethod.DELETE)
    public ResponseEntity<Message> delete(@RequestBody Client client) {
        Message message = new Message();
        message.setMessage("Client deleted succesfully");
        try {
            mock.delete(client);
        } catch (Exception e) {
            message.setMessage(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @RequestMapping(value="/Client",method = RequestMethod.PUT)
    public ResponseEntity<Message> update(@RequestBody Client client) {
        Message message = new Message();
        message.setMessage("Client updated succesfully");
        try {
            mock.update(client);
        } catch (Exception e) {
            message.setMessage(e.getMessage());
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/Clients",method = RequestMethod.GET )
    public ResponseEntity<List<Client>> getByName(@RequestParam(value="name",defaultValue="all") String name) {
        List<Client> clients = new ArrayList<Client>();
        if (name.equals("all")) {
          clients = mock.getClients();
        } else {
            clients = mock.getByName(name);
        }
        return new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
    }





}
