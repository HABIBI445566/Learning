package org.zahimuslim;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout()
    {
        // There are few things we would do each time for a request and basic boiler code
        // Logging, Authentication, Auth, Sanitize data
        // All these are cross cutting concerns
        System.out.println("Checkout Method from ShoppingCart Called");
    }
}
