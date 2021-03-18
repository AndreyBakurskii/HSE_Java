import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputData {
    private String filename;
    private FileReader file;

    public InputData(String filename){
        this.filename = filename;
    }

    public void openFile() throws Exception{
        File fileHandler = new File(this.filename);

        if (!fileHandler.exists())
            throw new Exception("File does not exist!");

        this.file = new FileReader(fileHandler);
    }

    public String dataFromFile() throws IOException{
        BufferedReader reader = new BufferedReader(this.file);
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null ) {
            stringBuilder.append(line);
        }
        reader.close();

        return stringBuilder.toString();
    }
}
