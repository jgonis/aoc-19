package com.jgon.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem2 {
    public static void main(String[] args) throws IOException {
       Problem2 app = new Problem2();
        InputStream fileFromResources = app.getFileFromResources();
        if(fileFromResources != null) {
            InputStreamReader isr = new InputStreamReader(fileFromResources);
           BufferedReader br = new BufferedReader(isr);
           String s = br.readLine();
           while(s != null) {
               System.out.println(s);
               s = br.readLine();
           }
       }
    }

    // get file from classpath, resources folder
    private InputStream getFileFromResources() {
        InputStream resource = this.getClass().getResourceAsStream("/p2input.txt");

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return resource;
        }
    }
}
