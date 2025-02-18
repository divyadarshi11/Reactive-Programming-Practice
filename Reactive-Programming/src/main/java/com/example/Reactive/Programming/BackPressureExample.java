package com.example.Reactive.Programming;
import reactor.core.publisher.Flux;

public class BackPressureExample {
    public static void main(String[] args) throws InterruptedException {
        
        //limitRate()
        System.out.println("1. Using limitRate():");
        Flux<Integer> fluxWithLimitRate = Flux.range(1, 1000);
        fluxWithLimitRate
            .limitRate(10)  
            .subscribe(value -> {
                System.out.println("Processing: " + value);
                try {
                    Thread.sleep(100);  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        
        Thread.sleep(5000); 

        //onBackpressureBuffer()
        System.out.println("\n2. Using onBackpressureBuffer():");
        Flux<Integer> fluxWithBuffer = Flux.range(1, 1000);
        fluxWithBuffer
            .onBackpressureBuffer()  
            .subscribe(value -> {
                System.out.println("Processing: " + value);
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        Thread.sleep(5000);

        //onBackpressureDrop() 
        System.out.println("\n3. Using onBackpressureDrop():");
        Flux<Integer> fluxWithDrop = Flux.range(1, 1000);
        fluxWithDrop
            .onBackpressureDrop()  
            .subscribe(value -> {
                System.out.println("Processing: " + value);
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        Thread.sleep(5000);

        //onBackpressureLatest()
        System.out.println("\n4. Using onBackpressureLatest():");
        Flux<Integer> fluxWithLatest = Flux.range(1, 1000);
        fluxWithLatest
            .onBackpressureLatest()  
            .subscribe(value -> {
                System.out.println("Processing: " + value);
                try {
                    Thread.sleep(100);  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        Thread.sleep(5000);
    }
}
