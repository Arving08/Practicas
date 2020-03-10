package mx.gob.queretaro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.gob.queretaro.bean.StudentsBean;

/**
 *
 * @author ijimeneza
 */
public class StudentDao {
    public String cs = "oracle.jdbc.driver.OracleDriver";
    public String rut = "jdbc:oracle:thin:@10.1.201.238:1521:XE";
    

    public String addStu(StudentsBean st, String is){        
        
        
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
            
            int x = stmt.executeUpdate();
            if( x > 0){
                is = "El estudiante se agrego correctamente.";
            }else{
                is = "Hay datos vacios por lo que no se puede agregar el estudiante.";
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
    
    public String addStuC(StudentsBean st, String is){        
        
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            PreparedStatement smt = con.prepareStatement("SELECT id_student FROM students WHERE name_student = ?");
            smt.setString(1, st.getName());
            ResultSet rs = smt.executeQuery();
            
            
            if(rs.next()){
                is = "El id del estudiante es: " + rs.getInt(1);
            }else{
                is = "Hay datos vacios por lo que no se puede agregar el estudiante.";
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
    
    public  List<StudentsBean> AllStu(int id_career){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            List<StudentsBean> students = new ArrayList<>();
            //Statement stmt = con.createStatement();
            
            String in = "SELECT * FROM students WHERE id_career = ? ORDER BY id_student ASC";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, id_career);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                StudentsBean student = new StudentsBean();
                
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setSex(rs.getString(3));
                student.setAge(rs.getInt(4));
                student.setSemester(rs.getInt(6));
                student.setAvarage(rs.getFloat(7));
                
                students.add(student);
            }
            
            
            con.close(); 

            
            return students;
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("Ha ocurrido algun error con la base");
        }
    }
    
    public String searchStu(StudentsBean st, String is){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "SELECT s.*, c.name_career FROM students s INNER JOIN careers c ON s.id_student = ? and c.id = s.id_career";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, st.getId());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                is = "Id: " + rs.getInt(1) + "\nNombre: " + rs.getString(2) + "\nSexo: " + rs.getString(3) + 
                        "\nEdad: " + rs.getInt(4) + "\nCarrera: " + rs.getString(9)+"\nSemestre: " + rs.getInt(6) +
                        "\nPromedio: " + rs.getFloat(7);
                st.setName(rs.getString(2));
                st.setSex(rs.getString(3));
                st.setAge(rs.getInt(4));
                st.setCareer(rs.getInt(5));
                st.setSemester(rs.getInt(6));
                st.setAvarage(rs.getFloat(7));
            }else{
                is = "No existe el estudiante que quiere consultar.";
                //System.out.println("No existe el estudiante que quiere consultar.");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
    
    public String deleteStu(StudentsBean st, String is){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "DELETE FROM students WHERE id_student = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, st.getId());
            
            int x = stmt.executeUpdate();
            if(x>0){
                is = "El estudiante ha sido eliminado.";
            }else{
                is = "El estudiante no existe o ha ocurrido un error";
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
    
    public String updateStu(StudentsBean st, String is){
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
                is = "El estudiante se actuaizo correctamente.";
                //System.out.println("\nEl estudiante se actuaizo correctamente.");
            else{
                is = "Ocurrio un error o el usuario no existe.";
                //System.out.println("Ocurrio un error o el usuario no existe.");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
//throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }

    public void AllStu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
