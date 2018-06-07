package hello.domain.elasticSearch;

import java.io.Serializable;

/**
 * Created by admin on 2018/6/7.
 */
public class Tutorial implements Serializable {
    private Long id;
    /**
     * 教程名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
