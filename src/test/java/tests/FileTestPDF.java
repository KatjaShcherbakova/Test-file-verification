package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("Work with files")
@Tag("file")
@Tag("pdf")

public class FileTestPDF {

    @Story("Download the PDF file")
    @DisplayName("Positive test, download the PDF file")
    @Test
    void successfulFilePDF() throws IOException {
//        Configuration.reportsFolder = <desired location for downloaded files>; чтобы поменять путь скачанных файлов
        String expectedFileText = "Katj_FilesTests";

        String jenkinsLogin = "testuser";
        String jenkinsPassword = "testpassword%";

        open("https://jenkins.autotests.cloud/login");
        $(byName("j_username")).val(jenkinsLogin);
        $(byName("j_password")).val(jenkinsPassword).pressEnter();
        $(withText(jenkinsLogin)).shouldBe(Condition.visible);

        open("https://jenkins.autotests.cloud/view/QA.GURU%20students/job/Katja_FilesTests/ws/src/test/resources/files/");

        File actualFile = $("[href='KatjaJenkins_pdf.pdf']").download();

        PDF pdf = new PDF(actualFile);
        assertThat(pdf, PDF.containsText(expectedFileText));
    }

}
