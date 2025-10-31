package application.merchantStore.service;

import application.merchantStore.entity.MerchantStore;
import application.merchantStore.repository.MerchantStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantStoreService {

    @Autowired
    private MerchantStoreRepository repository;

    public MerchantStore addStore(MerchantStore store) {
        return repository.save(store);
    }

    public List<MerchantStore> getAllStores() {
        return repository.findAll();
    }

    public Optional<MerchantStore> getStoreById(Long id) {
        return repository.findById(id);
    }

    public Optional<MerchantStore> getStoreByName(String name) {
        return repository.findByName(name);
    }

    public MerchantStore updateStore(Long id, MerchantStore updatedStore) {
        return repository.findById(id)
                .map(store -> {
                    store.setName(updatedStore.getName());
                    store.setAcronym(updatedStore.getAcronym());
                    store.setLatitude(updatedStore.getLatitude());
                    store.setLongitude(updatedStore.getLongitude());
                    return repository.save(store);
                })
                .orElseThrow(() -> new RuntimeException("Store not found with id " + id));
    }
}
