package com.libert.lab;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class TestLibertCache {
    final Object obj = new Object();
    final int SIZE = 10000;
    final LibertCache<Object> cache = new LibertCache<>(SIZE);
//    final LimitHashtable<String, Object> cache = new LimitHashtable<>(SIZE);

    @Benchmark
    @Threads(100)
    @Warmup(iterations = 1, time = 3)
    @Measurement(iterations = 3, time = 3)
    public void hitAll() {
        for (int i = 11; i < 20010; i++) {
            cache.put("" + i, obj);
            int j = 10;
            while ((--j) >= 0) {
                cache.get("" + (i - j));
            }
        }
    }

    public void hitNone() {
        //TODO
    }
    public void hitHalf() {
        //TODO
    }
    public void hit80Percent() {
        //TODO
    }
}
