package com.example.Reactive.Programming;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Monofluxexample2 {

    // 1. Flux.just() - Emit multiple values sequentially
    public Flux<String> getStringFlux() {
        return Flux.just("Blueberry", "Lemon", "Cherry", "Date");
    }

    // 2. Flux.fromArray() - Emit each element of the array one by one
    public Flux<Integer> getNumberFluxFromArray() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        return Flux.fromArray(numbers);
    }

    // 3. Flux.fromIterable() - Emit elements from a collection (List)
    public Flux<String> getStringFluxFromIterable() {
        List<String> fruits = Arrays.asList("Blueberry", "Lemon", "Cherry", "Date");
        return Flux.fromIterable(fruits);
    }

    // 4. Flux.fromStream() - Emit elements from a Stream
    public Flux<Integer> getNumberFluxFromStream() {
        Stream<Integer> numberStream = Stream.of(10, 20, 30, 40, 50);
        return Flux.fromStream(numberStream);
    }

    // 5. Flux.range() - Emit a sequence of numbers starting from a specific number
    public Flux<Integer> getRangeFlux() {
        return Flux.range(1, 5);  
    }

    // 6. Flux.generate() - Generate values based on a dynamic state
    public Flux<Integer> getGeneratedFlux() {
        return Flux.generate(() -> 0, (state, sink) -> {
            if (state < 5) {
                sink.next(state);
                return state + 1;  
            } else {
                sink.complete();  
                return state;
            }
        });
    }

    // 7. Flux.concat() - Concatenate two Flux streams
    public Flux<String> getConcatenatedFlux() {
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<String> flux2 = Flux.just("D", "E", "F");
        return Flux.concat(flux1, flux2);  
    }

    // 8. Flux.merge() - Merge two Flux streams interleaved
    public Flux<String> getMergedFlux() {
        Flux<String> flux1 = Flux.just("John", "Jane", "Jack");
        Flux<String> flux2 = Flux.just("Alice", "Bob", "Charlie");
        return Flux.merge(flux1, flux2);  
    }

    // 9. Flux.zip() - Combine multiple Flux streams into a single Flux
    public Flux<String> getZippedFlux() {
        Flux<String> flux1 = Flux.just("Blueberry", "Lemon", "Cherry");
        Flux<String> flux2 = Flux.just("Blue", "Yellow", "Red");
        return Flux.zip(flux1, flux2, (fruit, color) -> fruit + " is " + color);
    }

    // 10. Flux.interval() - Emit values at regular intervals
    public Flux<Long> getIntervalFlux() {
        return Flux.interval(Duration.ofSeconds(1)).take(5);  
    }

    // 11. Flux.just() with Delay - Emit values with delay
    public Flux<String> getDelayedStringFlux() {
        return Flux.just("Blueberry", "Lemon", "Cherry", "Date")
                .delayElements(Duration.ofMillis(500));  
    }

    // --- Main Method to Test All Examples ---
    public static void main(String[] args) {
        Monofluxexample2 example = new Monofluxexample2();

        // Test Flux.just()
        example.getStringFlux().subscribe(value -> System.out.println("Fruit: " + value));
        
        // Test Flux.fromArray()
        example.getNumberFluxFromArray().subscribe(number -> System.out.println("Number: " + number));
        
        // Test Flux.fromIterable()
        example.getStringFluxFromIterable().subscribe(fruit -> System.out.println("Fruit from Iterable: " + fruit));
        
        // Test Flux.fromStream()
        example.getNumberFluxFromStream().subscribe(number -> System.out.println("Number from Stream: " + number));
        
        // Test Flux.range()
        example.getRangeFlux().subscribe(number -> System.out.println("Range Number: " + number));
        
        // Test Flux.generate()
        example.getGeneratedFlux().subscribe(number -> System.out.println("Generated Number: " + number));
        
        // Test Flux.concat()
        example.getConcatenatedFlux().subscribe(letter -> System.out.println("Concatenated Letter: " + letter));
        
        // Test Flux.merge()
        example.getMergedFlux().subscribe(name -> System.out.println("Merged Name: " + name));
        
        // Test Flux.zip()
        example.getZippedFlux().subscribe(fruitColor -> System.out.println("Zipped Fruit Color: " + fruitColor));
        
        // Test Flux.interval()
        example.getIntervalFlux().subscribe(value -> System.out.println("Interval Value: " + value));
        
        // Test Flux.just() with Delay
        example.getDelayedStringFlux().subscribe(value -> System.out.println("Delayed Value: " + value));
    }
}
