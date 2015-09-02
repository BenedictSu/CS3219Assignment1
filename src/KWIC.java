import java.util.Scanner;

//By Tan Chun How (A0111867A)and Benedict Suraj Suratanakavikul (A0110493N)
public class KWIC {

    private static final String MESSAGE_END = "end",
            MESSAGE_INTRO = "Hi, welcome",
            MESSAGE_INST = "For Pipes and Filter architecture, enter \"1\" without the quotation marks\n"
                    + "For Modified Abstract Data Type, enter \"2\" without the quotation marks",
            MESSAGE_ERROR = "Please enter only either 1 or 2";
    private static Scanner sc;
    private static String text = "";

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println(MESSAGE_INTRO);
        
        System.out.println(MESSAGE_INST);

        readInput();
        if (text == "1") {
            // Pipes and filter
            Input input = Input.getInstance();
            input.run();
        } else {
            // Modified ADT architecture
            MasterControl masterControl = MasterControl.getInstance();
            MasterControl.run();
        }

        sc.close();
    }

    private static void readInput() {
        text = sc.nextLine();
        while (!text.equals("1") && !text.equalsIgnoreCase("2")) {
            System.out.println(MESSAGE_ERROR);
            text = sc.nextLine();
        }
    }
}
