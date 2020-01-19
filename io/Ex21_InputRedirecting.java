/****************** Exercise 21 *****************
 * Write a program that takes standard input and
 * capitalizes all characters, then puts the results
 * on standard output. Redirect the contents of a
 * file into this program (the process of
 * redirection will vary depending on your operating
 * system).
 ***********************************************/
package biz.markov.thinking.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Usage: java [-classpath PATH] Ex21_InputRedirecting < FILENAME
 */
public class Ex21_InputRedirecting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            System.out.println(str.toUpperCase());
        }
    }
}
