package com.mycompany.marketads.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.json.simple.JSONObject;

@Component
public class ListItemRepository {
    
    private final List<ListItem> listItems = new ArrayList<>();
    private final JSONObject obj = new JSONObject();
    
    public List<ListItem> listAll() {
        return listItems;
    }
    
    public boolean addItem(ListItem item) {
        if (!listItems.contains(item)) {
            listItems.add(item);
            return true;
        }
        return false;
    }
    
    public ListItem deleteItem(String id) {
        System.out.println("deleteItem: " + id);
        for (ListItem item: listItems) {
            if (item.getId().contentEquals(id)) {
                return item;
            }
        }
        return null;
    }
    
    public List<ListItem> findById(String id) {
        System.out.println("findById(): " + id);
        List<ListItem> templist = new ArrayList<>();
        for (ListItem item: listItems) {
            if (item.getTitle().contentEquals(id)) {
                templist.add(item);
            }
        }
        System.out.println("findById(): " + templist.size());
        return templist;
    }    
}