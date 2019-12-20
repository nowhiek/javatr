package by.javatr.redactor.entity;

import by.javatr.redactor.entity.exception.InvalidSubStringException;
import by.javatr.redactor.service.RegexString;
import by.javatr.redactor.service.StringOperation;
import by.javatr.redactor.service.validator.PositionCharValidator;
import by.javatr.redactor.service.validator.StringLengthValidator;
import by.javatr.redactor.service.validator.SubStringValidator;

public class TextRedactor {

    private String text;

    public TextRedactor() {
        text = "";
    }

    public TextRedactor(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String replaceSymbolAtPosition(int position, char symbol){
        if (!new PositionCharValidator().validate(position))
            return text;

        StringBuilder sb = new StringBuilder();
        StringOperation operation = new StringOperation();

        String[] lines = operation.splitTextByEnter(text);

        for (int i = 0; i < lines.length; i++) {

            String[] words = operation.splitTextByWhitespace(lines[i]);
            for (int j = 0; j < words.length; j++) {
                if ((words[j].length() - 1 >= position && RegexString.ALL_SEPARATORS.contains(String.valueOf(words[j].charAt(words[j].length() - 1))))
                        || (words[j].length() >= position && !RegexString.ALL_SEPARATORS.contains(String.valueOf(words[j].charAt(words[j].length() - 1))))){

                    char[] chars = words[j].toCharArray();

                    chars[position - 1] = symbol;

                    for (int k = 0; k < chars.length; k++) {
                        sb.append(chars[k]);
                    }

                    sb.append(" ");
                }
                else {
                    sb.append(words[j].concat(" "));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String replaceWordsWithCurrentLength(int length, String subString) throws InvalidSubStringException {
        if (!new StringLengthValidator().validate(length))
            return text;

        if (!new SubStringValidator().validate(subString))
            throw new InvalidSubStringException("Redactor has an invalid substring.");

        StringBuilder sb = new StringBuilder();
        StringOperation operation = new StringOperation();

        String[] lines = operation.splitTextByEnter(text);

        for (int i = 0; i < lines.length; i++) {
            String[] words = operation.splitTextByWhitespace(lines[i]);

            for (int j = 0; j < words.length; j++){
                String separator = "";

                if (words[j].length() == length && !RegexString.ALL_SEPARATORS.contains(String.valueOf(words[j].charAt(words[j].length() - 1)))){
                    words[j] = subString;
                }else if (words[j].length() - 1 == length && RegexString.ALL_SEPARATORS.contains(String.valueOf(words[j].charAt(words[j].length() - 1)))){
                    separator = String.valueOf(words[j].charAt(words[j].length() - 1));
                    words[j] = subString;
                }

                sb.append(words[j].concat(separator.concat(" ")));
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public String swapLettersBeforeLetter(){
        StringBuilder sb = new StringBuilder();
        StringOperation operation = new StringOperation();

        String[] lines = operation.splitTextByEnter(text);

        for (int i = 0; i < lines.length; i++) {

            String[] words = operation.splitTextByWhitespace(lines[i]);
            for (int j = 0; j < words.length; j++) {

                char[] chars = words[j].toCharArray();
                for (int k = 0; k < chars.length; k++){

                    if (Character.toLowerCase(chars[k]) == 'р' && k != chars.length - 1){
                        char charAfterLetter = chars[k + 1];
                        boolean flag = Character.isUpperCase(charAfterLetter);

                        if (Character.toLowerCase(charAfterLetter) == 'а'){
                            chars[k + 1] = flag ? 'O' : 'o';
                        }
                    }
                    sb.append(chars[k]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String removeAllSymbolsInText(){
        StringBuilder sb = new StringBuilder();
        StringOperation operation = new StringOperation();

        String[] lines = operation.splitTextByEnter(text);

        for (int i = 0; i < lines.length; i++) {

            String[] words = operation.splitTextByWhitespace(lines[i]);
            for (int j = 0; j < words.length; j++) {
                sb.append(words[j].replaceAll(RegexString.ANY_SYMBOL_WITHOUT_WHITESPACE, "").concat(" "));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String removeWordsWithFirstLetterVowels(int length){
        if (!new StringLengthValidator().validate(length))
            return text;

        StringBuilder sb = new StringBuilder();
        StringOperation operation = new StringOperation();

        String[] lines = operation.splitTextByEnter(text);

        for (int i = 0; i < lines.length; i++) {
            String[] words = operation.splitTextByWhitespace(lines[i]);

            for (int j = 0; j < words.length; j++){
                String separator = "";
                char firstLetter = words[j].charAt(0);

                if (RegexString.VOWELS.contains(String.valueOf(firstLetter))){
                    if (words[j].length() == length && !RegexString.ALL_SEPARATORS.contains(String.valueOf(words[j].charAt(words[j].length() - 1)))){
                        words[j] = "";
                    }else if (words[j].length() - 1 == length && RegexString.ALL_SEPARATORS.contains(String.valueOf(words[j].charAt(words[j].length() - 1)))){
                        separator = String.valueOf(words[j].charAt(words[j].length() - 1));
                        words[j] = "";
                    }
                }
                sb.append(words[j].concat(separator.concat(" ")));
            }

            sb.append("\n");
        }

        return sb.toString();
    }

}
