/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.queretaro.bo;

import java.util.Scanner;
import mx.gob.queretaro.bean.CareersBean;
import mx.gob.queretaro.dao.CareerDao;


/**
 *
 * @author ijimeneza
 */
public class CareerBo {
    CareersBean cb = new CareersBean();
    CareerDao CD = new CareerDao();
    Scanner strInput = new Scanner(System.in,"ISO-8859-1");
    
    public void addCareer(){
        try{
            System.out.println("-------Datos de la carrera que agregara-------\n");

            System.out.println("Ingrese el nombre de la carrera:");
            cb.setName_career(strInput.nextLine());
            System.out.println("Ingrese el nombre de la facultad:");
            cb.setName_school(strInput.nextLine());
            System.out.println("Es licenciatura o ingeniería:");
            cb.setType_carrer(strInput.nextLine());
            System.out.println("Ingrese el plan de estudios:");
            cb.setPlan_career(strInput.nextLine());
            System.out.println("Ingrese el grupo de la carrera:");
            cb.setGroup(strInput.nextInt());
            

            CD.addCar(cb);
            System.out.println("----------------------------------------------\n");
            
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void getAllCareers(){
        try{
            System.out.println("------Datos de las carreras------\n");
            CD.allCar(cb);
            System.out.println("---------------------------------------\n");
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public void searchStudent(){
        try{
            System.out.println("------Datos de la carrera que busca------\n");
            System.out.println("Ingrese el id de la carrera: ");
            cb.setId_career(strInput.nextInt());

            if(cb.getId_career() != 0){
                CD.searchCar(cb);
                System.out.println("----------------------------------------------\n");
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void deleteStudent(){
        try{
            System.out.println("------Datos de la carrera que eliminara------\n");
            System.out.println("Ingrese el nombre de la carrera: ");
            cb.setId_career(strInput.nextInt());
            
            if(cb.getId_career() != 0){
                CD.deleteCar(cb);
                System.out.println("----------------------------------------------\n");
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void updateStudent(){
        
        try{
            System.out.println("------Datos de la carrera a modificar------\n");
            System.out.println("Ingrese el id de la carrera: ");
            cb.setId_career(strInput.nextInt());
            
            if(cb.getId_career() != 0){
                String upLine = strInput.nextLine();
                System.out.println("Ingrese el nombre de la carrera:");
                cb.setName_career(strInput.nextLine());
                System.out.println("Ingrese el nombre de la facultad:");
                cb.setName_school(strInput.nextLine());
                System.out.println("Es licenciatura o ingeniería:");
                cb.setType_carrer(strInput.nextLine());
                System.out.println("Ingrese el plan de estudios:");
                cb.setPlan_career(strInput.nextLine());
                System.out.println("Ingrese el grupo de la carrera:");
                cb.setGroup(strInput.nextInt());
                CD.updateCar(cb);
                System.out.println("----------------------------------------------\n");
                
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
