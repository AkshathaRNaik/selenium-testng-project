package com.project.tests;

import com.project.base.baseTest;
import com.project.pages.FileUploadDownloadPage;
import org.testng.annotations.Test;

import java.awt.*;

public class FileUploadDownloadTest extends baseTest {

    @Test
    public void fileUploadDownload() throws InterruptedException, AWTException {
        FileUploadDownloadPage fileUploadDownloadPage = new FileUploadDownloadPage(driver);
//        fileUploadDownloadPage.uploadFileSendkeys();
        fileUploadDownloadPage.uploadFileRobot();
    }
}
