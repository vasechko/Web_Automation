
package com.task.pages;

import static com.codeborne.selenide.Selenide.*;

public class FundaSearchPage
{
    // locators
    static final String PLACE_TEXTBOX = "#autocomplete-input";
    static final String SEARCH_BUTTON = ".button-primary-alternative";
    static final String DISTANCE_DROPDOWN = "#Afstand";
    static final String FROMPRICE_DROPDOWN = "#range-filter-selector-select-filter_fundakoopprijsvan";
    static final String TOPRICE_DROPDOWN = "#range-filter-selector-select-filter_fundakoopprijstot";


    public ResultPage search(String place)
    {
        $(PLACE_TEXTBOX).sendKeys(place);
        $(SEARCH_BUTTON).click();
        return page(ResultPage.class);

    }

    public ResultPage search(String place, String distance, String fromPrice, String toPrice)
    {
        $(PLACE_TEXTBOX).sendKeys(place);
        $(DISTANCE_DROPDOWN).selectOption(distance);
        $(FROMPRICE_DROPDOWN).selectOption(fromPrice);
        $(TOPRICE_DROPDOWN).selectOption(toPrice);


        $(SEARCH_BUTTON).click();
        return page(ResultPage.class);

    }
}
