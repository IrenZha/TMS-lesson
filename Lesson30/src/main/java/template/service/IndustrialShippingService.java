package template.service;

import template.domain.Category;

public class IndustrialShippingService extends ProductService{
    @Override
    protected void calculateShippingCosts(Category category) {
        System.out.println("Delivery of industrial goods - 25");
    }
}
