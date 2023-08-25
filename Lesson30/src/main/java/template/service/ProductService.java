package template.service;

import template.domain.Category;
import template.domain.Product;

public abstract class ProductService {

   public void saveOrder(Product product) {
        System.out.println("The order has been formed");
        System.out.println("The status of the product has been changed and saved to the database");
        calculateShippingCosts(product.getCategory());
    }

    protected abstract void calculateShippingCosts(Category category);
}
