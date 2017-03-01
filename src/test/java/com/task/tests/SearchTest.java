package com.task.tests;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.task.helpers.Helper;
import com.task.pages.FundaSearchPage;
import com.task.pages.ResultPage;



public class SearchTest
{
    @Test
    public void testSearch()
    {
        FundaSearchPage searchPage = open(FundaSearchPage.URL, FundaSearchPage.class);
        ResultPage resultPage = searchPage.search("Amsterdam");
        assertThat(resultPage.cityResults().get(0), equalTo("Amsterdam"));

    }

    @Test
    public void testSearchNonDutchCity()
    {
        open(FundaSearchPage.URL, FundaSearchPage.class).search("Kiev");
        assertThat(WebDriverRunner.url(), equalTo(FundaSearchPage.URL));
    }

    @Test
    public void testPriceMinRange()
    {
        FundaSearchPage searchPage = open(FundaSearchPage.URL, FundaSearchPage.class);
        ResultPage resultPage = searchPage.search("Den Haag", "+ 0 km", "ˆ 0", "ˆ 200.000");
        assertThat(Helper.findMax(resultPage.priceResults()), lessThanOrEqualTo(200));
    }

    @Test
    public void testPriceMidRange()
    {
        FundaSearchPage searchPage = open(FundaSearchPage.URL, FundaSearchPage.class);
        ResultPage resultPage = searchPage.search("Den Haag", "+ 0 km", "ˆ 225.000", "ˆ 300.000");
        assertThat(Helper.findMin(resultPage.priceResults()), greaterThanOrEqualTo(225));
        assertThat(Helper.findMax(resultPage.priceResults()), lessThanOrEqualTo(300));
    }

    @Test
    public void testPriceMaxRange()
    {
        FundaSearchPage searchPage = open(FundaSearchPage.URL, FundaSearchPage.class);
        ResultPage resultPage = searchPage.search("Den Haag", "+ 0 km", "ˆ 2.000.000", "Geen maximum");
        assertThat(Helper.findMin(resultPage.priceResults()), greaterThanOrEqualTo(2000));
    }

    @Test
    public void testDistanceMaxRange()
    {
        FundaSearchPage searchPage = open(FundaSearchPage.URL, FundaSearchPage.class);
        ResultPage resultPage = searchPage.search("Den Haag", "+ 15 km", "ˆ 0", "ˆ 300.000");
        assertThat("Appartments are displayed only from Den Haag.",
            new HashSet(resultPage.cityResults()).size(),
            greaterThan(1));
    }

    @BeforeClass
    public static void setUp()
    {
        Configuration.browser = "chrome";
    }
}
