package mx.gob.queretaro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.gob.queretaro.bean.StudentsBean;

/**
 *
 * @author ijimeneza
 */
public class StudentDao {
    public String cs = "oracle.jdbc.driver.OracleDriver";
    public String rut = "jdbc:oracle:thin:@10.1.201.238:1521:XE";
    

    public void addStu(StudentsBean st){        
        
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "INSERT INTO students(NAME_STUDENT, SEX_STUDENT, AGE_STUDENT, ID_CAREER, SEMESTER_STUDENT, AVARAGE_STUDENT) values(?,?,?,?,?,?) ";
            PreparedStatement stmt = con.prepareStatement(in);
            
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getSex());
            stmt.setInt(3, st.getAge());
            stmt.setInt(4, st.getCareer());
            stmt.setInt(5, st.getSemester());
            stmt.setFloat(6, st.getAvarage());
            
            
            PreparedStatement smt = con.prepareStatement("SELECT * FROM students WHERE name_student = ?");
            smt.setString(1, st.getName());
            ResultSet rs = smt.executeQuery();
            
            int x = stmt.executeUpdate();
            if(x > 0 && rs.next())
                System.out.println("\nEl estudiante se agrego correctamente con el id: "+ rs.getInt(1)+"\n");
            else
                System.out.println("Hay datos vacios por lo que no se puede actualizar el estudiante.");
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
    
    
    public void searchStu(StudentsBean st){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "SELECT s.*, c.name_career FROM students s INNER JOIN careers c ON s.id_student = ? and c.id = s.id_career";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, st.getId());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                System.out.println("\nId: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Sexo: " + rs.getString(3));
                System.out.println("Edad: " + rs.getInt(4));
                System.out.println("Carrera: " + rs.getString(8));
                System.out.println("Semestre: " + rs.getInt(6));
                System.out.println("Promedio: " + rs.getFloat(7));
            }else{
                System.out.println("No existe el estudiante que quiere consultar.");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
    
    public void deleteStu(StudentsBean st){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "DELETE FROM students WHERE id_student = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, st.getId());
            
            int x = stmt.executeUpdate();
            if(x>0){
                System.out.println("\nEl estudiante ha sido eliminado.");
            }else{
                System.out.println("El estudiante no existe o ha ocurrido un error");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
    
    public void updateStu(StudentsBean st){
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "UPDATE students SET name_student = ?, sex_student = ?, age_student = ?, id_career = ?, semester_student = ?, avarage_student = ? WHERE id_student = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            
            stmt.setString(1, st.getName());
            stmt.setString(2, st.getSex());
            stmt.setInt(3, st.getAge());
            stmt.setInt(4, st.getCareer());
            stmt.setInt(5, st.getSemester());
            stmt.setFloat(6, st.getAvarage());
            stmt.setInt(7, st.getId());
            
            int x = stmt.executeUpdate();
            if(x>0)
                System.out.println("\nEl estudiante se actuaizo correctamente.");
            else{
                System.out.println("Ocurrio un error o el usuario no existe.");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
//throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
}
