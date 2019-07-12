package piggyBank;

public class PiggyBank
{
    private int totalCoins;
    private double totalAmount;

    public PiggyBank(Coin deposit)
    {
        this.totalCoins += deposit.getQuantity();
    }
}
