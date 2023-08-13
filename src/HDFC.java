import java.util.UUID;

public class HDFC implements BankAccountInterface{

    private String name;

    private String accountNo;
    private String password;
    private double balance;
    final double rateOfInterest=7.1;
    final String IFSCCode="HDFC102345";
    //default constructor
    public HDFC() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    //parametarized constructor
    public HDFC(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your balance is"+this.balance;
        }
        return "password is incorrect";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return "amount added successfully. new amount is"+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance<amount){
                return "insufficient amount";
            }
            this.balance-=amount;
            return "amount deducted successfully. updated amount is"+ this.balance;
        }
        return "incorrect password";
    }

    @Override
    public String changePassword(String oldpassword, String newpassword) {
        if(this.password.equals(oldpassword)){
            this.password=newpassword;
            return "password changed successfully";
        }
        return "Invalid old password";
    }

    @Override
    public String toString() {
        return "HDFC{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }
}
