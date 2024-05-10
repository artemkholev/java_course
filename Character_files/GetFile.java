import javax.swing.*;
import java.io.File;

public class GetFile {
    public File file;

    public void getFileOpen() {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setDialogTitle("Open file");
        int ret = fileOpen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            this.file = fileOpen.getSelectedFile();
        }
    }

    public void getFileSave() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");
        int ret = fileChooser.showSaveDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            this.file = fileChooser.getSelectedFile();
        }
    }

    public String getFileName() {
        return file.getName();
    }

    public String getFilePath() {
        return file.getPath();
    }
}
