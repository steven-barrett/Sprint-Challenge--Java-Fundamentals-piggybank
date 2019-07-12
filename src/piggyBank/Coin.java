package piggyBank;

public class Coin
{
    private double value;
    private int quantity = 0;
    private String type;

    public Coin(double value, int quantity)
    {
        this.value = value;
        this.quantity = quantity;
        if (this.quantity == 0)
        {
            this.quantity = 1;
        }

        // Used if tests to determine the type of coin, a switch doesn't work with a double
        if (value == 0.01)
        {
            type = "Penny";
        }
        if (value == 0.05)
        {
            type = "Nickel";
        }
        if (value == 0.10)
        {
            type = "Dime";
        }
        if (value == 0.25)
        {
            type = "Quarter";
        }
        if (value == 1.00)
        {
            type = "Dollar";
        }
    }
    public double getValue()
    {
        return value;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getType()
    {
        return type;
    }

    public double calculateTotalValue()
    {
        return this.value * this.quantity;
    }
}
