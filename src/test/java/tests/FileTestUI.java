package tests;

        import com.codeborne.selenide.Condition;
        import io.qameta.allure.Epic;
        import io.qameta.allure.Feature;
        import io.qameta.allure.Story;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Tag;
        import org.junit.jupiter.api.Test;
        import utils.FileUtils;

        import java.io.File;
        import java.io.FileNotFoundException;

        import static com.codeborne.selenide.Selectors.byName;
        import static com.codeborne.selenide.Selectors.withText;
        import static com.codeborne.selenide.Selenide.$;
        import static com.codeborne.selenide.Selenide.open;
        import static org.hamcrest.CoreMatchers.containsString;
        import static org.hamcrest.MatcherAssert.assertThat;


        @Feature("Work with files")
        @Tag("file")
        @Tag("UI")

        class FileTestUI {
          @Story("File download")
          @DisplayName("Successful file download")
          @Test


            void successfulDownloadFile() throws FileNotFoundException {
//        Configuration.reportsFolder = <desired location for downloaded files>; чтобы поменять путь скачанных файлов
            String expectedFileText = "Check this file";

            String jenkinsLogin = "testuser";
            String jenkinsPassword = "testpassword%";

            open("https://jenkins.autotests.cloud/login");
            $(byName("j_username")).val(jenkinsLogin);
            $(byName("j_password")).val(jenkinsPassword).pressEnter();
            $(withText(jenkinsLogin)).shouldBe(Condition.visible);

            open("https://jenkins.autotests.cloud/view/QA.GURU%20students/job/Katja_FilesTests/ws/src/test/resources/files/");

            File actualFile = $("[href='file.txt']").download();


            String actualFileText = new FileUtils().readStringFromFile(actualFile.getPath());
            System.out.println("Actual text from file: \n" + actualFileText);

            assertThat(actualFileText, containsString(expectedFileText));


        }

        }