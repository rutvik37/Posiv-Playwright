package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class admin {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("http://13.233.19.205/hbl/admin/#/");

            page.getByPlaceholder("Enter Email").fill("admin@gmail.com");
            page.getByPlaceholder("Enter Password").fill("Admin@1234");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click(); // login

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click(); // dashboard click

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Levels")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
            page.getByPlaceholder("Enter Name").fill("level I");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add").setExact(true)).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go to Subjects")).click(); // redirects to subject

        
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }

            // page.getByRole(AriaRole.LINK, new
            // Page.GetByRoleOptions().setName("Levels")).click();

            // page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("level
            // A")).getByRole(AriaRole.BUTTON)
            // .first().click();
            // page.getByPlaceholder("Enter Name").fill("level Ae");
            // page.getByRole(AriaRole.BUTTON, new
            // Page.GetByRoleOptions().setName("Edit")).click(); // level-EDIT
            // try {
            // Thread.sleep(2000);
            // } catch (Exception e) {

            // }

            // page.getByRole(AriaRole.LINK, new
            // Page.GetByRoleOptions().setName("Dashboard")).click(); // dashboard click

            // page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("level
            // Ae")).getByRole(AriaRole.BUTTON)
            // .nth(1).click();

            // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes,
            // delete it!")).click();
            // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes,
            // delete it!")).click(); // level-DELETE
            // try {
            // Thread.sleep(2000);
            // } catch (Exception e) {

            // }

            playwright.close();
            browser.close();

        }

    }
}