package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadCsv {
    private static final String COMMA_DELIMITER = ","; // Chia bằng dấu phẩy

    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("data/countries.csv"));

            String line;
            // Đọc tệp trong java từng dòng
            while ((line = br.readLine()) != null) {
                Country country = parseCsvLine(line);
                if (country != null) {
                    printCountry(country);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại. Hãy kiểm tra đường dẫn hoặc tạo mới file nếu cần.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Country parseCsvLine(String csvLine) {
        Country country = null;
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            if (splitData.length >= 4) {
                int id = Integer.parseInt(splitData[0]);
                String code = splitData[1];
                String name = splitData[2];

                List<String> provinces = new ArrayList<>();
                for (int i = 4; i < splitData.length; i++) {
                    provinces.add(splitData[i]);
                }

                country = new Country(id, code, name, provinces);
            }
        }
        return country;
    }


    private static void printCountry(Country country) {
        System.out.println(
                "Country [id= "
                        + country.getId()
                        + ", code= " + country.getCode()
                        + " , name=" + country.getName()
                        + ", provinces=" + country.getProvinces()
                        + "]");
    }

}
