package mx.gob.queretaro.bo;


import java.util.Scanner;

import mx.gob.queretaro.bean.StudentsBean;
import mx.gob.queretaro.dao.StudentDao;

/**
 *
 * @author ijimeneza
 */
public class StudentBo {
    
    
    StudentsBean st = new StudentsBean();
    StudentDao sd = new StudentDao();
    Scanner strInput = new Scanner(System.in,"ISO-8859-1");
    
    public void addStudent(){
        try{
            System.out.println("-------Datos del estudiante-------\n");

            System.out.println("Ingrese el nombre del estudiante:");
            st.setName(strInput.nextLine());
            System.out.println("Ingrese el sexo del estudiante:");
            st.setSex(strInput.nextLine());
            System.out.println("Ingrese la edad del estudiante:");
            st.setAge(strInput.nextInt());
            System.out.println("Ingrese el id de la carrera del estudiante:");
            st.setCareer(strInput.nextInt());
            System.out.println("Ingrese el semestre del estudiante:");
            st.setSemester(strInput.nextInt());
            System.out.println("Ingrese el promedio del estudiante:");
            st.setAvarage(strInput.nextFloat());

            sd.addStu(st);
            System.out.println("----------------------------------------------\n");
            
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void searchStudent(){
        try{
            System.out.println("------Datos del estudiante------\n");
            System.out.println("Ingrese el id del estudiante: ");
            st.setId(strInput.nextInt());

            if(st.getId() != 0){
                sd.searchStu(st);
                System.out.println("----------------------------------------------\n");
            }else{
                throw new RuntimeException("Hay un valor nulo\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void deleteStudent(){
        try{
            System.out.println("------Datos del estudiante------\n");
            System.out.println("Ingrese el id del estudiante: ");
            st.setId(strInput.nextInt());
            if(st.getId() != 0){
                sd.deleteStu(st);
                System.out.println("----------------------------------------------\n");
            }else{
                throw new RuntimeException("Hay un valor nulo\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void updateStudent(){
        
        try{
            System.out.println("------Datos del estudiante------\n");
            System.out.println("Ingrese el id del estudiante: ");
            st.setId(strInput.nextInt());
            
            if( st.getId() != 0){
                String upLine = strInput.nextLine();
                System.out.println("Ingrese el nombre del estudiante:");
                st.setName(strInput.nextLine());
                System.out.println("Ingrese el sexo del estudiante:");
                st.setSex(strInput.nextLine());
                System.out.println("Ingrese la edad del estudiante:");
                st.setAge(strInput.nextInt());
                System.out.println("Ingrese el id de la carrera del estudiante:");
                st.setCareer(strInput.nextInt());
                System.out.println("Ingrese el semestre del estudiante:");
                st.setSemester(strInput.nextInt());
                System.out.println("Ingrese el promedio del estudiante:");
                st.setAvarage(strInput.nextFloat());
                sd.updateStu(st);
                System.out.println("----------------------------------------------\n");
                
            }else{
                throw new RuntimeException("Hay un valor nulo\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
}
