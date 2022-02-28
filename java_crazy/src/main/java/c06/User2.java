package c06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User2 {

    @XmlElement(name = "id")
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "pwd")
    private String pwd;

    public User2() {
    }

    public User2(Integer id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

}
