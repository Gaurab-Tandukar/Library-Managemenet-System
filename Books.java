
public abstract class Books
{
    protected String title;
    protected int id;
    protected String author;
    protected int bookCount;
    protected boolean isAvailable;
    
    // Constructor
    public Books(String title, int id, String author, int bookCount) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.bookCount = bookCount;
        this.isAvailable = true;
    }

    
    // Getters
    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
   
    public boolean getIsAvailable(int count) {
        if(count > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public abstract void borrowBook();
    
    public abstract void returnBook();
    
    public String adjustSpace(String text, int totalWidth) {
        int currentLength = text.length();
        if (currentLength >= totalWidth) {
            return text.substring(0, totalWidth);
        }
        
        String spacedText = text;
        while (spacedText.length() < totalWidth) {
            spacedText = spacedText + " "; // Concatenate a space
        }
        return spacedText;
    }
    
    public void display() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ID  Title                   Author                 Copies  Availability");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(adjustSpace(String.valueOf(this.id), 4)+adjustSpace(this.title, 24) +adjustSpace(this.author, 24) 
        +adjustSpace(String.valueOf(this.bookCount), 8) +(this.getIsAvailable(bookCount) ? "Available" : "Not Available"));
        System.out.println("--------------------------------------------------------------------------------");
        //System.out.println(this.id+"   "+this.title+"\t    "+this.author+"\t   "+this.bookCount+"\t   "+(this.getIsAvailable(bookCount) ? "Available" : "Not Available"));
    }
}
