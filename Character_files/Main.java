import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, user, this program will help you create a file with the number of letters. " +
                "You have to give me the path to your file.");
        System.out.println("If you want start: enter 'yes'");

        if (in.nextLine().equals("yes")) {
            //open and actions with file
            GetFile file = new GetFile();
            file.getFileOpen();
            FileOptions actionFile = new FileOptions();
            actionFile.messageRead(file.getFileName(), file.getFilePath());
            actionFile.readFile(file.file);

            //save file
            file.getFileSave();
            actionFile.messageWrite(file.getFileName(), file.getFilePath());
            actionFile.writeFile(file.file);
        }
        in.close();
    }
}
