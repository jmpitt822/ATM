/**
 * Created by jeremypitt on 8/31/16.
 */
public class User {
    public static User user = new User();

    String name;
    String choice;

    public void chooseName() throws Exception {
        System.out.println("Hello! What is your name?");
        name = Main.scanner.nextLine();
        if(name.isEmpty()) {
            System.out.println("Hello, " + name +"!");
        }
        else {
            throw new Exception("Name field can not be left blank!");
        }
    }
    public void chooseAction() throws Exception {
        System.out.println("What would you like to do? [Check Balance, Withdraw, Cancel]");
        choice = Main.scanner.nextLine();
        if(choice.equalsIgnoreCase("Check Balance")){
            user.checkBalance();
        }
        else if(choice.equalsIgnoreCase("Withdraw")){
            user.withdraw();

        }
        else if(choice.equalsIgnoreCase("Cancel")){
            user.cancel();
        }
        else{
            throw new Exception("Invalid choice: " + choice);
        }
    }
    public void checkBalance() {
        System.out.println("Your balance is $100.");
    }
    public void withdraw() throws Exception{
        String amount;
        System.out.println("How much would you like to withdraw?");
        amount = Main.scanner.nextLine();
        int numAmount = Integer.parseInt(amount);
        if(numAmount <= 100){
            int balance = (100 - numAmount);
            if(balance >= 0){
                System.out.println("Please take your money. Your new balance is $" + balance);
            }
            else {
                throw new Exception("Error: Insufficient funds");
            }
        }
        else{
            throw new Exception("Error: Cannot withdraw more than $100");
        }

    }
    public void cancel() throws Exception {
        System.out.println("Thank you, and please come again.");
    }
}
