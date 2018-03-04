package com.ag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ag.model.Shipwreck;
import com.ag.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();

	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck wreck) {
		return shipwreckRepository.saveAndFlush(wreck);

	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		Optional<Shipwreck> container = shipwreckRepository.findById(id);
		if (container.isPresent()) {
			return container.get();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck wreck) {
		Optional<Shipwreck> container = shipwreckRepository.findById(id);
		if(container.isPresent()) {
			Shipwreck existingWreck= container.get();
			BeanUtils.copyProperties(wreck, existingWreck);
			return shipwreckRepository.saveAndFlush(existingWreck);
		}
		return null;
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		Optional<Shipwreck> container = shipwreckRepository.findById(id);
		if(container.isPresent()) {
			Shipwreck existingWreck= container.get();
			shipwreckRepository.delete(existingWreck);
			return existingWreck;
		}
		return null;
	}

}
