package mx.gob.queretaro.bean;

import java.io.Serializable;

/**
 *
 * @author ijimeneza
 */
public class PersonBean implements Serializable{
    private int id;
    private String name;
    private String sex;
    private int Age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
    
    
    
}
