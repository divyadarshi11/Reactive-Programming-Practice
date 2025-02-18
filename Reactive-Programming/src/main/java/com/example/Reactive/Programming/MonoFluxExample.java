package com.example.Reactive.Programming;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MonoFluxExample {

    public Mono<String> getUserById(int userId) {
        return Mono.just("User" + userId);
    }

    public Mono<String> getProductById(int productId) {
        return Mono.just("Product" + productId);
    }

    public Mono<String> combineUserAndProduct(int userId, int productId) {
        Mono<String> userMono = getUserById(userId);
        Mono<String> productMono = getProductById(productId);
        return Mono.zip(userMono, productMono, (user, product) -> user + " bought " + product);
    }

    public Mono<Object> handleErrorScenario() {
        return Mono.error(new RuntimeException("Something went wrong!"))
                .onErrorReturn("An error occurred, returning fallback value.");
    }

    public Mono<String> getDelayedUserInfo() {
        return Mono.just("User information")
                .delayElement(Duration.ofSeconds(2));  // Simulating delay in fetching user info
    }

    // --- Flux Examples ---
    public Flux<String> getProductList() {
        return Flux.just("Laptop", "Smartphone", "Headphones", "Camera", "Watch");
    }

    public Flux<Integer> getFilteredNumbers() {
        return Flux.range(1, 10)   // Generates numbers 1 to 10
                .filter(n -> n % 2 == 0);  // Filters even numbers
    }

    public Flux<Integer> getSquaredNumbers() {
        return Flux.range(1, 5)  // Generates numbers 1 to 5
                .map(n -> n * n);  // Squares each number
    }

    public Flux<String> getNamesWithLength() {
        return Flux.just("Alice", "Bob", "Charlie", "David")
                .map(name -> name + " has length " + name.length());
    }

    public Flux<String> getNamesStartingWithA() {
        List<String> names = Arrays.asList("Alice", "Bob", "Adam", "Eve", "Albert");
        return Flux.fromIterable(names)
                .filter(name -> name.startsWith("A"))
                .map(name -> name + " starts with A");
    }

    public Flux<String> mergeProductAndUserStreams() {
        Flux<String> userStream = Flux.just("User1", "User2", "User3");
        Flux<String> productStream = Flux.just("Product1", "Product2", "Product3");
        return Flux.merge(userStream, productStream);
    }

    public Flux<String> getNamesWithDynamicDelay() {
        return Flux.just("John", "Jane", "Jack")
                .flatMap(name -> Mono.just(name).delayElement(Duration.ofMillis(500)));  // Dynamic delay
    }

    public static void main(String[] args) {
        MonoFluxExample exercises = new MonoFluxExample();

        // Test Mono Examples
        exercises.getUserById(1).subscribe(user -> System.out.println("User: " + user));
        exercises.getProductById(101).subscribe(product -> System.out.println("Product: " + product));
        exercises.combineUserAndProduct(1, 101).subscribe(combined -> System.out.println("Combined Info: " + combined));

        exercises.handleErrorScenario().subscribe(
                result -> System.out.println("Result: " + result),
                error -> System.err.println("Error: " + error.getMessage())
        );

        exercises.getDelayedUserInfo().subscribe(userInfo -> System.out.println("Delayed Info: " + userInfo));

        // Test Flux Examples
        exercises.getProductList().subscribe(product -> System.out.println("Product: " + product));
        exercises.getFilteredNumbers().subscribe(number -> System.out.println("Filtered Number: " + number));
        exercises.getSquaredNumbers().subscribe(squared -> System.out.println("Squared Number: " + squared));
        exercises.getNamesWithLength().subscribe(nameWithLength -> System.out.println("Name Length: " + nameWithLength));
        exercises.getNamesStartingWithA().subscribe(name -> System.out.println("Name Starting with A: " + name));

        exercises.mergeProductAndUserStreams().subscribe(merged -> System.out.println("Merged Stream: " + merged));

        exercises.getNamesWithDynamicDelay().subscribe(name -> System.out.println("Delayed Name: " + name));
    }
}
