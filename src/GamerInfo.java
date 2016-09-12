import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GamerInfo {
    static String name;


    public static void enterMan() throws IOException {
        System.out.println("Hello, my friend! Let's fight for our Imperor!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name");
        name = reader.readLine();
    }


}
