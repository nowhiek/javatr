package by.javatr.library.bean;

public class Book implements Cloneable {
    private long idBook;
    private String nameBook;
    private Author[] authorsBook;
    private Publishing publishingBook;
    private int countPagesBook;

    public Book() {
    }

    public Book(long idBook, String nameBook, Author[] authorsBook, Publishing publishingBook, int countPagesBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.authorsBook = authorsBook;
        this.publishingBook = publishingBook;
        this.countPagesBook = countPagesBook;
    }

    //Book without author.
    public Book(long idBook, String nameBook, Publishing publishingBook, int countPagesBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.publishingBook = publishingBook;
        this.countPagesBook = countPagesBook;
    }

    //Book without publishing.
    public Book(long idBook, String nameBook, Author[] authorsBook, int countPagesBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.authorsBook = authorsBook;
        this.countPagesBook = countPagesBook;
    }

    //Book without publishing & author.
    public Book(long idBook, String nameBook, int countPagesBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.countPagesBook = countPagesBook;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    //
    public Author[] getAuthorsBook() {
        return authorsBook;
    }

    public void setAuthorsBook(Author[] authorsBook) {
        this.authorsBook = authorsBook;
    }

    //
    public Publishing getPublishingBook() {
        return publishingBook;
    }

    public void setPublishingBook(Publishing publishingBook) {
        this.publishingBook = publishingBook;
    }

    public int getCountPagesBook() {
        return countPagesBook;
    }

    public void setCountPagesBook(int countPagesBook) {
        this.countPagesBook = countPagesBook;
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        Book clone = (Book) super.clone();

        if (authorsBook != null) {
            Author[] cloneAuthors = new Author[getAuthorsBook().length];

            for (int i = 0; i < cloneAuthors.length; i++) {
                cloneAuthors[i] = authorsBook[i].clone();
            }

            clone.setAuthorsBook(cloneAuthors);
        }
        if (publishingBook != null) {
            clone.setPublishingBook(clone.getPublishingBook().clone());
        }

        return clone;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = (int) (idBook + (nameBook == null ? 0 : nameBook.hashCode()));

        if (authorsBook != null && authorsBook.length != 0){
            for (int i = 0; i < authorsBook.length; i++){
                result = result * prime + authorsBook[i].hashCode();
            }
        }

        result = result * prime + publishingBook.hashCode();
        result = result * prime + Integer.valueOf(countPagesBook).hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Book tmp = (Book) obj;

        if (idBook != tmp.idBook)
            return false;
        if (nameBook == null){
            if (tmp.nameBook != null)
                return false;
        }else if (!nameBook.equals(tmp.nameBook)){
            return false;
        }
        if (authorsBook == null){
            if (tmp.authorsBook != null)
                return false;
        }else if (authorsBook.length != tmp.authorsBook.length){
            return false;
        }else {
            for (int i = 0; i < authorsBook.length; i++){
                if (!authorsBook[i].equals(tmp.authorsBook[i])){
                    return false;
                }
            }
        }
        if (publishingBook == null){
            if (tmp.publishingBook != null)
                return false;
        }else if (!publishingBook.equals(tmp.publishingBook)) {
            return false;
        }
        if (countPagesBook != tmp.countPagesBook)
            return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName()).concat(" - \n"));

        if (nameBook != null) {
            sb.append("\tid : " + idBook + "\n");
            sb.append("\tBook name : " + nameBook + "\n");
            sb.append("\tAuthors : ");

            if (authorsBook != null && authorsBook.length != 0) {
                for (int i = 0; i < authorsBook.length; i++) {
                    sb.append(authorsBook[i] + "\t");
                }
                sb.append("\n");
            } else {
                sb.append("empty\n");
            }

            sb.append("\tPublishing : ");
            if (publishingBook != null) {
                sb.append(publishingBook.toString() + "\n");
            } else {
                sb.append("empty\n");
            }

            sb.append("\tCount pages : " + countPagesBook + "\n");
        }else{
            sb.append("\tempty\n");
        }
        sb.append("]");

        return sb.toString();
    }
}
