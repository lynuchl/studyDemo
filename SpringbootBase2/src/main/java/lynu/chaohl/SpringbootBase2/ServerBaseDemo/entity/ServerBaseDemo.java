package lynu.chaohl.SpringbootBase2.ServerBaseDemo.entity;

import java.io.Serializable;

public class ServerBaseDemo implements Serializable {
    private Integer id;

    private Integer testid;

    private String testname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }
}