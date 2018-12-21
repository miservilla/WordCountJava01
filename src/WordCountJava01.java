import java.io.File;
import java.util.*;

public class WordCountJava01 {


        public static void main(String[] args) {

            SortedMap<String, Integer> wordCount = new TreeMap<>();

            int count;

            try {

                System.out.println("Enter the file name with the extension: ");

                Scanner reader = new Scanner(System.in);

                File file = new File(reader.nextLine());

                reader = new Scanner(file);


                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] allWords = line.split("\\W+");
                    for (String word:allWords) {
                        if (!wordCount.containsKey(word)) {
                            wordCount.put(word, 1);
                        } else {
                            count = wordCount.get(word);
                            wordCount.put(word, count + 1);
                        }

                    }
                }
                reader.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


            Set s = wordCount.entrySet();

            Iterator i = s.iterator();

            int num = 0;

            while (i.hasNext()) {
                Map.Entry m = (Map.Entry)i.next();

                String key = (String)m.getKey();
                int value = (Integer)m.getValue();
                num++;

                System.out.printf("%02d" + ". " + key + " " + value + "\n", num);
            }
        }
    }

