/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.queretaro.bo;

import java.util.List;
import mx.gob.queretaro.bean.CareersBean;
import mx.gob.queretaro.bean.StudentsBean;
import mx.gob.queretaro.dao.CareerDao;
import mx.gob.queretaro.dao.StudentDao;
import mx.gob.queretaro.gui.careers.DeleteCareer;
import mx.gob.queretaro.gui.careers.SearchCareer;
import mx.gob.queretaro.gui.careers.UpdateCareer;


/**
 *
 * @author ijimeneza
 */
public class CareerBo {
    CareersBean cb = new CareersBean();
    StudentsBean st = new StudentsBean();
    CareerDao CD = new CareerDao();
    StudentDao sd = new StudentDao();
    
    public String addCareer(UpdateCareer uc, String ar){
        try{
            boolean[] ips = new boolean[5];
            ips[0] = uc.jTextField2.getText().length() !=0 && !uc.jTextField2.equals(" ");
            ips[1] = uc.jTextField3.getText().length() !=0 && !uc.jTextField3.equals(" ");
            ips[2] = uc.jTextField4.getText().length() !=0 && !uc.jTextField4.equals(" ");
            ips[3] = uc.jTextField5.getText().length() !=0 && !uc.jTextField5.equals(" ");
            ips[4] = uc.jTextField6.getText().length() !=0 && !uc.jTextField6.equals(" ");
            
            
            if(ips[0] || ips[1] || ips[2] || ips[3] || ips[4]){
           
                
                cb.setName_career(uc.jTextField2.getText().trim());
                cb.setName_school(uc.jTextField3.getText());
                cb.setType_carrer(uc.jTextField4.getText());
                cb.setPlan_career(uc.jTextField5.getText());
                cb.setGroup(Integer.parseInt(uc.jTextField6.getText()));
                String is = null;
                ar = CD.addCar(cb, is);
                
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor\n\n");
            }            
        }catch(RuntimeException ex){
            throw new RuntimeException("Hay campos vacios.");
        }
        return ar;
    }
    
    public  List<StudentsBean> getAllStudents(SearchCareer sc){
        try{
            st.setCareer(Integer.parseInt(sc.jTextField1.getText()));
            List<StudentsBean> students = sd.AllStu(st.getCareer());
            int i = 0;
            if(sc.jTextField1.getText().length() !=0 && !sc.jTextField1.equals(" ")){
                
                for ( StudentsBean student :students) {
                    sc.jTable1.setValueAt(student.getId(), i, 0);
                    sc.jTable1.setValueAt(student.getName(), i, 1);
                    sc.jTable1.setValueAt(student.getSex(), i, 2);
                    sc.jTable1.setValueAt(student.getAge(), i, 3);
                    sc.jTable1.setValueAt(student.getSemester(), i, 4);
                    sc.jTable1.setValueAt(student.getAvarage(), i, 5);
                    i++;
            }
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor");
            }
            return students;
        }catch(RuntimeException ex){
            throw new RuntimeException("A ocurrido un error");
        }
        
    }
    
    
    public String searchCareer(SearchCareer sc, String ar){
        try{
            cb.setId_career(Integer.parseInt(sc.jTextField1.getText()));

            if(sc.jTextField1.getText().length() !=0 && !sc.jTextField1.equals(" ")){
                String is = null;
                ar = CD.searchCar(cb, is);
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException("A ocurrido un error");
        }
        return ar;
    }
    
    public String searchCareer(UpdateCareer uc, String ar){
        try{
            cb.setId_career(Integer.parseInt(uc.jTextField1.getText()));

            if(uc.jTextField1.getText().length() !=0 && !uc.jTextField1.equals(" ")){
                String is = null;
                ar = CD.searchCar(cb, is);
                uc.jTextField2.setText(cb.getName_career());
                uc.jTextField3.setText(cb.getName_school());
                uc.jTextField4.setText(cb.getType_carrer());
                uc.jTextField5.setText(cb.getPlan_career());
                uc.jTextField6.setText(String.valueOf(cb.getGroup()));
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException("A ocurrido un error");
        }
        return ar;
    }
    
    public String deleteStudent(DeleteCareer dc, String ar){
        try{
            cb.setId_career(Integer.parseInt(dc.jTextField1.getText()));
            
            if(dc.jTextField1.getText().length() != 0 && !dc.jTextField1.equals(" ")){
                String is = null;
                ar = CD.deleteCar(cb, is);
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException("A ocurrido un error");
        }
        return ar;
    }
    
    public String updateCareer(UpdateCareer uc, String ar){
        
        try{
            boolean[] ips = new boolean[6];
            ips[0] = uc.jTextField1.getText().length() !=0 && !uc.jTextField1.equals(" ");
            ips[1] = uc.jTextField2.getText().length() !=0 && !uc.jTextField2.equals(" ");
            ips[2] = uc.jTextField3.getText().length() !=0 && !uc.jTextField3.equals(" ");
            ips[3] = uc.jTextField4.getText().length() !=0 && !uc.jTextField4.equals(" ");
            ips[4] = uc.jTextField5.getText().length() !=0 && !uc.jTextField5.equals(" ");
            ips[5] = uc.jTextField6.getText().length() !=0 && !uc.jTextField6.equals(" ");
            
            if(ips[0] || ips[1] || ips[2] || ips[3] || ips[4] || ips[5]){
           
                cb.setId_career(Integer.parseInt(uc.jTextField1.getText()));
                cb.setName_career(uc.jTextField2.getText());
                cb.setName_school(uc.jTextField3.getText());
                cb.setType_carrer(uc.jTextField4.getText());
                cb.setPlan_career(uc.jTextField5.getText());
                cb.setGroup(Integer.parseInt(uc.jTextField6.getText()));
                
                String is = null;
                ar = CD.updateCar(cb, is);
                
                
            }else{
                throw new RuntimeException("Ingreso un valor vacio o no ingreso ningun valor");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException("Hay campos vacios.");
        }
        return ar;
    }
}
