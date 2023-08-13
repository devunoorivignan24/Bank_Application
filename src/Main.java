// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HDFC vignan=new HDFC("vignan","DV@123",2000);
        System.out.println(vignan);

        // fetch balance
        System.out.println(vignan.fetchBalance("random"));  // wrong password
        System.out.println(vignan.fetchBalance("DV@123"));  //correct password

        // add money
        System.out.println(vignan.addMoney(100000));

        // withdraw
        System.out.println(vignan.withdrawMoney(200000,"DV@123"));
        System.out.println(vignan.withdrawMoney(50000,"DV@123"));
        System.out.println(vignan.withdrawMoney(50000,"random"));


        // change Password
        System.out.println(vignan.changePassword("DV@123","vignan"));
        System.out.println(vignan.fetchBalance("vignan"));

        //calculate interest
        System.out.println("Interest for 5 years on current balance will be: " + vignan.calculateInterest(5));
    }
}