package com.personal.localEcommerce.Service;

import com.personal.localEcommerce.Model.Product;
import com.personal.localEcommerce.Model.Store;
import com.personal.localEcommerce.Repository.ProductRepository;
import com.personal.localEcommerce.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProductByStore(long storeId, Product product){
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));

        product.setStore(store);

        return productRepository.save(product);

    }
}
