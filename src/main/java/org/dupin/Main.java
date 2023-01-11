package org.dupin;
public class Main {
    public static void main(String[] args) {
        ASCIIConverter asciiConverter = new ASCIIConverter("src/main/resources/anime.jpg");
        asciiConverter.show();
    }
}