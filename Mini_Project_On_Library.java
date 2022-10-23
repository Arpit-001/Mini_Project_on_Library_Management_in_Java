//Code By ARPIT
import java.util.Scanner;
import java.util.Random;
class Library{

    String[] book;
    int no_of_books;
    int index = 0;
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String[] StudentName = new String[10];
    String[] Student_Course = new String[10];
    int[] Semester = new int[10];
    int[] Library_ID = new int[10];

    public Library(String []B) {
        this.no_of_books = B.length;
        this.book = new String[100];
        System.arraycopy(B, 0, book, 0, B.length);

    }
    void showAvailBooks() {
        if (book[0] != null){
            System.out.println("These Books are Available");
            for (int i = 0; i < book.length; i++) {
                if (book[i] == null){
                    continue;
                }
                System.out.println(i + " " + book[i]);
            }
        }else {
            System.out.println("Oops No Available Book Right Now Please Try later...");
        }

    }
    void Add_Books(){
        System.out.println("How many Books You want to be Enter");
        int bookSize = sc.nextInt();
        sc.nextLine();
        if (bookSize==1){
            System.out.println("Enter Your Book Name");
            String SingleBook = sc.nextLine();
            this.book[no_of_books] = SingleBook;
            no_of_books++;
            System.out.println("The " + SingleBook +" Has Been Added...");
        }else {
            System.out.println("Enter " + bookSize + " Books Name");
            for (int i = 0; i < bookSize ; i++) {
                   this.book[no_of_books++] = sc.nextLine();
            }
            System.out.println("Books Has Been Added Successfully");
        }
    }
    void setUserDetail(){

        for (int i = 0; i < 1; i++) {
            System.out.println("Enter Your Name");
            this.StudentName[index] = sc.nextLine();

            System.out.println("Enter Your Course");
            this.Student_Course[index] = sc.nextLine();

            System.out.println("Enter Your Semester Kindly Give Integer Value");
            this.Semester[index] = sc.nextInt();

            this.Library_ID [index] = rand.nextInt(0,99999);
            sc.nextLine();
            System.out.println("Your Detail Has Been Added Successfully.......");
            System.out.println("Please Note your Library ID: " + this.Library_ID[index]);
        }
        index++;
    }
    void ShowMYDetail(){
        int count = 0;
//        for (int i = 0; i < index; i++) {
//            System.out.println(Library_ID[i]);
//        }
        System.out.println("Please Enter Your Library ID");
        int ID = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < Library_ID.length; i++) {
            if (Library_ID[i] == ID) {
                for (int j = i; j < i+1 ; j++) {
                    System.out.println("Name: " + StudentName[i]);
                    System.out.println("Course: " + Student_Course[i]);
                    System.out.println("Semester: " + Semester[i]);
                    count++;
                }
                break;
            }
        }if (count == 0)
        System.out.println("Wrong ID Please Retry...");
    }
    void issueBook(){
        int count = 0;
        System.out.println("Enter Your Library ID");
        int LibID = sc.nextInt();
        for (int value : Library_ID) {
            if (LibID == value) {
                System.out.println("Your ID Successfully Matched");
                count++;
                if (book[0] == null){
                    System.out.println("Oops No Available Book Right Now Please Try later...");
                    break;
                }
                showAvailBooks();
                System.out.println("Choose Book Number Which You want Borrow...");
                byte BookChoice = sc.nextByte();
                for (int j = 0; j < book.length; j++) {
                    if (BookChoice == j) {
                        if (book[j] != null) {
                            System.out.println("Thank for Borrowing " + book[j] + " Book");
                            no_of_books--;
                            for (int k = j; k < book.length - 1; k++) {
                                book[k] = book[k + 1];
                            }
                            break;
                        } else {
                            System.out.println("Please Enter a valid number");
                        }
                    }
                }
            }
        }
        if (count == 0){
            System.out.println("Wrong ID Please Retry");
        }
     }
  }
public class Mini_Project_On_Library {
    public static void main(String[] args) {
        String defualt_Books[] = {"The Alchemist","Think Grow and rich","Digital Marketing","Rich Dad Poor Dad",
                "Let us C","Java Master","Mastering C++","Copy Cat Marketing"};
        Library lib = new Library(defualt_Books);
        Scanner input = new Scanner(System.in);
        byte userCh = 0;
        System.out.println("****************************** Library Management ******************************");
        do {
            System.out.println("1. Show Available Books");
            System.out.println("2. Add New Books");
            System.out.println("3. New Student Registration");
            System.out.println("4. Issue New Book");
            System.out.println("5. Show My Detail");
            System.out.println("6. Exit");
            System.out.println("Enter Your Choice");
            userCh = input.nextByte();
            switch (userCh) {
                case 1 -> {
                    lib.showAvailBooks();
                    break;
                }
                case 2 -> {
                    lib.Add_Books();
                    break;
                }
                case 3 -> {
                    lib.setUserDetail();
                    break;
                }
                case 4 -> {
                    lib.issueBook();
                    break;
                }
                case 5 -> {
                    lib.ShowMYDetail();
                    break;
                }
                case 6 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Please Enter a Valid Choice");
                }
            }
        }while (userCh!=6);
    }
}
