package library.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data /* 省略getter/setter */
@Builder /* 设置属性不需要再new */
@AllArgsConstructor /* 3种构造器 */
@NoArgsConstructor
public class Parent implements Serializable {

    @JsonProperty(required = true, value = "parent_id")
    private Integer id;

    /* 默认值 */
    @Builder.Default
    private String name = "";

    public String password;

    public void test() {
    }

}
