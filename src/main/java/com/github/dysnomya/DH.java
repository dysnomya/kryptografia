package com.github.dysnomya;

import java.math.BigInteger;

public class DH {
    private BigInteger n;
    private BigInteger g;

    public DH(BigInteger n, BigInteger g) {
        this.n = n;
        this.g = g;
    }

    public BigInteger getX(BigInteger x) {
        return g.modPow(x, n);
    }

    public BigInteger getY(BigInteger y) {
        return g.modPow(y, n);
    }

    public BigInteger getSessionKey(BigInteger big, BigInteger small) {
        return big.modPow(small, n);
    }
}
