package org.naeemiqbal.db.store;

import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> {
	Store findByStoreCode(String storeCode);
	Store findByStoreName(String storeCode);

}
