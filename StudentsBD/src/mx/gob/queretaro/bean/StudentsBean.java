package mx.gob.queretaro.bean;


/**
 *
 * @author ijimeneza
 */
public class StudentsBean extends PersonBean{

    private int Career;
    private int Semester;
    private float Avarage;

   
    
    //Getters and Setters


    public int getCareer() {
        return Career;
    }

    public void setCareer(int Career) {
        this.Career = Career;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public float getAvarage() {
        return Avarage;
    }

    public void setAvarage(float Avarage) {
        this.Avarage = Avarage;
    }
    
    
}
