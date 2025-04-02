package com.github.dysnomya.lab2;

import java.math.BigInteger;

public class lab2 {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("5399");
        BigInteger q = new BigInteger("7727");
        BigInteger e = new BigInteger("4007");

        RSA rsa = new RSA(p, q, e);

        System.out.println("- WIADOMOŚĆ:");
        String message = "Lorem ipsum dolor sit amet, consectetur porttitor.";
        System.out.println(message);

        System.out.println("- ZASZYFROWANA WIADOMOŚĆ:");
        String encryptedMessage = rsa.encryptMessage(message);
        System.out.println(encryptedMessage);

        System.out.println("- ODSZYFROWANA WIADOMOŚĆ:");
        String decryptedMessage = rsa.decryptMessage(encryptedMessage);
        System.out.println(decryptedMessage);


        System.out.println("\n---------- DH ----------");
        BigInteger n = new BigInteger("4007");
        BigInteger g = new BigInteger("2371");
        DH dh = new DH(n, g);

        BigInteger aNumber = new BigInteger("1111111111111111111111111111111");
        BigInteger X = dh.getX(aNumber);
        System.out.println("A liczba: " + aNumber + " X: " + X);

        BigInteger bNumber = new BigInteger("9999999999999999999999999999999");
        BigInteger Y = dh.getY(bNumber);
        System.out.println("B liczba: " + bNumber + " Y: " + Y);

        System.out.println("A klucz sesji: " + dh.getSessionKey(Y, aNumber));
        System.out.println("B klucz sesji: " + dh.getSessionKey(X, bNumber));
    }
}
