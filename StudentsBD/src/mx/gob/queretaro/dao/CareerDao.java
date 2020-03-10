/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    

    public void addCar(CareersBean cb){        
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
                System.out.println("\nLa carrera se agrego correctamente con el id: "+ rs.getInt(1)+"\n");
            else
                System.out.println("Hay datos vacios por lo que no se puede agregar la carrera.");
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void allCar(CareersBean cb){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "SELECT * FROM careers";
            PreparedStatement stmt = con.prepareStatement(in);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println("\n Datos de la carrera:");
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Carrera: " +rs.getString(4)+ " en " + rs.getString(2));
                System.out.println("Facultad: " + rs.getString(3));
                System.out.println("Plan de estudio: " + rs.getString(5)+ " Grupo: "+rs.getInt(6));
            }
            con.close(); 
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
    
    
    public void searchCar(CareersBean cb){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "SELECT c.*, s.* FROM careers c INNER JOIN students s ON c.id = s.id_career WHERE c.id = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setInt(1, cb.getId_career());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println("\nDatos de la carrera:");
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Carrera: " +rs.getString(4)+ " en " + rs.getString(2)+ " Facultad: " + rs.getString(3));
               
                System.out.println("\nDatos del estudiante:");
                System.out.println("Id: " + rs.getInt(7));
                System.out.println("Nombre: " + rs.getString(8));
                System.out.println("Sexo: " + rs.getString(9));
                System.out.println("Edad: " + rs.getInt(10));
                System.out.println("Semestre: " + rs.getInt(12));
                System.out.println("Promedio: " + rs.getFloat(13));
                
            }
                    
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
            //throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
    
    public void deleteCar(CareersBean cb){
        
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "DELETE FROM careers WHERE name_career = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            stmt.setString(1, cb.getName_career());
            
            int x = stmt.executeUpdate();
            if(x>0){
                System.out.println("\nEl estudiante ha sido eliminado.");
            }else{
                System.out.println("La carrera no existe.");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
    
    public void updateCar(CareersBean cb){
        try{
            Class.forName(cs);
            Connection con = DriverManager.getConnection(rut, "MRG_IRVING", "iv1n#001");
            //Statement stmt = con.createStatement();
            
            String in = "UPDATE careers SET name_career = ?, name_FACULTY = ?, type_career = ?, plan_career = ?, number_group= ? WHERE name_career = ?";
            PreparedStatement stmt = con.prepareStatement(in);
            
            stmt.setString(1, cb.getName_career());
            stmt.setString(2, cb.getName_school());
            stmt.setString(3, cb.getType_carrer());
            stmt.setString(4, cb.getType_carrer());
            stmt.setInt(5, cb.getGroup());
            stmt.setString(6, cb.getName_career());
            
            int x = stmt.executeUpdate();
            if(x>0)
                System.out.println("\nLa carrera se actualizo correctamente.");
            else{
                System.out.println("La carrera no existe o hay algún problema.");
            }
            
            con.close(); 
            
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("No hay conexión a la base de datos");
        }
    }
}
