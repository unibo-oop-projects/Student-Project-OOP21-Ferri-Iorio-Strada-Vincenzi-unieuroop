package unieuroop.controller.client;

import java.time.LocalDate;
import java.util.Optional;

import unieuroop.model.person.Client;
import unieuroop.model.shop.Shop;

public class ControllerClientImpl {
    
    private final Shop shop;
    public ControllerClientImpl(final Shop shop) {
        this.shop = shop;
    }

    public void AddClient(String name, String surname, LocalDate birthday) {
        int code = 0;
        this.shop.registerClient(new Client(name, surname, birthday, code));
    }
    
    public void EditClient() {
        
    }
    
    public void DeleteClient() {
        
    }
}
