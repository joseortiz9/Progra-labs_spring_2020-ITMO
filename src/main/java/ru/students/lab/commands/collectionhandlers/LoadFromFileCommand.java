package ru.students.lab.commands.collectionhandlers;

import ru.students.lab.commands.AbsCommand;
import ru.students.lab.commands.ExecutionContext;
import ru.students.lab.models.Dragon;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class LoadFromFileCommand extends AbsCommand {

    public LoadFromFileCommand() {
        commandKey = "load";
        description = "Add elements from a .xml file.\nSyntax: load <file>";
    }

    @Override
    public Object execute(ExecutionContext context) throws IOException {
        context.result().setLength(0);
        try {
            context.collectionManager().setCollection(context.fileManager().getCollectionFromFile(args[0]));
            context.result().append("All elems added to the collection!");
        } catch (JAXBException e) {
            context.result().append("Converter error adding the elems");
        } catch (InvalidPathException e) {
            context.result().append("Error finding the provided file");
        }
        return context.result().toString();
    }
}