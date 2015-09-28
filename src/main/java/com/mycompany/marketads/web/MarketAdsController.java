package com.mycompany.marketads.web;

import com.mycompany.marketads.domain.ListItem;
import com.mycompany.marketads.service.ListService;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MarketAdsController {
   
    @Autowired
    private ListService service;
    
    @RequestMapping("rest/list/add")
    public @ResponseBody String addItem(@RequestBody ListItem item) {
        Random random = new Random();
        Long tempId = random.nextLong();
        item.setId("" + tempId);
        if (service.addItem(item)) {
            return "success!";
        }
        return "failed!";
    }
    
    @RequestMapping("rest/marketads/delete/{id}")
    public @ResponseBody String deleteItem(@PathVariable("id") String id) {
        service.deleteItem(id);
        return "success!";
    }
    
    @RequestMapping("rest/marketads/listall")
    public @ResponseBody List<ListItem> listAll() {
        return service.listAll();
    }    

    @RequestMapping("rest/marketads/find/{id}")
    public @ResponseBody List<ListItem> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }   
}