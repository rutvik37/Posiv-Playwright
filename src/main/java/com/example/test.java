package main.java.com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class test {

    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://posiv.org.uk/");

            page.getByRole(AriaRole.NAVIGATION)
                    .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Join waitlist")).click();

            page.getByPlaceholder("Enter your name").fill("test name 2");
            page.getByLabel("Email address").fill("testemail55@gmail.com");
            page.getByPlaceholder("Enter your contact number").fill("8200124611");
            page.getByLabel("Share your Message").fill("test 2'share your message' .");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

            System.out.println("join waitlist details ('Supporters') sent suceessfully");
            Thread.sleep(2000);

            page.getByRole(AriaRole.NAVIGATION)
                    .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Join waitlist")).click();

            page.getByLabel("Role").selectOption("directories");
            page.getByPlaceholder("Enter your name").fill("test name 2");
            page.getByLabel("Email address").fill("testemai56@gmail.com");
            page.getByPlaceholder("Enter your contact number").fill("8200124611");
            page.getByLabel("Share your Message").fill("test 2'share your message' .");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

            System.out.println("join waitlist details ('Directories') sent suceessfully");
            Thread.sleep(2000);

        }
    }
}
