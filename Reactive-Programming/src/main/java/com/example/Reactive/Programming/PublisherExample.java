package com.example.Reactive.Programming;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ConnectableFlux;

import java.time.Duration;

public class PublisherExample {

    //Cold Publisher
    public static void coldPublisherExample() {
        Flux<String> coldFlux = Flux.just("Data1", "Data2", "Data3")
                .delayElements(Duration.ofSeconds(1));  // Simulate some delay for data emission

        coldFlux.subscribe(value -> System.out.println("Subscriber 1: " + value));

        coldFlux.subscribe(value -> System.out.println("Subscriber 2: " + value));
    }

    //Hot Publisher 
    public static void hotPublisherExample() {
        Flux<String> hotFlux = Flux.just("Live Update 1", "Live Update 2", "Live Update 3")
                .delayElements(Duration.ofSeconds(1));  

        ConnectableFlux<String> connectableFlux = hotFlux.publish();
        connectableFlux.subscribe(value -> System.out.println("Subscriber 1 (Hot): " + value));

        connectableFlux.connect();

        try {
            Thread.sleep(2000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        connectableFlux.subscribe(value -> System.out.println("Subscriber 2 (Hot): " + value));
    }

    public static void main(String[] args) {
        System.out.println("Cold Publisher Example:");
        coldPublisherExample();
        System.out.println("\nHot Publisher Example:");
        hotPublisherExample();
    }
}
