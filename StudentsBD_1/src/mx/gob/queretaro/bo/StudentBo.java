package mx.gob.queretaro.bo;


import java.util.Scanner;

import mx.gob.queretaro.bean.StudentsBean;
import mx.gob.queretaro.dao.StudentDao;
import mx.gob.queretaro.gui.student.DeleteStudent;
import mx.gob.queretaro.gui.student.SearchStudent;
import mx.gob.queretaro.gui.student.UpdateStudent;

/**
 *
 * @author ijimeneza
 */
public class StudentBo {
    
    
    StudentsBean st = new StudentsBean();
    StudentDao sd = new StudentDao();
    Scanner strInput = new Scanner(System.in,"ISO-8859-1");
    
    public String addStudent(UpdateStudent us, String ar){
        try{
            boolean[] s = new boolean[6];
                s[0] = us.jTextField2.getText().length()!= 0 && !us.jTextField2.equals(" ");
                s[1] = us.jTextField3.getText().length()!= 0 && !us.jTextField3.equals(" ");
                s[2] = us.jTextField4.getText().length()!= 0 && !us.jTextField4.equals(" ");
                s[3] = us.jTextField5.getText().length()!= 0 && !us.jTextField5.equals(" ");
                s[4] = us.jTextField6.getText().length()!= 0 && !us.jTextField6.equals(" ");
                s[5] = us.jTextField7.getText().length()!= 0 && !us.jTextField7.equals(" ");
                
            if(s[0] || s[1] || s[2] || s[3] || s[4] || s[5]){    
                st.setName(us.jTextField2.getText());
                st.setSex(us.jTextField3.getText());            
                st.setAge(Integer.parseInt(us.jTextField4.getText()));            
                st.setCareer(Integer.parseInt(us.jTextField5.getText()));            
                st.setSemester(Integer.parseInt(us.jTextField6.getText()));            
                st.setAvarage(Float.parseFloat(us.jTextField7.getText()));

                String is = null;
                ar = sd.addStu(st, is);
                
            }else{
                throw new RuntimeException("No ha llenado todos los campos.");
            }
            
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
        return ar;
    }
    
    public String searchStudent(SearchStudent ss, String ar){
        try{
            st.setId(Integer.parseInt(ss.jTextField1.getText()));
            if(ss.jTextField1.getText().length() !=0 && !ss.jTextField1.equals(" ")){
                String is = null;
                ar = sd.searchStu(st, is);
            }else{
                throw new RuntimeException("Hay un valor nulo");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException("Hay campos vacios.");
        }
        return ar;
    }
    
    public String searchStudentU(UpdateStudent us, String ar){
        try{
            st.setId(Integer.parseInt(us.jTextField1.getText()));
            if(us.jTextField1.getText().length() !=0 && !us.jTextField1.equals(" ")){
                String is = null;
                ar = sd.searchStu(st, is);
                us.jTextField2.setText(st.getName());
                us.jTextField3.setText(st.getSex());
                us.jTextField4.setText(String.valueOf(st.getAge()));
                us.jTextField5.setText(String.valueOf(st.getCareer()));
                us.jTextField6.setText(String.valueOf(st.getSemester()));
                us.jTextField7.setText(String.valueOf(st.getAvarage()));
                
            }else{
                throw new RuntimeException("Hay campos vacios.");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException("Hay campos vacios.");
        }
        return ar;
    }
    
    public String deleteStudent(DeleteStudent ds, String ar){
        try{
            st.setId(Integer.parseInt(ds.jTextField1.getText()));
            if(ds.jTextField1.getText().length()!= 0 && !ds.jTextField1.equals(" ")){
                String is = null;
                ar = sd.deleteStu(st, is);
            }else{
                throw new RuntimeException("Hay un valor nulo\n\n");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
        return ar;
    }
    
    public String updateStudent(UpdateStudent us, String ar){
        
        try{
            boolean[] s = new boolean[7];
                s[0] = us.jTextField1.getText().length()!= 0 && !us.jTextField1.equals(" ");
                s[1] = us.jTextField2.getText().length()!= 0 && !us.jTextField2.equals(" ");
                s[2] = us.jTextField3.getText().length()!= 0 && !us.jTextField3.equals(" ");
                s[3] = us.jTextField4.getText().length()!= 0 && !us.jTextField4.equals(" ");
                s[4] = us.jTextField5.getText().length()!= 0 && !us.jTextField5.equals(" ");
                s[5] = us.jTextField6.getText().length()!= 0 && !us.jTextField6.equals(" ");
                s[6] = us.jTextField7.getText().length()!= 0 && !us.jTextField7.equals(" ");
            
            if(s[0] || s[1] || s[2] || s[3] || s[4] || s[5] || s[6]){
                st.setId(Integer.parseInt(us.jTextField1.getText()));
                st.setName(us.jTextField2.getText());                
                st.setSex(us.jTextField3.getText());                
                st.setAge(Integer.parseInt(us.jTextField4.getText()));                
                st.setCareer(Integer.parseInt(us.jTextField5.getText()));                
                st.setSemester(Integer.parseInt(us.jTextField6.getText()));                
                st.setAvarage(Float.parseFloat(us.jTextField7.getText()));
                
                String is = null;
                ar = sd.updateStu(st, is);;
                
            }else{
                throw new RuntimeException("Debe de llenar todos los campos.");
            }
        }catch(RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
        return ar;
    }
    
}
