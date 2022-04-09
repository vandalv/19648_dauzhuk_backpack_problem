
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CSVReaderInJava {
    public static void main(String... args) {
        List<Backpack> backpackOfBackpacks = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            List<Item> items = readBooksFromCSV("C:\\Idea_Projects\\Backpack_Problem\\src\\backpack_problem.csv");
            items.remove(0);
            Backpack randomSolution = new Backpack(10000);
            Random randomGenerator = new Random();
            int index;
            Item item;
            while(!items.isEmpty()){
                index = randomGenerator.nextInt(items.size());
                item = items.get(index);
                if((randomSolution.getWeightCapacity() - Integer.parseInt(item.getWeight())) > 0){
                    randomSolution.items.add(item);
                    items.remove(index);
                    randomSolution.setWeightCapacity(randomSolution.getWeightCapacity() - Integer.parseInt(item.getWeight()));
                    randomSolution.setOverallPrice(randomSolution.getOverallPrice() + Integer.parseInt(item.getPrice()));
                }else{
                    items.remove(index);
                }
            }
            backpackOfBackpacks.add(randomSolution);
        }
        Collections.sort(backpackOfBackpacks);
        System.out.println("\u001b[37m" + backpackOfBackpacks.toString());
//------------------------------------------------------------------------------//
        for(int j = 0; j < 100000; j++) {
        int HMCR = 70;
        Random randomPercents = new Random();
        int result = randomPercents.nextInt(101);
        if(result < HMCR){
            List<Item> items = readBooksFromCSV("C:\\Idea_Projects\\Backpack_Problem\\src\\backpack_problem.csv");
            items.remove(0);
            Backpack randomSolution = new Backpack(10000);
            Random randomGenerator = new Random();
            int index;
            Item item;
            while(!items.isEmpty()){
                index = randomGenerator.nextInt(items.size());
                item = items.get(index);
                if((randomSolution.getWeightCapacity() - Integer.parseInt(item.getWeight())) > 0){
                    randomSolution.items.add(item);
                    items.remove(index);
                    randomSolution.setWeightCapacity(randomSolution.getWeightCapacity() - Integer.parseInt(item.getWeight()));
                    randomSolution.setOverallPrice(randomSolution.getOverallPrice() + Integer.parseInt(item.getPrice()));
                }else{
                    items.remove(index);
                }
            }
            System.out.println(randomSolution);
            for (int i = 0; i < 10; i++) {
                if (backpackOfBackpacks.get(i).getOverallPrice() < randomSolution.getOverallPrice()) {
                    System.out.println("\u001B[31m" +"I will add this");
                    System.out.print("\u001b[37m");
                    backpackOfBackpacks.remove(i);
                    backpackOfBackpacks.add(randomSolution);
                    break;
                }
            }
            //Collections.sort(backpackOfBackpacks);
            System.out.println(backpackOfBackpacks.toString());
        }
        else{
            System.out.println("HMCR - " + result);
            Backpack randomSolutionn = new Backpack(10000);
            List<Item> items = readBooksFromCSV("C:\\Idea_Projects\\Backpack_Problem\\src\\backpack_problem.csv");
           for(int i = 0; i < 20; i++){
               Random r = new Random();
               int number = r.nextInt(10);
               randomSolutionn.setOverallPrice(randomSolutionn.getOverallPrice() + Integer.parseInt(backpackOfBackpacks.get(number).items.get(i).getPrice()));
               randomSolutionn.setWeightCapacity(randomSolutionn.getWeightCapacity() - Integer.parseInt(backpackOfBackpacks.get(number).items.get(i).getWeight()));
           }

            System.out.println(randomSolutionn.getOverallPrice());
            System.out.println(randomSolutionn.getWeightCapacity());
            for (int i = 0; i < 10; i++) {
                if (backpackOfBackpacks.get(i).getOverallPrice() < randomSolutionn.getOverallPrice()) {
                    System.out.println("\u001B[31m" +"I will add this");
                    System.out.print("\u001b[37m");
                    backpackOfBackpacks.remove(i);
                    backpackOfBackpacks.add(randomSolutionn);
                    break;
                }
            }
            Collections.sort(backpackOfBackpacks);
            System.out.println(backpackOfBackpacks.toString());
        }
        }

    }
    private static List<Item> readBooksFromCSV(String fileName) {
        List<Item> items = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Item item = createBook(attributes);
                items.add(item);
                line = br.readLine();
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return items;
    }
    private static Item createBook(String[] metadata) {
        String name = metadata[0];
        String price = metadata[1];
        String weight = metadata[2];
        return new Item(name, price, weight);
    }


}
