package io.com.product.api.productmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.com.product.api.productmanagement.dto.ProductInDto;
import io.com.product.api.productmanagement.dto.ProductOutDto;
import io.com.product.api.productmanagement.service.ProductService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductService productService;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testCreateProduct() throws Exception {
		Long id = 1L;
		String name = "Samsung Galaxy";
		String description = "Smartphone";
		Double price = 1000.0;
		Double discount = 100.0;
		String manufacturedBy = "Samsung";
		Long quantity = 10L;

		ProductInDto productInDto = new ProductInDto();
		productInDto.setId(id);
		productInDto.setName(name);
		productInDto.setDescription(description);
		productInDto.setPrice(price);
		productInDto.setDiscount(discount);
		productInDto.setManufacturedBy(manufacturedBy);
		productInDto.setQuantity(quantity);

		ProductOutDto productOutDto = new ProductOutDto();
		productOutDto.setId(id);
		productOutDto.setName(name);
		productOutDto.setDescription(description);
		productOutDto.setPrice(price);
		productOutDto.setDiscount(discount);
		productOutDto.setManufacturedBy(manufacturedBy);
		productOutDto.setQuantity(quantity);

		ObjectMapper objectMapper = new ObjectMapper();

		String uri = "/product/addproduct";
		when(productService.createProduct(productInDto)).thenReturn(productOutDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productInDto));

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals(objectMapper.writeValueAsString(productOutDto), mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testGetProduct() throws Exception {
		int id = 1;
		String name = "Samsung Galaxy";
		String description = "Smartphone";
		Double price = 1000.0;
		Double discount = 100.0;
		String manufacturedBy = "Samsung";
		Long quantity = 10L;

		ProductOutDto productOutDto = new ProductOutDto();
		productOutDto.setId(1L);
		productOutDto.setName(name);
		productOutDto.setDescription(description);
		productOutDto.setPrice(price);
		productOutDto.setDiscount(discount);
		productOutDto.setManufacturedBy(manufacturedBy);
		productOutDto.setQuantity(quantity);

		ObjectMapper objectMapper = new ObjectMapper();

		String uri = "/product/getproduct/{productId}";
		when(productService.getProductById(id)).thenReturn(productOutDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, id).contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals(objectMapper.writeValueAsString(productOutDto), mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testUpdateProduct() throws Exception {
		Long id = 1L;
		String name = "Samsung Galaxy";
		String description = "Smartphone";
		Double price = 1000.0;
		Double discount = 100.0;
		String manufacturedBy = "Samsung";
		Long quantity = 10L;

		ProductInDto productInDto = new ProductInDto();
		productInDto.setId(id);
		productInDto.setName(name);
		productInDto.setDescription(description);
		productInDto.setPrice(price);
		productInDto.setDiscount(discount);
		productInDto.setManufacturedBy(manufacturedBy);
		productInDto.setQuantity(quantity);

		ProductOutDto productOutDto = new ProductOutDto();
		productOutDto.setId(id);
		productOutDto.setName(name);
		productOutDto.setDescription(description);
		productOutDto.setPrice(price);
		productOutDto.setDiscount(discount);
		productOutDto.setManufacturedBy(manufacturedBy);
		productOutDto.setQuantity(quantity);

		ObjectMapper objectMapper = new ObjectMapper();

		String uri = "/product/updateproduct/{productId}";
		when(productService.getUpdateProductById(productInDto, 1)).thenReturn(productOutDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri, id).contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productInDto));

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals(objectMapper.writeValueAsString(productOutDto), mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testDeleteProduct() throws Exception {
		int id = 1;

		String uri = "/product/product/{productId}";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri, id))
				.andExpect(MockMvcResultMatchers.status().isAccepted()).andReturn();
		String expectedResponse = "deleted successfully";
		String actualResponse = mvcResult.getResponse().getContentAsString();
		assertEquals(expectedResponse, actualResponse);
		verify(productService, times(1)).deleteProductById(id);
	}
}
