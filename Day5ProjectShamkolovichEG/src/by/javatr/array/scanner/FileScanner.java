package by.javatr.array.scanner;

import by.javatr.array.service.StringOperation;

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

    public int[] inputNumbersFromFile() throws IOException {
        String line = getLineFromFile(path);

        StringOperation operation = new StringOperation();

        return operation.getIntArrayFromLine(line);
    }

    private String getLineFromFile(String path) throws IOException {
        StringBuffer result = new StringBuffer();

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        result.append(reader.readLine());

        return result.toString();
    }
}
