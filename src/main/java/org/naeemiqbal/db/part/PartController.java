package org.naeemiqbal.db.part;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
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
public class PartController {

	@Autowired
	PartRepository repo;

	@GetMapping(value="/parts")
	List<Part> getAll() {
		return (List<Part>) repo.findAll();
	}

	@GetMapping(value="/parts/{id}")
	Part getOne(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}

	@PostMapping("/parts")
	@ResponseStatus(HttpStatus.CREATED)
	Part addpart(@RequestBody Part ppart) {
		return repo.save(ppart);
	}

	@PutMapping("/parts/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	Part updatepart(@RequestBody Part ppart, @PathVariable Long id) {
		return repo.findById(id).map(itm -> {
			itm.setPartCode(ppart.getPartCode());
			itm.setPartName(ppart.getPartName());
			return repo.save(itm);
		}).orElseGet(() -> {
			ppart.setPartId(id);
			return repo.save(ppart);
		});
	}

	@DeleteMapping("/parts/{id}")
	void deletepart(@PathVariable Long id) {
		repo.deleteById(id);		
	}
	
	@PatchMapping("/parts/{id}")
	Part patchpart(@PathVariable Long id, @RequestBody Map<String, Object> fields) {		
		if (id <= 0 || fields == null || fields.isEmpty() || ( !fields.get("partId").equals(null) && !fields.get("partId").equals(id))){
			throw new RuntimeException("No data to process");
	    }
	    final Part part = repo.findById(id).get();
	    if( part == null){
	        //return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Claim object does not exist
			throw new RuntimeException("Not found");
	    }
	    fields.remove("partId");
	    fields.forEach((k, v) -> {
	        Field field = ReflectionUtils.findRequiredField(Part.class, k);
	        field.setAccessible(true); 
	        ReflectionUtils.setField(field, part, v); // set given field for defined object to value V
	    });
	    return repo.save(part);
	}
}
