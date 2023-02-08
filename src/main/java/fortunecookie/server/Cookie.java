package main.java.fortuneCookie.server;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cookie {
  public static String getRandomCookie(String path) {
    String randomCookie = "";
    String output = "";

    // get cookies using other method
    List<String> cookies = getCookiesFromFile(path);

    // get random cookie from list using Random
    Random random = new Random();
    int position = random.nextInt(cookies.size());
    randomCookie = cookies.get(position);

    output = randomCookie;

    return output;
  }

  public static List<String> getCookiesFromFile(String path) {
    // instantiate file using the fully qualified path
    File cookieFile = new File(path);

    // this data structure used to hold cookies
    List<String> cookies = new LinkedList<>();

    Scanner scanner;
    try {
      // read file
      scanner = new Scanner(cookieFile);
      // go through each line and add each cookie to the list
      while (scanner.hasNextLine()) {
        cookies.add(scanner.nextLine());
      }
      scanner.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return cookies;
  }
}
