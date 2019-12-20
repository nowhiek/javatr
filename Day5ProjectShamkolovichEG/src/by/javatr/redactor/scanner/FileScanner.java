package by.javatr.redactor.scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class FileScanner {

    private String path;

    public FileScanner() {
    }

    public FileScanner(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTextFromFile() throws IOException {
        StringBuffer result = new StringBuffer();

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line;

        while ((line = reader.readLine()) != null) {
            result.append(line.concat("\n"));
        }

        return result.toString();
    }
}
