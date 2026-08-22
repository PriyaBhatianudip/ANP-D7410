package OOPs;

public class UserAccount
{
    private int accountno;
    private String acname;
    private String type;
    private float balance;
    private int userpin;

    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getUserpin() {
        return userpin;
    }

    public void setUserpin(int userpin) {
        this.userpin = userpin;
    }

    public int getAccountno() {
        return accountno;
    }

    public void setAccountno(int accountno) {
        this.accountno = accountno;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "acname='" + acname + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", userpin=" + userpin +
                ", accountno=" + accountno +
                '}';
    }
}
