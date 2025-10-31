package application.merchantStore.repository;

import application.merchantStore.entity.MerchantStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantStoreRepository extends JpaRepository<MerchantStore, Long> {
    Optional<MerchantStore> findByName(String name);
}