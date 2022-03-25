package unieuroop.controller.login;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Supplier;

import unieuroop.controller.serialization.Files;
import unieuroop.controller.serialization.Serialization;
import unieuroop.model.department.Department;
import unieuroop.model.person.Client;
import unieuroop.model.person.Staff;
import unieuroop.model.sale.Sale;
import unieuroop.model.shop.Shop;
import unieuroop.model.shop.ShopImpl;
import unieuroop.model.stock.Stock;

public final class ControllerLoginImpl {
    private Shop shop;
    public ControllerLoginImpl() {
        //this.shop.addStaff(new Staff("mario", "rossi", LocalDate.now(), 0, "prova@gmail.com", "1234".hashCode(), null));
    }
    
    public boolean checkPassword(final String email, final String password) {
        return this.shop.getStaffs().stream().anyMatch(s -> s.getEmail().equals(email) && s.getPassword().equals(password.hashCode()));
    }
    
    public void showMainMenu() {

    }
    
    public void loadData() throws JsonParseException, JsonMappingException, IOException {
        this.shop = new ShopImpl(
                Serialization.<String>deserialize(Files.SHOPNAME.getPath(), new TypeReference<String>() { }),
                Serialization.<Set<Department>>deserialize(Files.DEPARTMENTS.getPath(), new TypeReference<Set<Department>>() { }),
                Serialization.<Set<Staff>>deserialize(Files.STAFFS.getPath(), new TypeReference<Set<Staff>>() { }),
                Serialization.<Set<Supplier>>deserialize(Files.SUPPLIERS.getPath(), new TypeReference<Set<Supplier>>() { }),
                Serialization.<Set<Sale>>deserialize(Files.SALES.getPath(), new TypeReference<Set<Sale>>() { }),
                Serialization.<Set<Client>>deserialize(Files.CLIENTS.getPath(), new TypeReference<Set<Client>>() { }),
                Serialization.<Stock>deserialize(Files.STOCK.getPath(), new TypeReference<Stock>() { }),
                Serialization.<Map<LocalDate, Double>>deserialize(Files.BILLS.getPath(), new TypeReference<Map<LocalDate, Double>>() { })           
                );
                
        
    }
}
