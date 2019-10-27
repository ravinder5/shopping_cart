[![Build Status](https://travis-ci.com/ravinder5/shopping_cart.svg?branch=master)](https://travis-ci.com/ravinder5/shopping_cart)

# shopping_cart

A simple REST application to create, update, delete and get product details

### Pre-requisites

For running thi sapplication in your local you must have below tools installed in your server:
1) Java 11 or above
2) Docker ( for running cassandra instance)

### Instructions to run locally
1) Make sure `Docker` is up and running
2) go to application folder `cd {user}/shopping_cart`
3) execute `./gradlew clean build`
4) execute `docker-compose up`. Thsi will start embedded cassandra with required key_space and Tables
5) execute `java -jar build/libs/shopping_cart-0.0.1-SNAPSHOT.jar`

### Testing the application

1) Create a product:
    ```$xslt
    curl -X POST \
      http://localhost:8080/products \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Connection: keep-alive' \
      -H 'Content-Type: application/json' \
      -d '{
    	"product_id": "12345",
    	"product_name": "test_product",
    	"product_price": "2"
    }'

2) Get Product details:
    ```$xslt
    curl -X GET \
      http://localhost:8080/products/12345 \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Content-Type: application/json'

3) Update product details:
    ```$xslt
    curl -X PUT \
      http://localhost:8080/products \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Connection: keep-alive' \
      -H 'Content-Type: application/json' \
      -d '{
    	"product_id": "12345",
    	"product_name": "test_product_updated",
    	"product_price": "2"
    }'
    
4) Get Product Details:
    ```$xslt
    curl -X GET \
      http://localhost:8080/products/12345 \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Content-Type: application/json'
      
5) Delete Product details:
    ```$xslt
    curl -X DELETE \
      http://localhost:8080/products/12345 \
      -H 'Accept: */*' \
      -H 'Accept-Encoding: gzip, deflate' \
      -H 'Content-Type: application/json'