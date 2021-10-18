# ddd-ecommerce-ex
An example for DDD with hexagonal design patter


Assumptions
------
> To make it sample as much as we can and fouce on technologies and desgin the below item consider event it not logical.

-	Order Item status is part of the created order, however, it should exist on another module (Product catalog & Warehouse).

- Payment details are just a card number, however, it should be a module to manage customer card and payment methods.

- Customer is just an id, however, this should be more info. trigger the delivery module after order checkout.

HLD 
------

> **Architecture:** Domain Driven Desgin

> **Important Desgin Pattern :** Hexagonal desgin pattern

### Core Domain

- **Order Management**
  - submit order (Check out)
    
![OM](https://github.com/Yousry963/ddd-ecommerce-ex/blob/main/pics/om.PNG)


    
### Supporting Subdomains
  
- **Payment**
		- Integrate with external payment system 


![Payment](https://github.com/Yousry963/ddd-ecommerce-ex/blob/main/pics/payment.PNG)


Technologies
-----
-   Java 8
-   Spring boot
-   Spring JPA
-   Spring Rest
-   H2 DB
-   Lombok
-  Junit
- archunit
- swagger
-   Websocket
-   Spring Async Events
