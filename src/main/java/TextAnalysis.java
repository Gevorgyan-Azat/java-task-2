import java.io.*;
import java.util.*;

public class TextAnalysis {

    public void readFile (File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String[] stringArr;
            String str = reader.readLine();
            ArrayList<String> list = new ArrayList<>();
            SortedSet<String> uniqueText = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            while (str != null) {
                stringArr = str.split("[^a-zA-Zа-яА-Я]+");
                for (String s: stringArr){
                    if (!s.isEmpty()) {
                        list.add(s);
                        uniqueText.add(s);
                    }
                }
                str = reader.readLine();
            }
            list.sort(String.CASE_INSENSITIVE_ORDER);
            System.out.println(uniqueText);
            this.stat(list, uniqueText);

        } catch (Exception e) {
            System.err.println("Неверный путь");
            e.printStackTrace();
        }
    }
    private void stat (ArrayList<String> list, SortedSet<String> uniqueText){
        double maxCount = 0;
        String maxWord = "";

        System.out.println("Всего слов: " + list.size() + ".\nУникальных слов: " + uniqueText.size());
        for (String s: uniqueText){
            double x = 0;
            for(String f: list){
                if(f.equalsIgnoreCase(s)){
                    x++;
                }
            }
            if (x > maxCount){
                maxCount = x;
                maxWord ="\"" + s + "\"";
            }else if(x == maxCount) {
                maxWord += " и " + "\"" + s + "\"";
            }

            System.out.println(s + " ["+ x + " раз/" + String.format("%.2g", (x / list.size()) * 100) + " %]");
        }
        System.out.println("Максимально встречающееся слово: " + maxWord + " ["+ maxCount + " раз/" + String.format("%.2g", (maxCount / list.size()) * 100) + " %]");
    }

}
