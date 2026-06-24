package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.CartItem;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.repository.ShoppingCartRepository;

import java.util.List;

@Service
public class ShoppingCartService
{
    // a shopping cart is built from cart rows plus a product lookup for each row
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductService productService)
    {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
    }

    public ShoppingCart getByUserId(int userId)
    {
        ShoppingCart cart = new ShoppingCart();

        // load the user's cart rows, look up each product, and build the ShoppingCart
        List<CartItem> rows = shoppingCartRepository.findByUserId(userId);
        if (rows == null || rows.isEmpty())
        {
            return cart; // empty cart
        }
        // for each row, look up the product and create a ShoppingCartItem
        for (CartItem row : rows) {
            Product product = productService.getById(row.getProductId());
            if (product == null)
            {
                // product was deleted/doesn't exist — skip this row (or optionally remove it)
                continue;
            }
            ShoppingCartItem item = new ShoppingCartItem();

            item.setProduct(product);
            item.setQuantity(row.getQuantity());

            cart.add(item);
        }

        return cart;
    }

    // add additional methods here
}
