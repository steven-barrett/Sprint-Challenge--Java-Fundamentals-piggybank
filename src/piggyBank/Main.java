package piggyBank;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Main
{
    public static void printBankContents(ArrayList<Coin> coins)
    {
        String coinType = "";
        for (Coin c : coins)
        {
            // If we have more than 1 coin and it's not a dollar or penny use the plural S
            if ((c.getQuantity() > 1) && (c.getType() != "Dollar" || c.getType() != "Penny"))
            {
                coinType = c.getType() + "s";
            } else if ((c.getQuantity() == 1) && (c.getType() != "Dollar" || c.getType() != "Penny"))  // Use singular pronoun
            {
                coinType = c.getType();
            }

            // If we're dealing with pennies we need ies instead of the s
            if ((c.getQuantity() > 1) && (c.getType() == "Penny"))
            {
                coinType = "Pennies";
            } else if ((c.getQuantity() == 1) && (c.getType() == "Penny"))
            {
                coinType = c.getType();  // if there is only one penny just return the type
            }

            if (c.getType() == "Dollar")
            {
                // Print the contents of the piggy bank
                System.out.println("$" + c.getQuantity());
            } else
            {
                // Print the contents of the piggy bank
                System.out.println(c.getQuantity() + " " + coinType);
            }
        }

    }
    public static void main(String[] args)
    {
        Denomination value = new Denomination();
        PiggyBank piggyBank = new PiggyBank();
        DecimalFormat fp = new DecimalFormat("$###,###.00");

        Coin quarter = new Coin(value.quarter, 1);
        piggyBank.addCoinToBank(quarter);
        Coin dime = new Coin(value.dime, 1);
        piggyBank.addCoinToBank(dime);
        Coin dollar5 = new Coin(value.dollar, 5);
        piggyBank.addCoinToBank(dollar5);
        Coin nickel3 = new Coin(value.nickel, 3);
        piggyBank.addCoinToBank(nickel3);
        Coin dime7 = new Coin(value.dime, 7);
        piggyBank.addCoinToBank(dime7);
        Coin dollar = new Coin(value.dollar, 1);
        piggyBank.addCoinToBank(dollar);
        Coin penny10 = new Coin(value.penny, 10);
        piggyBank.addCoinToBank(penny10);

        // Display bank contents
        printBankContents(piggyBank.getCoins());

        // Display the total contents of the piggy bank
        String bankValue = "The piggy bank holds " + fp.format(piggyBank.getTotalAmount());
        System.out.println(bankValue);

        // *********************Stretch *************************
        //piggyBank.subtractAmountFromBank(1.50);  // Current total before subtraction is 7.30

        // Display the updated contents after subtraction
        //printBankContents(piggyBank.getCoins());
    }
}
