package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.FileUtils;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Feature("Work with files")
@Tag("file")
@Tag("txt")

public class FileTXT {


    @Test
    @Story("TXT file test")
    @DisplayName("Positive test, searching for the text in the TXT file")

    void successfulSearchTextInFileTXT(){
        String expectedFileText = "Check this file7";
        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/file.txt");

        System.out.println("Actual text from the file:\n"+actualFileText);

        assertThat(actualFileText,containsString(expectedFileText));

//        assertTrue(actualFileText.contains(expectedFileText),"\n\nExpected text: \n"+ expectedFileText + "\n\n"
//                +"Actual text: \n"+ actualFileText);

    }



}
