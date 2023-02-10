package fortuneCookie.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
  public static void main(String[] args) throws IOException {
    int port = 3001; // default port number

    if (args.length > 0) {
      port = Integer.parseInt(args[0]); // replace port number
    }
    String cookieFile = args[1]; // server command needs to pass in cookie file

    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    ServerSocket server = new ServerSocket(port);

    while (true) {
      Socket sock = server.accept();
      CookieClientHandler cch = new CookieClientHandler(sock, cookieFile);
      threadPool.submit(cch);
    }
  }
}
