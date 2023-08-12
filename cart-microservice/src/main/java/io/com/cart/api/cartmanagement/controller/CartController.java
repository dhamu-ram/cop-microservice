package io.com.cart.api.cartmanagement.controller;

import io.com.cart.api.cartmanagement.exception.BadRequestException;
import io.com.cart.api.cartmanagement.exception.NotFoundException;
import io.com.cart.api.cartmanagement.model.CartItem;
import io.com.cart.api.cartmanagement.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class handle all the apis related to cart service.
 *
 * @author abhis
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    /**
     * The CartService object.
     */
    @Autowired
    private CartService cartService;

    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    /**
     * @param cartItem - cart item.
     * @return return the added items in the cart.
     * @throws BadRequestException badRequestException
     */
    @PostMapping("/addProduct")
    public CartItem addToCart(@RequestBody CartItem cartItem) throws BadRequestException {
        LOGGER.info("Request received to add cart items for {}", cartItem);
        CartItem cartItems =  cartService.addToCart(cartItem);
        LOGGER.info("Successfully added items {} in cart", cartItem);
        return cartItems;
    }

    /**
     * @param id - item id.
     * @param updatedCartItem - items to be updated.
     * @return return updated cart item.
     * @throws NotFoundException notFoundException
     */
    @PutMapping("/{id}")
    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedCartItem) throws NotFoundException {
        LOGGER.info("Request received to update cart items for {}", updatedCartItem);
        CartItem cartItem =  cartService.updateCartItem(id, updatedCartItem);
        LOGGER.info("Successfully added items {} in cart", cartItem);
        return cartItem;
    }

    /**
     * @param id - id of the item.
     * @return - return the deleted message.
     * @throws NotFoundException 
     */
    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable Long id) throws NotFoundException {
        LOGGER.info("Request received to delete cart items for {}", id);
        cartService.deleteCartItem(id);
        return String.format("Cart item deleted successfully for id %d", id);
    }

    /**
     * @return the list of cart items.
     */
    @GetMapping("/getCartProduct")
    public List<CartItem> getAllCartItems() {
        LOGGER.info("Request received to fetch cart items");
        List<CartItem> cartItemList = cartService.getAllCartItems();
        LOGGER.info("Successfully fetched cart items {}", cartItemList);
        return cartItemList;
    }
}

