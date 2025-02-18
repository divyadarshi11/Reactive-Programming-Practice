package com.example.Reactive.Programming;

import reactor.core.publisher.Mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;

public class MonoFluxConversionExample {

    public static void monoToFluxExample() {
        Mono<String> monoValue = Mono.just("Reactive Programming");

        Flux<String> fluxFromMono = Flux.from(monoValue);

        fluxFromMono.subscribe(value -> System.out.println("Flux Value (from Mono): " + value));
    }

    public static void fluxToMonoExample() {
        Flux<Integer> fluxValues = Flux.just(1, 2, 3, 4, 5);

        Mono<Integer> monoFromFlux = fluxValues.next();

        monoFromFlux.subscribe(value -> System.out.println("Mono Value (from Flux): " + value));
    }

    public static void fluxSinkExample() {
        Flux<Integer> generatedFlux = Flux.create(sink -> {
            sink.next(10);
            sink.next(20);
            sink.next(30);
            sink.complete(); // Complete the Flux when done
        });

        generatedFlux.subscribe(value -> System.out.println("Generated Value: " + value));
    }

    public static void fluxWithDelayExample() {
        // Creating a Flux that emits numbers with a delay
        Flux<Integer> delayedFlux = Flux.just(100, 200, 300, 400, 500)
                .delayElements(Duration.ofMillis(500))  
                .log(); // Log the signals

        delayedFlux.subscribe(value -> System.out.println("Delayed Flux Value: " + value));
    }

    public static void main(String[] args) {
        System.out.println("Mono to Flux Conversion:");
        monoToFluxExample();

        System.out.println("\nFlux to Mono Conversion:");
        fluxToMonoExample();

        System.out.println("\nFlux Sink Example (Dynamic Elements):");
        fluxSinkExample();

        System.out.println("\nFlux with Delay (Asynchronous):");
        fluxWithDelayExample();
    }
}
