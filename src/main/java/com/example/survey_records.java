package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class survey_records 
{

public void survey_records ( Page page) throws InterruptedException {


    String email4 = SharedData.email4;
    String email5 = SharedData.email5;

      page.navigate("https://posiv.org.uk/");

      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Complete Survey Form")).click(); // supporters

    
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your email")).fill(""+email4);
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("A Yes")).check(); Thread.sleep(2000); 
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("B No")).check();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("A Yes")).check();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("B No")).check(); 
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
      System.out.println("'Supporters Survey' details sent");   Thread.sleep(2000); 
        
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Professional Survey")).click(); // directories

      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your email")).fill(""+email5);
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("A Yes")).check(); Thread.sleep(2000); 
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("£1000")).check();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("A Yes")).check(); 
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();  
      System.out.println("'Professional Survey' details sent");   Thread.sleep(2000); 

            try (Playwright playwright = Playwright.create()) {
              Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context = browser.newContext();
            Page adminpage2 = context.newPage(); 
      
            adminpage2.navigate("https://admin.posiv.org.uk/#");

            adminpage2.getByPlaceholder("Enter Email").fill("admin@posiv.com");
            adminpage2.getByPlaceholder("Enter Password").fill("Admin@111");
            adminpage2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

            Thread.sleep(2000);

            adminpage2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Survey Records")).click(); Thread.sleep(2000);

        boolean isSupportersSurveyCorrect = false;
        boolean isProfessionalSurveyCorrect = false;

if (adminpage2.content().contains(email4)) {
    System.out.println("'Supporters Survey' details found");
    isSupportersSurveyCorrect = true;
} else {
    System.out.println("❌ Supporters Survey details Not found");
}

adminpage2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Survey Records")).click(); 
Thread.sleep(1000);

adminpage2.getByLabel("Filter by:").selectOption("Directories");
Thread.sleep(2000);

if (adminpage2.content().contains(email5)) {
    System.out.println("'Professional Survey' details found");
    isProfessionalSurveyCorrect = true;
} else {
    System.out.println("❌ Professional Survey details Not found");
}

if (isSupportersSurveyCorrect && isProfessionalSurveyCorrect) {
    System.out.println("✅ 6 . Survey_records");
}


    }
  }
}

