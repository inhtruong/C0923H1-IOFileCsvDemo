package csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteCsv {
    // Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // Tiêu đề file CSV
    private static final String FILE_HEADER = "id,code,name";

    public static void main(String[] args) {

        String fileName = "data/countries.csv";
        writeCsvFile(fileName);
    }

    public static void writeCsvFile(String fileName) {
        // Tạo mới đối tượng Country
        Country country1 = new Country(1, "US", "United States", Arrays.asList("California", "New York", "Texas"));
        Country country2 = new Country(2, "VN", "Viet Nam", Arrays.asList("Hanoi", "Ho Chi Minh City", "Da Nang"));
        Country country3 = new Country(3, "AU", "Australia", Arrays.asList("New South Wales", "Queensland", "Victoria"));

        // Tạo mới đối tượng List Country
        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        FileWriter fileWriter = null;

        try {
            // Kiểm tra nếu file không tồn tại, thì tạo mới file
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(fileName);

            // Viết tiêu đề file CSV
            fileWriter.append(FILE_HEADER);

            // Thêm dấu phân cách dòng mới sau tiêu đề
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Viết danh sách đối tượng Quốc gia mới vào tệp CSV
            for (Country country : countries) {
                fileWriter.append(String.valueOf(country.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getCode());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getName());
                fileWriter.append(COMMA_DELIMITER);

                // Ghi danh sách tỉnh/thành phố
                List<String> provinces = country.getProvinces();
                if (provinces != null && !provinces.isEmpty()) {
                    fileWriter.append(String.join(", ", provinces));
                }
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("Tệp CSV đã được tạo thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi trong CsvFileWriter!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi xóa/đóng fileWriter!");
                e.printStackTrace();
            }
        }
    }
}
