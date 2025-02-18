package com.example.Reactive.Programming;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class SchedulersExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        //Immediate (Runs on Main Thread)
        Flux.range(1, 5)
            .map(i -> {
                System.out.println("Immediate: " + i + " | Thread: " + Thread.currentThread().getName());
                return i;
            })
            .subscribe();

        //Single (Runs on a Single Thread)
        Flux.range(1, 5)
            .publishOn(Schedulers.single())
            .map(i -> {
                System.out.println("Single: " + i + " | Thread: " + Thread.currentThread().getName());
                return i;
            })
            .subscribe();

        //Bounded Elastic (Used for I/O tasks)
        Flux.range(1, 5)
            .publishOn(Schedulers.boundedElastic())
            .map(i -> {
                System.out.println("BoundedElastic: " + i + " | Thread: " + Thread.currentThread().getName());
                return i;
            })
            .subscribe();

        //Parallel (CPU-Intensive Tasks)
        Flux.range(1, 5)
            .parallel()
            .runOn(Schedulers.parallel())
            .map(i -> {
                System.out.println("Parallel: " + i + " | Thread: " + Thread.currentThread().getName());
                return i;
            })
            .subscribe();

        Thread.sleep(2000);
    }
}
