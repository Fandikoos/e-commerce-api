package com.personal.localEcommerce.Service;

import com.personal.localEcommerce.Model.Store;
import com.personal.localEcommerce.Model.User;
import com.personal.localEcommerce.Repository.StoreRepository;
import com.personal.localEcommerce.Repository.UserRepository;
import com.personal.localEcommerce.Utils.RoleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    // Agregar una tienda a un usuarioe specífico
    public Store addStoreToOwner(long userId, Store store){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(user.getRoleUser() != RoleUser.STORE_OWNER){
            throw new RuntimeException("User is not store owner");
        }

        store.setOwner(user);

        return storeRepository.save(store);
    }

    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }
}
