package org.naeemiqbal.db.store;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

	@Autowired
	StoreRepository repo;

	@GetMapping(value= "/all")
	String get() {
		return "Assalamu Alaikum";
	}

	@GetMapping(value="/stores")
	List<Store> getAll() {
		return (List<Store>) repo.findAll();
	}

	@GetMapping(value="/stores/{id}")
	Store getOne(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}

	@PostMapping("/stores")
	@ResponseStatus(HttpStatus.CREATED)
	Store addStore(@RequestBody Store pStore) {
		return repo.save(pStore);
	}

	@PutMapping("/stores/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	Store updateStore(@RequestBody Store pStore, @PathVariable Long id) {
		return repo.findById(id).map(itm -> {
			itm.setStoreCode(pStore.getStoreCode());
			itm.setStoreName(pStore.getStoreName());
			return repo.save(itm);
		}).orElseGet(() -> {
			pStore.setStoreID(id);
			return repo.save(pStore);
		});
	}

	@DeleteMapping("/stores/{id}")
	void deleteStore(@PathVariable Long id) {
		repo.deleteById(id);		
	}
	
	@PatchMapping("/stores/{id}")
//	ResponseEntity<Store> patchStpre(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
	Store patchStore(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
		
		if (id <= 0 || fields == null || fields.isEmpty() //|| !fields.get("storeId").equals(id)
				){
	     //   return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Invalid claim object received or invalid id or id does not match object
			throw new RuntimeException("No data to process");
	    }
	    final Store store = repo.findById(id).get();
	    if( store == null){
	        //return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Claim object does not exist
			throw new RuntimeException("Not found");
	    }
	    fields.remove("storeId");
	    
	    
	    fields.forEach((k, v) -> {
	        Field field = ReflectionUtils.findRequiredField(Store.class, k);
	        field.setAccessible(true); 
	        ReflectionUtils.setField(field, store, v); // set given field for defined object to value V
	    });
	    Store s2 = repo.save(store);
//	    return new ResponseEntity<>(s2, HttpStatus.OK);
	    return s2;
	}
}
