package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity;

import java.io.Serializable;

public class County implements Serializable {
    private Integer id;

    private String countycode;

    private String countyname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode == null ? null : countycode.trim();
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname == null ? null : countyname.trim();
    }
}