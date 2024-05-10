import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileOptions {
    private final Map<Integer, Integer> letters = new HashMap<>();

    public void messageRead(String fileName, String filePath) {
        System.out.println("Вы выбрали файл для считывания: " + fileName + " по пути " + filePath);
    }

    public void messageWrite(String fileName, String filePath) {
        System.out.println("Вы выбрали файл для сохранения: " + fileName + " по пути " + filePath);
    }

    public void readFile(File file) {
        try {
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in);

            int charElem;
            while ((charElem = reader.read()) != -1) {
                if (charElem == '\n' || charElem == ' ') {
                    continue;
                }
                if (letters.containsKey(charElem)) {
                    letters.put(charElem, letters.get(charElem) + 1);
                } else {
                    letters.put(charElem, 1);
                }
            }
            reader.close();
        }  catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public void writeFile(File file) {
        BufferedWriter output;
        try {
            FileWriter out =  new FileWriter(file);
            output = new BufferedWriter(out);
            for (Map.Entry<Integer, Integer> entry: letters.entrySet()) {
                output.write((char) entry.getKey().intValue() + " count: " + entry.getValue() + "\n");
            }
            output.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
