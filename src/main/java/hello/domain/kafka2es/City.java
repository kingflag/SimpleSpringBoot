package hello.domain.kafka2es;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author: kingflag
 * @create: 2018-11-02 10:06
 **/
@Document(indexName = "city", type = "api")
public class City implements Serializable {

    private String id;
    private String score;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
