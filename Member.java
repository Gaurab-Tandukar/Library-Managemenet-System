import java.util.ArrayList;

public class Member
{
    protected String name;
    protected int id;
    protected int age;
    protected String location;
    
    // Constructor
    public Member(String name, int id, int age, String location) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.location = location;
    }

    ArrayList<Integer> bookDue = new ArrayList<>();
    
    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
    
    public String adjustSpace(String text, int totalWidth) {
        int currentLength = text.length();
        if (currentLength >= totalWidth) {
            return text.substring(0, totalWidth);
        }
        
        String paddedText = text;
        while (paddedText.length() < totalWidth) {
            paddedText = paddedText + " "; // Concatenate a space
        }
        return paddedText;
    }
    
    public void display() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ID  Name                   Age      Location");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(adjustSpace(String.valueOf(this.id), 4)+adjustSpace(this.name, 24)+adjustSpace(String.valueOf(this.age), 8)+
        adjustSpace(this.location, 27));
        System.out.println("--------------------------------------------------------------------------------");
    }
}
