package search;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import utilities.CommonOps;
import utilities.ManageDDT;
import utilities.TestListener;
import workFlows.SearchWorkFlows;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
@Listeners({TestListener.class})
public class SearchTest extends CommonOps{

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify search process")
    @Test(
            dataProvider = "searchData",
            dataProviderClass = ManageDDT.class,
            description = "Test search process"
    )
    public void test01_search(String term){
        SearchWorkFlows.searchTerm(term);
        SearchWorkFlows.verifyPlpResult(term);
        SearchWorkFlows.verifyPlpCountResults(1);
        SearchWorkFlows.verifyFirstResultName(term);
    }
}
