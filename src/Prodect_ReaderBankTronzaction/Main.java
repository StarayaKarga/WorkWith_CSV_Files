package Prodect_ReaderBankTronzaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        CVSParser cvsParser = new CVSParser();

        List<String> lines = Files.readAllLines(Paths.get("res/movementList.csv"));
        for (int i = 1; i < lines.size(); i++) {
            cvsParser.CalculateData(lines.get(i));
        }

        cvsParser.printData();
    }
}
