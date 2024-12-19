package com.personal.localEcommerce.Controller;

import com.personal.localEcommerce.Model.Store;
import com.personal.localEcommerce.Service.StoreService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores(){
        List<Store> stores = storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @PostMapping("/addStore/{userId}")
    public ResponseEntity<Store> addStoreByOwner(@PathVariable long userId, @RequestBody Store store){
        Store newStore = storeService.addStoreToOwner(userId, store);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }
}
