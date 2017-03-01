
package com.task.pages;

import static com.codeborne.selenide.Selenide.$$;

import java.util.List;
import java.util.stream.Collectors;

import com.codeborne.selenide.ElementsCollection;

public class ResultPage
{

    public List cityResults()
    {
        List cities =
            $$(".search-result-subtitle").texts().stream().map(c -> c.substring(8, c.length())).collect(Collectors.toList());
        return cities;
    }

    public ElementsCollection priceResults()
    {
        return $$(".search-result-price");
    }

}
