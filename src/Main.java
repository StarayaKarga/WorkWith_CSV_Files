import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        getFolderSize(String.valueOf(sc.nextLine()));
//        getFileSizeKiloBytes(new File(String.valueOf(sc.nextLine())));
//        System.out.println("Размер папки составляет: "  + "ГБ");
    }

    public static void getFolderSize(String path) throws IOException {
        Path folder = Paths.get(path);
        System.out.println(Files.walk(folder).map(Path::toFile).filter(File::isFile).mapToLong(File::length).sum() + " байт");
        System.out.println(Files.walk(folder).map(Path::toFile).filter(File::isFile).mapToLong(file -> file.length() / 1000).reduce(0, (o1, o2) -> o1 + o2) + " Кбайт");
    }

    private static String getFileSizeKiloBytes(File folder) {
        return (double) folder.length() / 1024 + " kb";
    }

    private static void getFileSizeMegaBytes(File folder) {
        System.out.println((double) folder.length() / (1024 * 1024) + " mb");
    }
}