package com.example.Reactive.Programming;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReactiveStreamExample {

    public static void javaStreamExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        squaredNumbers.forEach(System.out::println);
    }

    public static void reactiveFluxExample() {
        Flux<Integer> numberFlux = Flux.just(1, 2, 3, 4, 5)
                .map(n -> n * n) 
                .log();  

        numberFlux.subscribe(
                value -> System.out.println("Received: " + value),  
                error -> System.err.println("Error: " + error),     
                () -> System.out.println("Flux Completed")          
        );
    }

    // Emit a single value asynchronously (non-blocking)
    public static void reactiveMonoExample() {
        Mono<String> greetingMono = Mono.just("Hello, Reactive Stream!")
                .log();  

        greetingMono.subscribe(
                value -> System.out.println("Received Greeting: " + value),  
                error -> System.err.println("Error: " + error),             
                () -> System.out.println("Mono Completed")                   
        );
    }

    public static void main(String[] args) {
        System.out.println("Java Stream Example:");
        javaStreamExample();

        System.out.println("\nReactive Flux Example:");
        reactiveFluxExample();

        System.out.println("\nReactive Mono Example:");
        reactiveMonoExample();
    }
}
