
package com.task.pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;

public class ResultPage
{

    public ElementsCollection results()
    {

        return $$(".search-result-subtitle");
    }



}
