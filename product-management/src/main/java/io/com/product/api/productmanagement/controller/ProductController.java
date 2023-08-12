package io.com.product.api.productmanagement.controller;

import io.com.product.api.productmanagement.dto.ProductInDto;
import io.com.product.api.productmanagement.dto.ProductOutDto;
import io.com.product.api.productmanagement.exception.ProductNotFoundException;
import io.com.product.api.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
/**
 * The ProductController class is a REST controller that handles product-related operations.
 * @author abhis
 */
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Creates a new product.
     * @param productInDto The input DTO containing the product details.
     * @return The output DTO containing the created product details.
     */
    @PostMapping("/addproduct")
    public ProductOutDto createProduct(@RequestBody ProductInDto productInDto) {
        ProductOutDto productOutDto = productService.createProduct(productInDto);
        return productOutDto;
    }

    /**
     * Retrieves a product by its ID.
     * @param productId The ID of the product to retrieve.
     * @return The output DTO containing the retrieved product details.
     * @throws ProductNotFoundException If the product with the given ID is not found.
     */
    @GetMapping("/getproduct/{productId}")
    public ProductOutDto getProduct(@PathVariable final int productId) throws ProductNotFoundException {
        ProductOutDto productOutDto = productService.getProductById(productId);
        return productOutDto;
    }

    /**
     * Updates a product with the given ID.
     * @param productInDto The input DTO containing the updated product details.
     * @param productId    The ID of the product to update.
     * @return The output DTO containing the updated product details.
     * @throws ProductNotFoundException If the product with the given ID is not found.
     */
    @PutMapping("/updateproduct/{productId}")
    public ProductOutDto updateProduct(@RequestBody final ProductInDto productInDto, @PathVariable final int productId)
            throws ProductNotFoundException {
        ProductOutDto productOutDto = productService.getUpdateProductById(productInDto, productId);
        return productOutDto;
    }

    /**
     * Deletes a product with the given ID.
     * @param productId The ID of the product to delete.
     * @return A ResponseEntity indicating the status of the operation.
     * @throws ProductNotFoundException If the product with the given ID is not found.
     */
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable final int productId) throws ProductNotFoundException {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted successfully");
    }
}
