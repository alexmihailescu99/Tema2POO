package main;

import fileio.FileSystem;


import java.io.IOException;

public final class Main {
    private Main() {

    }
    public static void main(String[] args) throws IOException {
        System.out.println("MERGE GITU BAA");
        FileSystem io = new FileSystem("/home/alex/Videos/Tema2POO/mata.txt",
                "/home/alex/Videos/Tema2POO/mata2.txt");
        int x = io.nextInt();
        System.out.println(x);
        io.writeInt(x);
        io.close();
    }
}
