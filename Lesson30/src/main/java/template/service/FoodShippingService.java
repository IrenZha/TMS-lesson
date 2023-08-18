package template.service;

import template.domain.Category;

public class FoodShippingService extends ProductService{
    @Override
    protected void calculateShippingCosts(Category category) {
        System.out.println("Food delivery - 10");
    }
}
