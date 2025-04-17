package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.concurrent.ExecutionException;

public class test {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();


      page.navigate("https://posiv.org.uk/");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Us")).click();
      // page.getByPlaceholder("Enter your first name").click();
      page.getByPlaceholder("Enter your first name").fill("a1");
      // page.getByPlaceholder("Enter your last name").click();
      page.getByPlaceholder("Enter your last name").fill("ab1");
      // page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your email")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your email")).fill("abcd@gmail.com");
      // page.getByPlaceholder("Enter the subject").click();
      page.getByPlaceholder("Enter the subject").fill("subject er");
      // page.getByLabel("Description").click();
      page.getByLabel("Description").fill("dses vc");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

      try {
        Thread.sleep(2000);
      } catch (Exception e) {
            
      }
      
      page.navigate("https://admin.posiv.org.uk/#");
            
      page.getByPlaceholder("Enter Email").fill("admin@posiv.com");
      page.getByPlaceholder("Enter Password").fill("Admin@111");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

       try {
        Thread.sleep(2000);
      } catch (Exception e) {
        
      }

      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Contact Us")).click();
      
      Thread.sleep(3000);

      String email = "abcd@gmail.com";
      

int pageNum = 1;

while (true) {
    page.waitForLoadState();

    String content = page.content();

    if (content.contains(email) /*&& content.contains(y) && content.contains(m) && content.contains(n)*/) {
        System.out.println("✅ Contact Us functionality is working fine 1.");
      boolean found = true;
        break;
    }

    pageNum++;
    Locator nextPageButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(String.valueOf(pageNum)).setExact(true));

    if (nextPageButton.isVisible()) {
        nextPageButton.click();
        page.waitForLoadState();
    } else {
      
    {
      System.out.println("Wrong");
    }
        break;
    }
}

    }
  }
  }
