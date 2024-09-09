// Main.java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Vacuum Cleaner", "Appliances", 200.0)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Продукты, сгруппированные по категориям: ");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Результат: " + result);

        String maxCategory = "";
        double maxAvgPrice = 0.0;
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            if (entry.getValue() > maxAvgPrice) {
                maxCategory = entry.getKey();
                maxAvgPrice = entry.getValue();
            }
        }

        System.out.println("Категория с самой высокой средней ценой: " + maxCategory + " = " + maxAvgPrice);
    }
}
