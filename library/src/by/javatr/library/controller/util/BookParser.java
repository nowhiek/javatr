package by.javatr.library.controller.util;

import by.javatr.library.bean.Author;
import by.javatr.library.bean.Publishing;

public final class BookParser {

    public static Author[] getAuthors(String params){
        Author[] authors = null;

        if (!params.isEmpty()){
            String[] tmp = params.split("#");
            authors = new Author[tmp.length];

            for (int i = 0; i < authors.length; i++){
                String[] data = tmp[i].split(":");
                Author author = new Author(data[0], data[1]);
                authors[i] = author;
            }
        }

        return authors;
    }

    public static Publishing getPublishing(String params){
        Publishing publishing = null;

        if (!params.isEmpty()){
            String[] tmp = params.split("#");

            int idPublishing = Integer.parseInt(tmp[0]);
            String namePublishing = tmp[1];
            String countryPublishing = tmp[2];

            publishing = new Publishing(idPublishing, namePublishing, countryPublishing);
        }

        return publishing;
    }
}
