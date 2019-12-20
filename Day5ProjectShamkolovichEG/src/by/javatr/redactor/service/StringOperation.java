package by.javatr.redactor.service;

public class StringOperation {

    public String[] splitTextByWhitespace(String text){
        String[] array = removeAllTwiceWhitespace(text).split(RegexString.WHITESPACE);

        return array;
    }

    public String[] splitTextByEnter(String text){
        String[] array = removeAllTwiceWhitespace(text).split("\n");

        return array;
    }

    private String removeAllTwiceWhitespace(String text){
        StringBuilder sb = new StringBuilder(text);

        int end = 0;
        int spaceIndex = -1;

        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isWhitespace(sb.charAt(i))) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = -1;
            } else if (spaceIndex < 0) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = i;
            }
        }

        sb.setLength(end);

        return sb.toString();
    }
}
