package com.ag.ShipWreckApp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ag.controller.ShipwreckController;
import com.ag.model.Shipwreck;
import com.ag.repository.ShipwreckRepository;


public class ShipWreckAppApplicationTests {

	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testShipWreckGet() {
		Shipwreck wreck = new Shipwreck();
		wreck.setId(1L);
		when(shipwreckRepository.findById(1L)).thenReturn(Optional.of(wreck));
		Shipwreck testWreck = sc.get(1L);

		assertEquals(1L, testWreck.getId().longValue());
	}
}
