package com.example;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.util.Random;

public class notification {

    String title = generateRandomAlphaString(6, 9);
    String message = generateRandomAlphaString(6, 9);


    public void notification(Page page) throws InterruptedException {

        page.navigate("https://admin.posiv.org.uk/#/admin/send_notification");

            page.click("text='+ Send Notification'"); 

      page.locator("ng-select").getByRole(AriaRole.TEXTBOX).click();
      
      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Rutvik Jasani - Supporter")).first().click();
    
      page.getByPlaceholder("Enter title").fill(""+title);
    
      page.getByPlaceholder("Enter message").fill(""+message);
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send").setExact(true)).click();

            Thread.sleep(3000);
            System.out.println("Notification sent.");
     page.navigate("https://admin.posiv.org.uk/#/admin/send_notification");
     Thread.sleep(1000);
    
            if (page.content().contains(title) && page.content().contains(message)) {
                System.out.println("✅ 'Notification' Functionality is working fine.");
              } else {
                System.out.println("❌ 'Notification'Functionality may be broken.");
              }

        }
        public static String generateRandomAlphaString(int minLen, int maxLen) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            Random random = new Random();
            int length = random.nextInt(maxLen - minLen + 1) + minLen;
        
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
              sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            return sb.toString();
    }
    }
