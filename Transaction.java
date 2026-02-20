
public class Transaction extends Books
{
    public Transaction(String title, int id, String author, int bookCount) {
        super(title, id, author, bookCount);
    }
    
    @Override
    public void borrowBook() {
        if(this.getIsAvailable(this.bookCount)) {
            System.out.println(this.title + " is borrowed.");
            this.bookCount -= 1;
        }
        else {
            System.out.println(this.title + " is not available.");
        }
    }
    
    @Override
    public void returnBook() {
        this.bookCount += 1;
        System.out.println("Thank you for returning.");
    }
}
