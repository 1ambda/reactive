package com.github.lambda.reactive.java;

import rx.Observable;

import java.util.Random;

public class Test1 {
    public void experiment() {
        createNumbers(10)
                .map(x -> x + 1)
                .filter(x -> x > 500)
                .subscribe(n ->  System.out.println(n) );
    }

    public Observable<Integer> createNumbers(int n) {
        return Observable.create(subs -> {
            Random gen = new Random();

            for(int i = 0; i < n; i++) {
                if(!subs.isUnsubscribed()) subs.onNext(gen.nextInt(1000));
            }

            if (!subs.isUnsubscribed()) subs.unsubscribe();
        });
    }
}
