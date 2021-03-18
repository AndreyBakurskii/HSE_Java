import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        InputData file = new InputData(filename);
        try {
            file.openFile();
            String data = file.dataFromFile().toLowerCase();

            Parser parser = new Parser(data);
            parser.setCountSymbolMap();
            String outputData = parser.getCountSymbolAsString();

            FileWriter outFile = new FileWriter("./data/out.txt");
            outFile.append(outputData);
            outFile.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
