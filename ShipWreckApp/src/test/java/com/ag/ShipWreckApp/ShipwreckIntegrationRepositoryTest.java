package com.ag.ShipWreckApp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ag.model.Shipwreck;
import com.ag.repository.ShipwreckRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class ShipwreckIntegrationRepositoryTest {

	@Autowired
	private ShipwreckRepository ShipwreckRepository;
	
	@Test
	public void testFindAll() {
		List<Shipwreck> wrecks = ShipwreckRepository.findAll();
		assertThat(wrecks.size(), greaterThanOrEqualTo(0));
	}

}
