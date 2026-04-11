package com.project.utils;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "InterviewTest")
    public String[][] interviewdata() {
//        String logindata[][] = {{"user1" , "pwd1"}};
//        return logindata;
        return new String[][]{{"user1", "pwd1"},
                {"user2" , "pwd2"}};


    }
}
