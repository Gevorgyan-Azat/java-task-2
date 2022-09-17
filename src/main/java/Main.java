import java.io.File;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){
        TextAnalysis textAnalysis = new TextAnalysis();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла в формате \"файл.txt\"");
        String fileName = scanner.next();
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("Введите полный путь к файлу: ");
            String directory = scanner.next();
            file = new File(directory+fileName);
        }
        textAnalysis.readFile(file);


    }

}
