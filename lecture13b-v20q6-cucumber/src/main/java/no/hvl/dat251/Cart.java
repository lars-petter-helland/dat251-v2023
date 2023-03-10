package no.hvl.dat251;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    List<Item> items = new ArrayList<>();
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public long numberOf(String itemName) {
        return items.stream().filter(item -> item.name().equals(itemName)).count();
                
    }
    
    public int totalFor(String itemName) {
        return items.stream()
                .filter(item -> item.name().equals(itemName))
                .mapToInt(item -> item.price()).sum();
    }
    
    public int total() {
        return items.stream()
                .mapToInt(item -> item.price()).sum();
    }
}
