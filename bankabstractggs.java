import java.util.Scanner;
interface RBI{
    int mins =4;
    int minc=2;
    void calculateInterest();
}
abstract class BankAccount{
    Scanner sc  = new Scanner(System.in);
    int accono;
    double balance;
    String cName, city;
    int deposit;
    void inputdata(){
        System.out.println("Enter the Account number:");
        accono = sc.nextInt();
        System.out.println("Enter city name");
        city = sc.next();
        System.out.println("Enter  name");
        cName = sc.next();
        System.out.println("Enter the Account balance:");
        this.balance = this.balance + sc.nextInt();

    }
    void display(){
        System.out.println("The account number is:"+accono);
        System.out.println("The account customer name is:"+cName);
        System.out.println("The customer city is:"+city);
        System.out.println("The account balance is:"+this.balance);
    }
    abstract void deposit();
    abstract void withDraw();
}

class SavingsAccount extends BankAccount implements RBI{

    void withDraw(){
        System.out.println("Enter the amount to be withdrawn");
        int amount = sc.nextInt();
        if((super.balance-amount<1000)||(amount>=10000)){
            System.out.println("Sorry cannot be withdrawn due to acount balance limit");
        }
        else{
            super.balance = super.balance - amount;
        }
    }
    void deposit(){
        System.out.println("Enter amount to be deposited");
        deposit = sc.nextInt();
        super.balance = deposit+super.balance;
    }
    public void calculateInterest(){
        int interest = 3;
        if(interest>=mins){
        double lmn = (super.balance/100)*interest;
        System.out.println("The amount of interest on the current balance is: "+lmn);  
        System.out.println("The total amount is: "+ (super.balance+lmn)); 
        }
        else{
            System.out.println("Set a valid interest rate as per RBI guideline");
        }
    }
}

class CurrentAccount extends BankAccount implements RBI{
     void withDraw(){
        System.out.println("Enter the amount to be withdrawn");
        int amount = sc.nextInt();
        if((super.balance-amount<1000)||(amount>=10000)){
            System.out.println("Sorry cannot be withdrawn due to account balance limit");
        }
        else{
            super.balance = super.balance - amount;
        }
    }
    void deposit(){
        System.out.println("Enter amount to be deposited");
        deposit = sc.nextInt();
        super.balance = deposit+super.balance;
    }   
    public void calculateInterest(){
        int interest = 2;
        if(interest>=minc){
        double lmn = (super.balance/100)*interest;
        System.out.println("The amount of interest on the current balance is: "+lmn);  
        System.out.println("The total amount is: "+ (super.balance+lmn)); 
        }
        else{
            System.out.println("Set a valid interest rate as per RBI guideline");
        }
    }
}


class bankabstractggs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount praju = new SavingsAccount();
        CurrentAccount praju2 = new CurrentAccount();
        int choice2 =0;
        int choice1=0;
        int choice3=0;
        while(choice1!=3){
            System.out.println("Enter 1 for Savings,Enter 2 for Current Enter 3. for exit");{
                choice1 = sc.nextInt();
                switch (choice1){
                    case 1: while(choice2!=6){ 
                    System.out.println("Enter 1. for inputdata, 2. for deposit, 3. for withdraw, 4. for display, 5. for calculating interest 6. for exit");
                            choice2 = sc.nextInt();
                            switch(choice2){
                                case 1: praju.inputdata();
                                break;
                                case 2: praju.deposit();
                                break;
                                case 3: praju.withDraw();
                                break;
                                case 4: praju.display();
                                break;
                                case 5: praju.calculateInterest();
                                break;
                                case 6:
                                System.out.println("Thank you!!");
                                break;
                                default: System.out.println("Enter valid choice");
                            }
                    }
                    break;
                    case 2: while(choice3!=6){System.out.println("Enter 1. for inputdata, 2. for deposit, 3. for withdraw, 4. for display,5. for calculating interest rate, 6. for exit");
                            choice3 = sc.nextInt();
                            switch(choice3){
                                case 1: praju2.inputdata();
                                break;
                                case 2: praju2.deposit();
                                break;
                                case 3: praju2.withDraw();
                                break;
                                case 4: praju2.display();
                                break;
                                case 5: praju2.calculateInterest();
                                break;
                                case 6:
                                System.out.println("Thank you!!");
                                break;
                                default: System.out.println("Enter valid choice");
                            }
                        }
                        break;
                    default:
                    System.out.println("Enter a valid choice");
                }
            }
        }
    }
}