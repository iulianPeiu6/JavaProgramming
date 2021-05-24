package shellpackage;

import multimediamanagement.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellTest {

    private Shell shell;

    @BeforeEach
    @Test
    @DisplayName("Shell should run correctly!")
    public void shellRunTest(){

        shell = new Shell();

        shell.run();

    }
}