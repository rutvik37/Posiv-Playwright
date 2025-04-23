package com.example;
   
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class join_waitlist {

   public void join_waitlist(Page page) throws InterruptedException {

        String name = SharedData.name;
        String email2 = SharedData.email2;
        String phone = SharedData.phone;
        String message2 = SharedData.message2; // supporters details random

        String name2 = SharedData.name;
        String email3 = SharedData.email3;
        String phone2 = SharedData.phone2;
        String message3 = SharedData.message3; // directories details random


            page.navigate("https://posiv.org.uk/");

            page.getByRole(AriaRole.NAVIGATION).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Join waitlist")).click();

            page.getByPlaceholder("Enter your name").fill(""+name);
            page.getByLabel("Email address").fill(""+email2);
            page.getByPlaceholder("Enter your contact number").fill(""+phone);
            page.getByLabel("Share your Message").fill(""+message2);                    Thread.sleep(2000);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();   

            System.out.println("join waitlist details ('Supporters') sent suceessfully");
            Thread.sleep(2000);

            page.getByRole(AriaRole.NAVIGATION).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Join waitlist")).click();

            page.getByLabel("Role").selectOption("directories");

            page.getByPlaceholder("Enter your name").fill(""+name2);
            page.getByLabel("Email address").fill(""+email3);
            page.getByPlaceholder("Enter your contact number").fill(""+phone2);
            page.getByLabel("Share your Message").fill(""+message3);     Thread.sleep(2000);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

            System.out.println("join waitlist details ('Directories') sent suceessfully");
            Thread.sleep(2000);

            try (Playwright playwright = Playwright.create()) {
              Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context = browser.newContext();
            Page adminPage = context.newPage(); 

            adminPage.navigate("https://admin.posiv.org.uk/#"); // redirects to admin panel

            adminPage.getByPlaceholder("Enter Email").fill("admin@posiv.com");
            adminPage.getByPlaceholder("Enter Password").fill("Admin@111");
            adminPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
            Thread.sleep(2000); 


            adminPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Joining Waitlist")).click();
            Thread.sleep(2000);

            int page3Num = 1;
            boolean found = false;
      
            while (true) {
              adminPage.waitForLoadState();
              String visibleText = adminPage.locator("body").first().innerText();  
      
              if (visibleText.contains(name) &&
                  visibleText.contains(email2) &&
                  visibleText.contains(phone) &&
                  visibleText.contains(message2)
            ) {
      
                System.out.println("Join waitlist ( Supporters ) details Found"); // verify details in admin which comes from website 
                found = true;
                break;
              }

              page3Num++;
      
              try {
                
                Locator nextButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(String.valueOf(page3Num)) );

                if (nextButton != null && nextButton.isVisible()) {
                  nextButton.click();
                  adminPage.waitForLoadState();
                  Thread.sleep(1500);
                } else {
                  break;
                }
              } catch (Exception e) {
                
                break;
              }
            }
      
            if (!found) {
              System.out.println("❌ Join waitlist ( Supporters ) functionality may be broken.");
            } 

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
                      visibleText.contains(message3)
                ) {
          
                    System.out.println("Join waitlist ( Directories ) details Not Found"); // verify details in admin which comes from website 
                    found1 = true;
                    break;
                  }
    
                  page3n1++;
          
                  try {
                    
                    Locator nextButton = page.getByRole( AriaRole.BUTTON, new Page.GetByRoleOptions().setName(String.valueOf(page3n1)) );
    
                    if (nextButton != null && nextButton.isVisible()) {
                      nextButton.click();
                      page.waitForLoadState();
                      Thread.sleep(1500);
                    } else {
                      break;
                    }
                  } catch (Exception e) {
                    
                    break;
                  }
                }
          
                if (!found1) {
                  System.out.println("❌ Join waitlist ( Directories ) functionality may be broken.");
                } 

                if (found && found1) {
                  System.out.println("✅ 5 . Join waitlist");
                }


     }
    
}
}






