package piggyBank;

import java.util.ArrayList;

public class PiggyBank
{
    private ArrayList<Coin> coins = new ArrayList();
    private int totalCoins = 0;
    private double totalAmount = 0.0;

    public PiggyBank()
    {
    }

    public ArrayList<Coin> getCoins()
    {
        return coins;
    }

    public int getTotalCoins()
    {
        return totalCoins;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public void addCoinToBank(Coin c)
    {
        this.coins.add(c);
        this.totalCoins += c.getQuantity();
        this.totalAmount += c.getValue() * c.getQuantity();
    }

    public static int howManyTimesDiv(double n, int div){
        int res=0;
        while(n%div==0){
            res++;
            n/=div;
        }
        return res;
    }

    public void subtractAmountFromBank(double amount)
    {
        // Figure out which coins to remove from the bank
        double reducedAmount = amount;
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        // Determine how many of each coin we have
        for (Coin c : this.coins)
        {
            switch (c.getType())
            {
                case "Penny":
                    pennies++;
                    break;

                case "Nickel":
                    nickels++;
                    break;

                case "Dime":
                    dimes++;
                    break;

                case "Quarter":
                    quarters++;
                    break;

                case "Dollar":
                    dollars++;
                    break;

                default:
                    break;
            }
        }

        double dollarsNeeded = howManyTimesDiv(reducedAmount, 1);
        int count = 1;
        for (int i = 0; count < dollarsNeeded; i++)
        {
            if (this.coins.get(i).getType() == "Dollar")
            {
                this.coins.remove(this.coins.get(i));
                this.totalCoins -= dollarsNeeded;
                this.totalAmount += this.coins.get(i).getValue() * dollars;
            }
            count++;
        }
        reducedAmount -= dollarsNeeded;

        double quartersValue = quarters * .25;
        if (reducedAmount - quartersValue > 0)
        {
            // Remove the quarters from the bank
            for (Coin c : this.coins)
            {
                if (c.getType() == "Quarter")
                {
                    this.coins.remove(c);
                    this.totalCoins -= quarters;
                    this.totalAmount += c.getValue() * quarters;
                }
            }
        } else if(reducedAmount - quartersValue < 0)
        {
            // Determine how any quarters we need to remove by figuring out the minimum quarters to use without
            // going below 0
            double rem = reducedAmount % quartersValue;

        }else
        {

        }
        double quartersNeeded = 0;
        if (reducedAmount % .25 == 0)
        {
            quartersNeeded =  reducedAmount / .25;
        }

        if (quarters < quartersNeeded)
        {
            quartersNeeded -= quarters;
            // Reduce the amount by how many quarters we have
            reducedAmount -= quarters * .25;

        }

    }
}
