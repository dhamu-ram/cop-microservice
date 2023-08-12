package io.com.order.api.ordermanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.com.order.api.ordermanagement.model.Order;
import io.com.order.api.ordermanagement.service.OrderService;

public class OrderControllerTest {

	@InjectMocks
	private OrderController orderController;

	@Mock
	private OrderService orderService;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@Test
	public void testPlaceOrder() throws Exception {
		long id = 1;
		long buyerId = 1;
		List<String> products = new ArrayList<>();
		products.add("samsung");
		products.add("oppo");
		Order order = new Order();
		order.setId(id);
		order.setBuyerId(buyerId);
		order.setProducts(products);
		ObjectMapper objectMapper = new ObjectMapper();

		String uri = "/placeOrder";
		when(orderService.placeOrder(order)).thenReturn(order);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(order));

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals(objectMapper.writeValueAsString(order), mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testgetOrdersByBuyerId() throws Exception {
		long id = 1;
		long buyerId = 1;
		List<String> products = new ArrayList<>();
		products.add("samsung");
		products.add("oppo");
		Order order = new Order();
		order.setId(id);
		order.setBuyerId(buyerId);
		order.setProducts(products);

		List<String> products_two = new ArrayList<>();
		products_two.add("sony");
		products_two.add("MI");
		Order order_two = new Order();
		order_two.setId((long) 2);
		order_two.setBuyerId(buyerId);
		order_two.setProducts(products);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		orders.add(order_two);
		ObjectMapper objectMapper = new ObjectMapper();

		String uri = "/buyer/{buyerId}";
		when(orderService.getOrdersByBuyerId(buyerId)).thenReturn(orders);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, buyerId).contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(orders));

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals(objectMapper.writeValueAsString(orders), mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testgetOrderById() throws Exception {
		long orderId = 2;
		long buyerId = 2;
		List<String> products = new ArrayList<>();
		products.add("samsung");
		products.add("oppo");
		Order order = new Order();
		order.setId(orderId);
		order.setBuyerId(buyerId);
		order.setProducts(products);
		ObjectMapper objectMapper = new ObjectMapper();
		Optional<Order> orders = Optional.of(order);
		String uri = "/{orderId}";

		when(orderService.getOrderById(orderId)).thenReturn(orders);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, orderId).contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(orders));

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(objectMapper.writeValueAsString(orders));
		System.out.println(mvcResult.getResponse().getContentAsString());
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals(objectMapper.writeValueAsString(orders.get()), mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testcancelOrder() throws Exception {
		long orderId = 1;
	    String uri = "/" + orderId;

	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn();

	    String expectedResponse = "Order deleted successfully for " + orderId;
	    String actualResponse = mvcResult.getResponse().getContentAsString();
	    assertEquals(expectedResponse, actualResponse);
	    verify(orderService, times(1)).cancelOrder(orderId);
	}
}
