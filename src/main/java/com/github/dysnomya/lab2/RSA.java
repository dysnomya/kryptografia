package com.github.dysnomya.lab2;

import java.math.BigInteger;

public class RSA {
    private final BigInteger e;
    private final BigInteger n;
    private final BigInteger d;

    public RSA(BigInteger p, BigInteger q, BigInteger e) {
        this.n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.e = e;
        this.d = e.modInverse(phi);
    }

    public String encryptMessage(String message) {

        StringBuilder sb = new StringBuilder();

        for (char ch : message.toCharArray()) {
            BigInteger m = BigInteger.valueOf((int) ch);
            BigInteger c = m.modPow(e, n);
            sb.append(c).append(" ");
        }
        return sb.toString().trim();
    }

    public String decryptMessage(String message) {
        StringBuilder sb = new StringBuilder();
        String[] encryptedValues = message.split(" ");

        for (String value : encryptedValues) {
            BigInteger c = new BigInteger(value);
            BigInteger m = c.modPow(d, n);
            sb.append((char) m.intValue());
        }

        return sb.toString();
    }
}
