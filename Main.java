import Map.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("map.in");
            FileWriter fileWriter = new FileWriter("map.out");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter writer = new PrintWriter(bufferedWriter);
            Scanner scanner = new Scanner(inputFile);
            Harta map = new Harta(scanner);
            map.executeCommands(scanner, writer);
            scanner.close();
            writer.close();
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO Error");
            System.out.println(e.toString());
        }
    }
}
