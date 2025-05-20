import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;

public class NetworkCSVReader {
    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        String targetDate = "01.01.2023";
        double sum = 0;
        int count = 0;

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length > 1 && parts[0].startsWith(targetDate)) {
                    String tempStr = parts[1].replace(",", "."); // Convert comma to dot
                    try {
                        double temp = Double.parseDouble(tempStr);
                        sum += temp;
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid number: " + tempStr);
                    }
                }
            }
            reader.close();

            if (count > 0) {
                double avg = sum / count;
                System.out.printf("Average 'UlkoTalo' temperature on %s: %.2f°C\n", targetDate, avg);
            } else {
                System.out.println("No data found for " + targetDate);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV from network: " + e.getMessage());
        }
    }
}
