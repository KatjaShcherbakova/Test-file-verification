package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FileUtils;
import utils.ZIPUtils;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileZIP {

    @Test
    @Story("ZIP file test")
    @DisplayName("Positive test, unzip file and search for the text in the TXT file")

    void successfulSearchTextInFileZIP() {

        String source = "src/test/resources/files/files.zip";
        String destination = "src/test/resources/files/unzip";


        String expectedFileText = "Check this file2";

        new ZIPUtils().unzip(source,destination);

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/unzip/file2.txt");

        System.out.println("Actual text from the file:\n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }

    @Test
    @Story("ZIP file test")
    @DisplayName("Negative test, unzip file and search for the text in the TXT file")

    void unSuccessfulSearchTextInFileZIP() {

        String source = "src/test/resources/files/files.zip";
        String destination = "src/test/resources/files/unzipNeg";


        String expectedFileText = "Check this file7";

        new ZIPUtils().unzip(source,destination);

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/file.txt");

        System.out.println("Actual text from the file:\n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }

    @Test
    @Story("ZIP file test")
    @DisplayName("Positive test, unzip file with PASSWORD  and search for the text in the TXT file")

    void unSuccessfulSearchTextInFileZIPWithPAssword() {

        String source = "src/test/resources/files/filesPas.zip";
        String destination = "src/test/resources/files/unzipPas";
        String password = "123";


        String expectedFileText = "Check this file2";

        new ZIPUtils().unzip(source,destination, password);

        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/unzipPas/file2.txt");

        System.out.println("Actual text from the file:\n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }

}
