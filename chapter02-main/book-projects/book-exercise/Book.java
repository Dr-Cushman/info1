/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int pageNumber)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = pageNumber;
        refNumber = "";
    }

    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getPages() {
        return pages;
    }
    public void printAuthor() {
        System.out.println(author);
    }
    
    public void printTitle() {
        System.out.println(title);
    }
    
    public void printDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Number of Pages: " + pages);
        if (refNumber == "") {
            System.out.println("no reference number");
        } else {
            System.out.println("ref. Number : " + refNumber);
        }
    }
    
    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber (String ref) {
        if (ref.length() < 3) {
            System.out.println("The refference number cannot be less than 3 char long");
        } else {
            refNumber = ref;
        }
    }
}
