package com.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class notification {

    public void notification(Page page) throws InterruptedException {

        // String title = SharedData.title;
        // String message = SharedData.message;

            String title = posiv.generateRandomAlphaString(5, 8);
            String message = posiv.generateRandomAlphaString(5, 8);

        page.navigate("https://admin.posiv.org.uk/#/admin/send_notification");

        page.click("text='+ Send Notification'");

        page.locator("ng-select").getByRole(AriaRole.TEXTBOX).click();

        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("John Wilson - Supporter")).first().click();

        page.getByPlaceholder("Enter title").fill(title);
        page.getByPlaceholder("Enter message").fill(message);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send").setExact(true)).click();

        Thread.sleep(3000);
        System.out.println("Notification sent.");

        page.navigate("https://admin.posiv.org.uk/#/admin/send_notification");
        Thread.sleep(1000);

        if (page.content().contains(title) && page.content().contains(message)) {
            System.out.println("✅ 3 . Notification");
        } else {
            System.out.println("❌ 'Notification' Functionality may be broken.");
        }

    }

}
