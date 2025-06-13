// main - file 
// contains all modules - dashboard, profile, notification, contact us, join waitlist, survey records ...

package com.example;

import java.util.Random;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class posiv { // main - posiv class

    public static void main(String[] args) {  

        SharedData.title = generateRandomAlphaString(6, 9);
        SharedData.message = generateRandomAlphaString(6, 9);
        SharedData.firstname = generateRandomAlphaString(4, 5);
        SharedData.lastname = generateRandomAlphaString(4, 5);
        SharedData.subject = generateRandomAlphaString(6, 9);
        SharedData.description = generateRandomAlphaString(10, 20);
        SharedData.email = generateRandomEmail();

        SharedData.name = generateRandomAlphaString(4, 6);
        SharedData.phone = String.valueOf(1000000000L + (long)(Math.random() * 9000000000L));
        SharedData.email2 = generateRandomEmail();
        SharedData.message2 = generateRandomAlphaString(6, 9);

        SharedData.name2 = generateRandomAlphaString(4, 6);
        SharedData.phone2 = String.valueOf(1000000000L + (long)(Math.random() * 9000000000L));
        SharedData.email3 = generateRandomEmail();
        SharedData.message3 = generateRandomAlphaString(6, 9);

        SharedData.email4 = generateRandomEmail();
        SharedData.email5 = generateRandomEmail();

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            

            page.navigate("https://admin.posiv.org.uk/#");

            page.getByPlaceholder("Enter Email").fill("admin@posiv.com");
            page.getByPlaceholder("Enter Password").fill("Admin@111");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();  // login admin panel 

            System.out.println("DONE");

            Thread.sleep(2000);

            // dashboard dashboard = new dashboard();
            // dashboard.dashboard(page); // 1

            // profile profile = new profile();
            // profile.profile(page); // 2

            // notification notification = new notification();
            // notification.notification(page); // 3

            // contact_us contact_us = new contact_us();
            // contact_us.contact_us(page); // 4

            // join_waitlist join_waitlist = new join_waitlist();
            // join_waitlist.join_waitlist();  // 5

            // survey_records survey_records = new survey_records();
            // survey_records.survey_records(page); // 6

            // test test = new test();
            // test.test(page);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomAlphaString(int minLen, int maxLen) {   // generate random valid string function 
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int length = random.nextInt(maxLen - minLen + 1) + minLen;

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {  // generate random valid email function
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        Random random = new Random();


        int nameLength = random.nextInt(5) + 5;
        int domainLength = random.nextInt(5) + 3;

        StringBuilder namePart = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            namePart.append(alphabet.charAt(random.nextInt(alphabet.length())));
            if (random.nextBoolean())
                namePart.append(digits.charAt(random.nextInt(digits.length())));
        }

        StringBuilder domainPart = new StringBuilder();
        for (int i = 0; i < domainLength; i++) {
            domainPart.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        String[] tlds = { "com", "net", "org", "io", "co.uk" };
        String tld = tlds[random.nextInt(tlds.length)];

        return namePart.toString() + "@" + domainPart.toString() + "." + tld;
    }

}
