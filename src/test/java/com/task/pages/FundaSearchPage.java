
package com.task.pages;

import static com.codeborne.selenide.Selenide.*;

public class FundaSearchPage
{
    public ResultPage search(String query)
    {
        $("#autocomplete-input").sendKeys(query);
        $(".button-primary-alternative").doubleClick();
        return page(ResultPage.class);

    }
}
