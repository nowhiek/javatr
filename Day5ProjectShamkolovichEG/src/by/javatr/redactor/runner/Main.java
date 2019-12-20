package by.javatr.redactor.runner;

import by.javatr.redactor.entity.TextRedactor;
import by.javatr.redactor.scanner.FileScanner;
import by.javatr.redactor.service.RegexString;
import by.javatr.redactor.service.StringOperation;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        FileScanner input = new FileScanner("file.txt");
        StringOperation operation = new StringOperation();

        try {
            String text = input.getTextFromFile();
            TextRedactor redactor = new TextRedactor(text);

            String result = redactor.removeWordsWithFirstLetterVowels(5);
            //System.out.println(text);
            System.out.println(result);
            //System.out.println(new StringOperation().removeAllTwiceWhitespace(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
