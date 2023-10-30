package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity;

import java.io.Serializable;
import java.util.List;

public class Nation implements Serializable {
    private Integer id;

    private String nationcode;

    private String nationname;

    private Province province;

    private List<County> counties;

    public List<County> getCounties() {
        return counties;
    }

    public void setCounties(List<County> counties) {
        this.counties = counties;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationcode() {
        return nationcode;
    }

    public void setNationcode(String nationcode) {
        this.nationcode = nationcode == null ? null : nationcode.trim();
    }

    public String getNationname() {
        return nationname;
    }

    public void setNationname(String nationname) {
        this.nationname = nationname == null ? null : nationname.trim();
    }
}