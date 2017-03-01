
package com.task.helpers;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Locale;

import com.codeborne.selenide.ElementsCollection;

public abstract class Helper
{
    public static int findMax(ElementsCollection elements)
    {
        String price = elements.texts().stream().max(Comparator.naturalOrder()).toString();
        return parseStringPriceToInt(price);
    }

    public static int findMin(ElementsCollection elements)
    {
        String price = elements.texts().stream().min(Comparator.naturalOrder()).toString();
        return parseStringPriceToInt(price);
    }

    private static int parseStringPriceToInt(String price)
    {
        int intPrice = -1;
        try
        {
            intPrice = NumberFormat.getNumberInstance(Locale.US)
                .parse(price.substring(price.indexOf(" "), price.indexOf(" k.k.")).trim())
                .intValue();
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        return intPrice;
    }
}
