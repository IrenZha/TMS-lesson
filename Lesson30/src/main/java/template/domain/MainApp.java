package template.domain;

import template.service.FoodShippingService;
import template.service.IndustrialShippingService;
public class MainApp {
    public static void main(String[] args) {
        Product foodProduct = new Product("food", Category.FOOD);
        FoodShippingService foodShippingService = new FoodShippingService();
        foodShippingService.saveOrder(foodProduct);

        Product industrialProduct = new Product("industrial", Category.INDUSTRIAL);
        IndustrialShippingService industrialShippingService = new IndustrialShippingService();
        industrialShippingService.saveOrder(industrialProduct);


    }
}
