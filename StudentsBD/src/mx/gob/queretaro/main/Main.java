package mx.gob.queretaro.main;

import java.util.Scanner;
import mx.gob.queretaro.bo.CareerBo;
import mx.gob.queretaro.bo.StudentBo;
import mx.gob.queretaro.views.View;

/**
 *
 * @author ijimeneza
 */
public class Main {
    
    static View vi = new View();
    static StudentBo stb = new StudentBo();
    static CareerBo crb = new CareerBo();
    
    public static void main(String[] args){
        String choice, i, cont = "y";
        Scanner strInput = new Scanner(System.in);
       try{
           while(cont.equalsIgnoreCase("y")){
                vi.Choices();
                i = strInput.nextLine();
                if(i.equalsIgnoreCase("1")){
                     while(cont.equalsIgnoreCase("y")){
                        choice = "";
                        vi.menuC();
                        choice = strInput.nextLine();

                         switch (choice) {
                             case "1":
                                 crb.addCareer();
                                 break;
                             case "2":
                                 crb.getAllCareers();
                                 break;
                             case "3":
                                 crb.searchStudent();
                                 break;
                             case "4":
                                 crb.updateStudent();
                                 break;
                             case "5":
                                 crb.deleteStudent();
                                 break;
                             default:
                                 break;
                             }

                     System.out.println("¿Desea hacer otra operación con las carreras? y/n\n");
                     cont = strInput.nextLine();
                     }
                 }else if(i.equalsIgnoreCase("2")){
                     while(cont.equalsIgnoreCase("y")){
                     choice = "";
                     vi.menu();
                     choice = strInput.nextLine();

                     switch (choice) {
                         case "1":
                             stb.addStudent();
                             break;
                         case "2":
                             stb.searchStudent();
                             break;
                         case "3":
                             stb.updateStudent();
                             break;
                         case "4":
                             stb.deleteStudent();
                             break;
                         default:
                             break;
                         }

                     System.out.println("¿Desea realizar alguna otra opcion de los estudiantes? y/n\n");
                     cont = strInput.nextLine();
                    }
                 }
                System.out.println("¿Desea continuar con algun otro campo? y/n");
                cont = strInput.nextLine();
        }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
