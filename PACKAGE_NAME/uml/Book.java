package PACKAGE_NAME.uml;

public abstract class Book {
    protected int number;
    private String title;
    private String author;

    public Book(int number, String title, String author) {
        this.number = number;
        this.title = title;
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public abstract int getLateFee(int days);

    public void print() {
        System.out.printf("관리번호: %d번, 제목: %s, 작가: %s(일주일 연체료: %,d원)\n", number, title, author, getLateFee(7));
    }
}

class Novel extends Book {
    public Novel(int number, String title, String author) {
        super(number, title, author);
    }

    @Override
    public int getLateFee(int days) {
        return 300 * days;
    }
}

class Poet extends Book {
    public Poet(int number, String title, String author) {
        super(number, title, author);
    }

    @Override
    public int getLateFee(int days) {
        return 200 * days;
    }
}

class ScienceFiction extends Book {
    public ScienceFiction(int number, String title, String author) {
        super(number, title, author);
    }

    @Override
    public int getLateFee(int days) {
        return 600 * days;
    }
}

class Test{
    public static void main(String[] args) {
        Book[] book = new Book[6];
        book[0] = new Novel(3, "첫번째소설", "차현수");
        book[1] = new Novel(4, "두번째소설", "차현수");
        book[2] = new Poet(5, "첫번째시", "차현수");
        book[3] = new Poet(6, "두번째시", "차현수");
        book[4] = new ScienceFiction(7, "첫번째과학소설", "차현수");
        book[5] = new ScienceFiction(8, "두번째과학소설", "차현수");

        for (Book b : book) {
            b.print();
        }

    }
}

