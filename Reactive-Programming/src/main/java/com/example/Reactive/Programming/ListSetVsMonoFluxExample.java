package com.example.Reactive.Programming;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListSetVsMonoFluxExample {

    // List Example: Traditional In-Memory Data Structure 
    public static void listExample() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        numbers.stream()
                .map(n -> n * 2) 
                .forEach(n -> System.out.println("List Element: " + n));
    }

    public static void setExample() {
        Set<String> fruits = new HashSet<>(Arrays.asList("Apple", "Banana", "Mango", "Banana", "Grapes"));

        fruits.forEach(fruit -> System.out.println("Set Element: " + fruit));
    }

    public static void monoExample() {
        Mono<String> greetingMono = Mono.just("Hello, Reactive World!")
                .map(greeting -> greeting + " (Processed)");

        greetingMono.subscribe(
                value -> System.out.println("Mono Value: " + value), 
                error -> System.err.println("Error: " + error),      
                () -> System.out.println("Mono Completed")           
        );
    }

    public static void fluxExample() {
        Flux<Integer> numberFlux = Flux.just(1, 2, 3, 4, 5)
                .map(n -> n * 2)  
                .delayElements(Duration.ofMillis(500))  
                .log();  

        numberFlux.subscribe(
                value -> System.out.println("Flux Value: " + value), 
                error -> System.err.println("Error: " + error),      
                () -> System.out.println("Flux Completed")           
        );
    }

    public static void main(String[] args) {
        System.out.println("List Example:");
        listExample();

        System.out.println("\nSet Example:");
        setExample();

        System.out.println("\nMono Example:");
        monoExample();

        System.out.println("\nFlux Example:");
        fluxExample();
    }
}
