package unieuroop.test.stock;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import unieuroop.model.product.Category;
import unieuroop.model.product.Product;
import unieuroop.model.product.ProductImpl;
import unieuroop.model.shop.Shop;
import unieuroop.model.shop.ShopImpl;

public class TestStock {

    private static final String APPLE_PRODUCT = "apple";
    private final Shop shop = new ShopImpl("Shop test");
    @Test
    public void testAddProducts() {
        final Product p1 = new ProductImpl(1, "iphone 13 pro", TestStock.APPLE_PRODUCT,  1200.00,  900.00, "best phone ever created", Category.SMARTPHONE);
        final Product p2 = new ProductImpl(2, "applewatch", TestStock.APPLE_PRODUCT, 500.00,  200.00, "best watch ever created", Category.SMARTWATCH);
        final Product p3 = new ProductImpl(3, "mac book pro 14 ", TestStock.APPLE_PRODUCT,  3000.00, 2000.00, "best mac book ever created", Category.PC);
        this.shop.getStock().addProducts(Map.of(p1, 2, p2, 4, p3, 1));
        assertEquals(Map.of(p1, 2, p2, 4, p3, 1), this.shop.getStock().getTotalStock());
    }

    @Test
    public void testQuantityOf() {
        final Product p4 = new ProductImpl(4, "mac book pro 16", TestStock.APPLE_PRODUCT,  6000.00,  3000.00, "best mac book ever created", Category.PC);
        final Product p5 = new ProductImpl(5, "ipad Air ", TestStock.APPLE_PRODUCT,  700.00,  300.00, "best ipad ever created", Category.HOME);
        final Product p6 = new ProductImpl(6, "ipad Pro", TestStock.APPLE_PRODUCT, 1000.00, 500.00, "best ipad Pro ever created", Category.HOME);
        final Product p7 = new ProductImpl(7, "ipad Pro Max", TestStock.APPLE_PRODUCT, 1200.00,  900.00, "best ipad pro max ever created", Category.HOME);
        this.shop.getStock().addProducts(Map.of(p4, 1, p5, 2, p6, 1, p7, 2));
        assertEquals(1, this.shop.getStock().getQuantityOfProduct(p4));
        assertEquals(2, this.shop.getStock().getQuantityOfProduct(p5));
        assertEquals(1, this.shop.getStock().getQuantityOfProduct(p6));
        assertEquals(2, this.shop.getStock().getQuantityOfProduct(p7));
    }

}
