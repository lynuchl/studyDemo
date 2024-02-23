package lynu.chaohl.SpringbootIntegration.ServerBaseDemo.entity;

import java.io.Serializable;

public class Province implements Serializable {
    private Integer id;

    private String provincecode;

    private String provincenmae;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

    public String getProvincenmae() {
        return provincenmae;
    }

    public void setProvincenmae(String provincenmae) {
        this.provincenmae = provincenmae == null ? null : provincenmae.trim();
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provincecode='" + provincecode + '\'' +
                ", provincenmae='" + provincenmae + '\'' +
                '}';
    }
}