package io.com.cart.api.cartmanagement.service;

import io.com.cart.api.cartmanagement.dao.CartRepository;
import io.com.cart.api.cartmanagement.exception.BadRequestException;
import io.com.cart.api.cartmanagement.exception.NotFoundException;
import io.com.cart.api.cartmanagement.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** This class contains the business logic of cart services.
 * @author abhis
 *
 */
@Service
public class CartService {

    /**
     * The cartRepository object.
     */
    @Autowired
    private CartRepository cartRepository;

    /**
     * The sequenceGenerator.
     */
    @Autowired
    private SequenceGenerator sequenceGenerator;

    /**
     * @param cartItem cart item
     * @return the saved items in db.
     * @throws BadRequestException bad request
     */
    public CartItem addToCart(CartItem cartItem) throws BadRequestException {
        if(cartItem.getProductName().isEmpty()) {
            throw new BadRequestException("Item cannot be null or empty");
        }
        cartItem.setId(sequenceGenerator.generateSequence(CartItem.SEQUENCE_NAME));
        return cartRepository.save(cartItem);
    }


    /**
     * @param id              - item id.
     * @param updatedCartItem - items needs to be updated.
     * @return return updated cart item.
     * @throws NotFoundException nfe.
     */
    public CartItem updateCartItem(Long id, CartItem updatedCartItem) throws NotFoundException {
        Optional<CartItem> cartItemOptional = cartRepository.findById(id);

        if(cartItemOptional.isEmpty()) {
            throw new NotFoundException(String.format("Items not found in database for id {}", id));
        }
        CartItem cartItem = cartItemOptional.get();
        cartItem.setProductName(updatedCartItem.getProductName());
        cartItem.setQuantity(updatedCartItem.getQuantity());
        return cartRepository.save(cartItem);
    }


    /**
     * This method is used to delete the cart item.
     *
     * @param id - id of the item.
     * @throws NotFoundException nfe.
     */
    public void deleteCartItem(Long id) throws NotFoundException {
        Optional<CartItem> cartItemOptional = cartRepository.findById(id);

        if(cartItemOptional.isEmpty()) {
            throw new NotFoundException(String.format("Items not found in database for id {}", id));
        }
        cartRepository.deleteById(id);
    }


    /** This method is used to return all the cart items.
     * @return all the cart items.
     */
    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }


}
