package piggyBank;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main
{

//    System.out.println("The piggy bank holds " + fp.format(myValue));
    public static void main(String[] args)
    {
        Denomination value = new Denomination();
        DecimalFormat fp = new DecimalFormat("$###,###.00");
        ArrayList<Coin> piggyBank = new ArrayList<>();

        Coin quarter = new Coin(value.quarter, 1);
        piggyBank.add(quarter);
        Coin dime = new Coin(value.dime, 1);
        piggyBank.add(dime);
        Coin dollar5 = new Coin(value.dollar, 5);
        piggyBank.add(dollar5);
        Coin nickel3 = new Coin(value.nickel, 3);
        piggyBank.add(nickel3);
        Coin dime7 = new Coin(value.dime, 7);
        piggyBank.add(dime7);
        Coin dollar = new Coin(value.dollar, 1);
        piggyBank.add(dollar);
        Coin penny10 = new Coin(value.penny, 10);
        piggyBank.add(penny10);

        double totalValue = 0;
        String coinType = "";
        for (Coin c : piggyBank)
        {
            // While we're looping calculate the total amount in the bank for later use
            totalValue += c.calculateTotalValue();

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

        // Display the total contents of the piggy bank
        String bankValue = "The piggy bank holds " + fp.format(totalValue);
        System.out.println(bankValue);
    }
}
