package library.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"name"})
public class ParentVO extends Parent {

    @JsonProperty(value = "parent_id")
    private Integer id;

    public ParentVO(Integer id, String name, String password) {
        super(id, name, password);
    }

}
