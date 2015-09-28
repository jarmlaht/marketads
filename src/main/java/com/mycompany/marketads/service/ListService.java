package com.mycompany.marketads.service;

import com.mycompany.marketads.domain.ListItem;
import com.mycompany.marketads.domain.ListItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    
    @Autowired
    private ListItemRepository repo;
    
    public List<ListItem> listAll() {
        return repo.listAll();
    }
    
    public boolean addItem(ListItem item) {
        return repo.addItem(item);
    }
    
    public ListItem deleteItem(String id) {
        return repo.deleteItem(id);
    }
    
    public List<ListItem> findById(String id) {
        return repo.findById(id);
    }
}
