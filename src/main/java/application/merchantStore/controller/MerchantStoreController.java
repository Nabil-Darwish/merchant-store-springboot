package application.merchantStore.controller;

import application.merchantStore.entity.MerchantStore;
import application.merchantStore.service.MerchantStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class MerchantStoreController {

    @Autowired
    private MerchantStoreService service;

    // Add a new store
    @PostMapping
    public MerchantStore addStore(@RequestBody MerchantStore store) {
        return service.addStore(store);
    }

    // Get all stores
    @GetMapping
    public List<MerchantStore> getAllStores() {
        return service.getAllStores();
    }

    // Get store by ID
    @GetMapping("/{id}")
    public MerchantStore getStoreById(@PathVariable Long id) {
        return service.getStoreById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id " + id));
    }

    // Get store by name
    @GetMapping("/name/{name}")
    public MerchantStore getStoreByName(@PathVariable String name) {
        return service.getStoreByName(name)
                .orElseThrow(() -> new RuntimeException("Store not found with name " + name));
    }

    // Update store
    @PutMapping("/{id}")
    public MerchantStore updateStore(@PathVariable Long id, @RequestBody MerchantStore store) {
        return service.updateStore(id, store);
    }
}
