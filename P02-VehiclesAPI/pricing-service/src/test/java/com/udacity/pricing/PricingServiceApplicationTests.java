package com.udacity.pricing.test.web;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	PricingService pricingService;

	@Test
	public void testPriceApi() throws Exception{
		mockMvc.perform(get("/services/price?vehicleId=1"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("vehicleId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("price").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("currency").value("USD"));

	}
}
