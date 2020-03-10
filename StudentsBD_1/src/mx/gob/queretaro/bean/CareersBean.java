package mx.gob.queretaro.bean;

/**
 *
 * @author ijimeneza
 */
public class CareersBean{
    
    private int id_career;
    private String name_career;
    private String name_school;
    private String type_carrer;
    private String plan_career;
    private int group;

    //Getters and setters.    
    
    public int getId_career() {
        return id_career;
    }

    public void setId_career(int id_career) {
        this.id_career = id_career;
    }

    public String getName_career() {
        return name_career;
    }

    public void setName_career(String name_career) {
        this.name_career = name_career;
    }
    
    
    public String getName_school() {
        return name_school;
    }

    public void setName_school(String name_school) {
        this.name_school = name_school;
    }

    public String getType_carrer() {
        return type_carrer;
    }

    public void setType_carrer(String type_carrer) {
        this.type_carrer = type_carrer;
    }

    public String getPlan_career() {
        return plan_career;
    }

    public void setPlan_career(String plan_career) {
        this.plan_career = plan_career;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    
    
}
