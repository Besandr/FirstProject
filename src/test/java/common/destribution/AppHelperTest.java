package common.destribution;

import org.junit.Before;
import org.junit.Test;
import utils.IOHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AppHelperTest {

    private AppHelper appHelper;

    @Before
    public void init(){
        appHelper = new AppHelper();
    }

    @Test
    public void languageChoosingShouldReturnEnglish() {

        ByteArrayInputStream bais = new ByteArrayInputStream("qw\n8\n3".getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        IOHelper ioHelper = new IOHelper(bais, new PrintStream(baos));

        Languages receivedLanguage = appHelper.languageChoosing(ioHelper);

        assertEquals("Language must be English", Languages.ENGLISH, receivedLanguage);
    }
}