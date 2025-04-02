package com.github.dysnomya.lab1;

public class BlumBlumShub {
    private long n;
    private long x;
    private long xn;

    public BlumBlumShub(long p, long q, long x) {
        this.n = p * q;
        this.x = x;
        this.xn = (x * x) % n;
    }

    public int generateNext() {
        xn = (xn * xn) % n;

        return (int) xn & 1;
    }
}
