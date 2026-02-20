import java.util.ArrayList;
import java.util.Scanner;

public class main
{
    //initializing variables for member
    int memberId;
    String memberName;
    int memberAge;
    String memberLocation;
    
    //initializing variables for Books
    String bookname;
    int bookId;
    String bookAuthor;
    int bookCount;
    
    public static void main(String[] args) {
        ArrayList<Books> bookList = new ArrayList<>();
        ArrayList<Member> memberList = new ArrayList<>();

        Scanner sc = new Scanner(System.in); // ✅ Moved outside loop

        boolean exit = false;
        while(!exit) {
            System.out.println("What do you want to do?");
            System.out.println("1. -> Display");
            System.out.println("2. -> Add");
            System.out.println("3. -> Borrow");
            System.out.println("4. -> Return");
            System.out.println("5. -> Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt(); 
            
            switch (choice) {
                case 1:
                    System.out.println("-------------------------------------------");
                    System.out.println("1. -> Member Display");
                    System.out.println("2. -> Books Display");
                    int displayChoice = sc.nextInt(); 
                    if(displayChoice == 1){
                        if(memberList.isEmpty()) {
                            System.out.println("There are no member currently");
                        }
                        else {
                            for(Member member: memberList){
                                member.display();
                            }
                        }
                    }
                    
                    if(displayChoice == 2){
                        if(bookList.isEmpty()) {
                            System.out.println("There are no Books currently");
                        }
                        else {
                            for(Books book: bookList){
                                book.display();
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("-------------------------------------------");
                    System.out.println("1. -> Add Member");
                    System.out.println("2. -> Add Book");
                    int addChoice = sc.nextInt(); 
                    if (addChoice == 1) {
                        System.out.print("Enter Member ID: ");
                        int memberId = sc.nextInt();
                        sc.nextLine();
                
                        System.out.print("Enter Member Name: ");
                        String memberName = sc.nextLine();
                
                        System.out.print("Enter Member Age: ");
                        int memberAge = sc.nextInt();
                        sc.nextLine();
                
                        System.out.print("Enter Member Location: ");
                        String memberLocation = sc.nextLine();
                        
                        Member m = new Member(memberName, memberId, memberAge, memberLocation);
                        memberList.add(m);
                    }
                    
                    if (addChoice == 2) {
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                
                        System.out.print("Enter Book Title: ");
                        String bookTitle = sc.nextLine();
                
                        System.out.print("Enter Author of the book: ");
                        String bookAuthor = sc.nextLine();
                
                        System.out.print("Enter Book Copies: ");
                        int bookCount = sc.nextInt();
                        sc.nextLine();
                        
                        Transaction t = new Transaction(bookTitle, bookId, bookAuthor, bookCount);
                        bookList.add(t);
                    }
                    break;
                case 3:
                    System.out.println("-------------------------------------------");
                    System.out.println("Enter Book Id");
                    int borrowId = sc.nextInt(); 
                    System.out.println("Enter Member Id");
                    int memberId = sc.nextInt(); 
                    boolean got = false;
                    boolean foundBook = false;
                    for(Member member: memberList){
                        if(member.getId() == memberId) {
                            got = true;
                            for (Books book : bookList) {
                                if (book.getId() == borrowId && book instanceof Transaction) {
                                    ((Transaction) book).borrowBook();
                                    member.bookDue.add(borrowId); // ✅ Fixed duplicate add      
                                    foundBook = true;
                                    break;
                                }
                            }
            
                            if(!foundBook) {
                                System.out.println("No Book with " + borrowId + " ID.");
                            }
                            break;
                        }
                    }
                    
                    if(!got) {
                        System.out.println("No member with "+memberId+ " ID.");
                    }
                    break;
                case 4:
                    System.out.println("-------------------------------------------");
                    System.out.print("Enter Book Id: ");
                    int returnId = sc.nextInt(); 
                    System.out.print("Enter Member Id: ");
                    int rMemberId = sc.nextInt(); 
                    sc.nextLine();
                
                    boolean memberFound = false;
                    boolean bookReturned = false;
                
                    for (Member member : memberList) {
                        if (member.getId() == rMemberId) {
                            memberFound = true;
                
                            if (member.bookDue.contains(returnId)) {
                                member.bookDue.remove(Integer.valueOf(returnId));
                
                                for (Books book : bookList) {
                                    if (book.getId() == returnId && book instanceof Transaction) {
                                        ((Transaction) book).returnBook();
                                        bookReturned = true;
                                        break;
                                    }
                                }
                
                                if (!bookReturned) {
                                    System.out.println("Book ID not found in library.");
                                }
                            } else {
                                System.out.println("This member did not borrow the book with ID " + returnId);
                            }
                            break;
                        }
                    }
                
                    if (!memberFound) {
                        System.out.println("No member with ID " + rMemberId);
                    }
                    break;
                case 5:
                    System.out.println("Thanks for visiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            // ✅ sc.close() removed from here
        }
        
        sc.close(); // ✅ Moved here, closes only after loop ends
    }
}