package githubtest21;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSoft {

    @Test
    void testSoftAssertions () {
        open("https://github.com/selenide/selenide");
        $("ul.UnderlineNav-body a#wiki-tab").click();
        $(".f6.Link--muted.js-wiki-more-pages-link.btn-link.mx-auto").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions"));
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0).shouldHave(text("""
                     
                     @ExtendWith({SoftAssertsExtension.class})
                     class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                    }
                """));
    }

}
