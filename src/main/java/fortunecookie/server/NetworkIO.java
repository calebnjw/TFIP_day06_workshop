package fortunecookie.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {
  private InputStream is;
  private DataInputStream dis;
  private OutputStream os;
  private DataOutputStream dos;

  public NetworkIO(Socket socket) throws IOException {
    is = socket.getInputStream(); // get input stream from the socket
    dis = new DataInputStream(is); // turn the input stream from the socket into data

    os = socket.getOutputStream(); // same as input stream, but for output
    dos = new DataOutputStream(os);
  }

  public String read() throws IOException {
    return dis.readUTF();
  }

  public void write(String message) throws IOException {
    dos.writeUTF(message);
    dos.flush();
  }

  public void close() throws IOException {
    dis.close(); // last to open close first
    is.close(); // first to open closes last

    dos.close();
    os.close();
  }
}
