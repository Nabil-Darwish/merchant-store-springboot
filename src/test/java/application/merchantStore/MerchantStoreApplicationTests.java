package application.merchantStore;

import application.merchantStore.entity.MerchantStore;
import application.merchantStore.repository.MerchantStoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MerchantStoreApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void whenSavingMerchantStore_thenMerchantStoreIsPersistedCorrectly() {

        long countBefore = merchantStoreRepository.count();
        assertEquals(0, countBefore, "No merchantStores should be present before the test");

        MerchantStore merchantStore = new MerchantStore();
        merchantStore.setName("Test Store");
        merchantStore.setAcronym("TS");
        merchantStore.setLatitude(45.542);
        merchantStore.setLongitude(-22.930);


        MerchantStore savedMerchantStore = merchantStoreRepository.save(merchantStore);

        assertNotNull(savedMerchantStore, "Saved merchant store should not be null");
        assertTrue(savedMerchantStore.getId() > 0, "ID should be greater than 0"); // Check if ID was generated
        assertEquals("Test Store", savedMerchantStore.geName(), "Name should be 'Test Store'");
        assertEquals("TS", savedMerchantStore.getAcronym(), "Acronym should be 'TS'");
        assertEquals(45.542, savedMerchantStore.getLatitude(), "Latitude should be 45.542");
        assertEquals(-22.930, savedMerchantStore.getLongitude(), "Acronym should be -22.930");
    }

}
