package shellpackage;

import multimediamanagement.Catalog;

import java.io.IOException;

public class SaveCommand implements ICommand{

    private String saveToFile;

    public SaveCommand(String saveToFile) {
        this.saveToFile = saveToFile;
    }

    @Override
    public void run(Catalog catalog) throws IOException {
        catalog.save(saveToFile);
    }
}
