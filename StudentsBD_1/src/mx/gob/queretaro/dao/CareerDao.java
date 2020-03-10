package mx.gob.queretaro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.gob.queretaro.bean.CareersBean;

/**
 *
 * @author ijimeneza
 */
public class CareerDao {
    public String cs = "oracle.jdbc.driver.OracleDriver";
    public String rut = "jdbc:oracle:thin:@10.1.201.238:1521:XE";
    

    public String addCar(CareersBean cb, String is){        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "INSERT INTO careers(name_career, name_faculty, type_career, plan_career, number_group) values(?,?,?,?,?) ";
            PreparedStatement stmt = con.prepareStatement(in);
            
            stmt.setString(1, cb.getName_career());
            stmt.setString(2, cb.getName_school());
            stmt.setString(3, cb.getType_carrer());
            stmt.setString(4, cb.getPlan_career());
            stmt.setInt(5, cb.getGroup());
            int x = stmt.executeUpdate();
            
            PreparedStatement smt = con.prepareStatement("SELECT * FROM careers WHERE name_career = ?");
            smt.setString(1, cb.getName_career());
            ResultSet rs = smt.executeQuery();
            
            if(x > 0 && rs.next())
                is = "La carrera se agrego correctamente con el id: "+ rs.getInt(1);
                //System.out.println("\nLa carrera se agrego correctamente con el id: "+ rs.getInt(1)+"\n");
            else
                is = "Hay datos vacios por lo que no se puede agregar la carrera.";
                //System.out.println("Hay datos vacios por lo que no se puede agregar la carrera.");
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return is;
    }    
    
    public String searchCar(CareersBean cb, String is){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "SELECT * FROM careers WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, cb.getId_career());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                is =  "Id: " + rs.getInt(1)
                        +"\nCarrera: " + rs.getString(4) + " en " + rs.getString(2)
                        +"\nFacultad: " + rs.getString(3) 
                        +"\nPlan de estudio: " + rs.getString(5)+ " Grupo: "+rs.getInt(6);  
                cb.setName_career(rs.getString(2));
                cb.setName_school(rs.getString(3));
                cb.setType_carrer(rs.getString(4));
                cb.setPlan_career(rs.getString(5));
                cb.setGroup(rs.getInt(6));
            }else{
                is = "La carrera que desea consultar no existe.";
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
            //throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
    
    public String deleteCar(CareersBean cb, String is){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "DELETE FROM careers WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, cb.getId_career());
            
            int x = stmt.executeUpdate();
            if(x>0){
                is = "La carrera ha sido eliminada exitosamente.";
            }else{
                is = "La carrera no existe.";
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
    
    public String updateCar(CareersBean cb, String is){
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "UPDATE careers SET name_career = ?, name_FACULTY = ?, type_career = ?, plan_career = ?, number_group= ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            
            stmt.setString(1, cb.getName_career());
            stmt.setString(2, cb.getName_school());
            stmt.setString(3, cb.getType_carrer());
            stmt.setString(4, cb.getType_carrer());
            stmt.setInt(5, cb.getGroup());
            stmt.setInt(6, cb.getId_career());
            
            int x = stmt.executeUpdate();
            if(x>0)
                is = "La carrera se actualizo correctamente.";
            else
                is = "La carrera no existe o hay algún problema.";
            
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
        return is;
    }
}
