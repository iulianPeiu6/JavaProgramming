package shellpackage;

import exceptions.CatalogException;
import exceptions.ShellException;
import mediaset.Book;
import multimediamanagement.Catalog;

import java.io.IOException;
import java.util.Scanner;

public class Shell {

    private Catalog catalog;

    public Shell() {
        this.catalog = new Catalog();
    }


    public void run(){

        while (true){
            System.out.print("Command: ");

            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();

            if (command.equals("quit"))
                break;

            try {
                handleCommand(command);
            } catch (CatalogException e) {
                e.printStackTrace();
            } catch (ShellException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleCommand(String command) throws CatalogException, ShellException {

        String[] commandDetails = command.split(" ");

        ICommand iCommand = null;

        if (commandDetails[0].equals("list"))
            iCommand = new ListCommand();

        else if (commandDetails[0].equals("save"))
            iCommand = new SaveCommand(commandDetails[1]);

        else if (commandDetails[0].equals("load"))
            iCommand = new LoadCommand(commandDetails[1]);

        else if (commandDetails[0].equals("play"))
            iCommand = new PlayCommand(Integer.parseInt(commandDetails[1]));
        else
            throw new ShellException("Invalid command");

        try {
            iCommand.run(catalog);
        } catch (IOException exp) {
            throw new CatalogException(exp);
        }

    }
}
