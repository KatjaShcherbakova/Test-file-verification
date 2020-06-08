package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.Assert.assertEquals;


@Feature("Work with files")
@Tag("file")
@Tag("txt")

public class FileTXT {

    @Story("Search for the text in the file")
    @DisplayName("Positive test, searching for the text in the file")

    @Test
    void successfulSearchTextInFile(){

        step("Test beginning");

        assertEquals (true, true);

    }


}
