package PACKAGE_NAME.practice;

import java.util.Scanner;

public abstract class Book {
    protected int number;
    private String title;
    private String author;
    public Book(int number, String title, String author){
        this.number = number;
        this.title = title;
        this.author = author;
    }
    public int getNumber(){
        return number;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public abstract int getLateFee(int days);
    public void print(){
        System.out.printf("예약한 책 권수 %d 제목 : %s, 작가 : %s, 일주일 연체료(%d)\n", number,title,author,getLateFee(7));
    }
}

class Novel extends Book{
    public Novel(int number, String title, String author){
        super(number,title,author);
    }


    @Override
    public int getLateFee(int days){
        return 200*days;
    }

}
class Poet extends Book{
    public Poet(int number, String title, String author){
        super(number,title,author);
    }


    @Override
    public int getLateFee(int days){
        return 300*days;
    }

}
class ScienceFiction extends Book{
    public ScienceFiction(int number, String title, String author){
        super(number,title,author);
    }


    @Override
    public int getLateFee(int days){
        return 600*days;
    }

}
class Test{
    public static void main(String [] args){
        Book[] books = new Book[3];
        books[0] = new Novel(5,"배현서의 책", "배현서");
        books[1] = new Poet(2,"배현서의 시", "배현서");
        books[2] = new ScienceFiction(3,"배현서의 과학", "배현서");
        for(Book book : books){
            book.print();
        }
    }
}