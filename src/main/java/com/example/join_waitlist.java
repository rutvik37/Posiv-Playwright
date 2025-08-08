package com.example;

import com.microsoft.playwright.*;

import com.microsoft.playwright.options.AriaRole;

public class join_waitlist {

  public void join_waitlist() throws InterruptedException {

    // Playwright should be started once, at the top
    try (Playwright playwright = Playwright.create()) {

      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();

       String name = posiv.generateRandomAlphaString(4, 6);
        String phone = String.valueOf(1000000000L + (long)(Math.random() * 9000000000L));
        String email2 = posiv.generateRandomEmail();
        String message2 = posiv.generateRandomAlphaString(6, 9);

        String name2 = posiv.generateRandomAlphaString(4, 6);
        String phone2 = String.valueOf(1000000000L + (long)(Math.random() * 9000000000L));
        String email3 = posiv.generateRandomEmail();
        String message3 = posiv.generateRandomAlphaString(6, 9);

      // ======= Step 1: Fill Supporters Form ========
      page.navigate("https://posiv.org.uk/");
      Thread.sleep(3000);

      page.locator("section").filter(new Locator.FilterOptions().setHasText("Transform Your Mind,")).getByRole(AriaRole.BUTTON).click();
      page.getByPlaceholder("Enter your name").fill(name);
      page.getByLabel("Email address").fill(email2);
      page.getByPlaceholder("Enter your contact number").fill(phone);
      page.getByLabel("Share your Message").fill(message2);
      Thread.sleep(2000);
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
      System.out.println("Supporters form submitted.");
      Thread.sleep(3000);

      // ======= Step 2: Fill Directories Form ========
      // page.getByRole(AriaRole.NAVIGATION).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Join waitlist")).click();
      page.locator("section").filter(new Locator.FilterOptions().setHasText("Transform Your Mind,")).getByRole(AriaRole.BUTTON).click();
      page.getByLabel("Role").selectOption("directories");
      page.getByPlaceholder("Enter your name").fill(name2);
      page.getByLabel("Email address").fill(email3);
      page.getByPlaceholder("Enter your contact number").fill(phone2);
      page.getByLabel("Share your Message").fill(message3);
      Thread.sleep(2000);
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
      System.out.println("Directories form submitted.");
      Thread.sleep(3000);

      // ======= Step 3: Admin Panel Verification ========
      Page adminPage = context.newPage();
      adminPage.navigate("https://admin.posiv.org.uk/#");
      adminPage.getByPlaceholder("Enter Email").fill("admin@posiv.com");
      adminPage.getByPlaceholder("Enter Password").fill("Admin@111");
      adminPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
      Thread.sleep(3000);

      adminPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Joining Waitlist")).click();
      Thread.sleep(2000);

      // ------- Check Supporters Data -------
      int page3Num = 1;
      boolean found = false;

      while (true) {
        adminPage.waitForLoadState();
        String visibleText = adminPage.locator("body").first().innerText();

        if (visibleText.contains(name) &&
            visibleText.contains(email2) &&
            visibleText.contains(phone) &&
            visibleText.contains(message2)) {

          System.out.println("Supporters data found in admin panel.");
          found = true;
          break;
        }

        page3Num++;
        try {
          Locator nextButton = adminPage.getByRole(AriaRole.BUTTON,
              new Page.GetByRoleOptions().setName(String.valueOf(page3Num)));

          if (nextButton.isVisible()) {
            nextButton.click();
            Thread.sleep(1500);
          } else {
            break;
          }
        } catch (Exception e) {
          break;
        }
      }

      if (!found) {
        System.out.println("❌ Supporters data not found in admin.");
      }

      // ------- Check Directories Data -------
      adminPage.getByLabel("Filter by:").selectOption("Directories");
      Thread.sleep(2000);

      int page3n1 = 1;
      boolean found1 = false;

      while (true) {
        adminPage.waitForLoadState();
        String visibleText = adminPage.locator("body").first().innerText();

        if (visibleText.contains(name2) &&
            visibleText.contains(email3) &&
            visibleText.contains(phone2) &&
            visibleText.contains(message3)) {

          System.out.println("Directories data found in admin panel.");
          found1 = true;
          break;
        }

        page3n1++;
        try {
          Locator nextButton = adminPage.getByRole(AriaRole.BUTTON,
              new Page.GetByRoleOptions().setName(String.valueOf(page3n1)));

          if (nextButton.isVisible()) {
            nextButton.click();
            Thread.sleep(1500);
          } else {
            break;
          }
        } catch (Exception e) {
          break;
        }
      }

      if (!found1) {
        System.out.println("❌ Directories data not found in admin.");
      }

      if (found && found1) {
        System.out.println("✅ 5 . Join_waitlist");
      }

    } 
  } 
}
