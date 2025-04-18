package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class contact_us {

  public void contact_us(Page page) throws InterruptedException {
    String firstname = SharedData.firstname;
    String lastname = SharedData.lastname;
    String subject = SharedData.subject;
    String description = SharedData.description;
    String email = SharedData.email;

    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      BrowserContext context = browser.newContext();
      
      // Fill Contact Us form on main website
      page.navigate("https://posiv.org.uk/");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Us")).click();

      page.getByPlaceholder("Enter your first name").fill(firstname);
      page.getByPlaceholder("Enter your last name").fill(lastname);
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your email")).fill(email);
      page.getByPlaceholder("Enter the subject").fill(subject);
      page.getByLabel("Description").fill(description);
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

      System.out.println("contact us details sent from website");

      Thread.sleep(2000);

      // Login to admin panel
      Page page2 = context.newPage();
      page2.navigate("https://admin.posiv.org.uk/#");
      page2.getByPlaceholder("Enter Email").fill("admin@posiv.com");
      page2.getByPlaceholder("Enter Password").fill("Admin@111");
      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

      Thread.sleep(2000);

      page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Contact Us")).click(); // redirects to contact us page
      Thread.sleep(3000);

      // searching details by page wise 

      int page3Num = 1;
      boolean found = false;

      while (true) {
        page2.waitForLoadState();
        String visibleText = page2.locator("body").first().innerText();  // Use page2 here

        System.out.println("🔍 Scanning page3 " + page3Num);

        if (visibleText.contains(firstname) &&
            visibleText.contains(lastname) &&
            visibleText.contains(email) &&
            visibleText.contains(subject) &&
            visibleText.contains(description)) {

          System.out.println("✅ Contact Us functionality is working fine."); // verify contact us details in admin which comes from website 
          found = true;
          break;
        }

        page3Num++;

        try {
          Locator nextButton = page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(String.valueOf(page3Num)).setExact(true));
          if (nextButton != null && nextButton.isVisible()) {
            nextButton.click();
            page2.waitForLoadState();
            Thread.sleep(1500);
          } else {
            break;
          }
        } catch (Exception e) {
          System.out.println("⚠️ Pagination failed: " + e.getMessage());
          break;
        }
      }

      if (!found) {
        System.out.println("❌ Contact Us functionality may be broken.");
      }

    }
  }
}
