package csv;

import java.util.List;

public class Country {
    private int id;
    private String code;
    private String name;
    private List<String> provinces;

    public Country() {
        super();
    }

    public Country(int id, String code, String name, List<String> provinces) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.provinces = provinces;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", code=" + code + ", name=" + name + ", provinces=" + provinces + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }
}
