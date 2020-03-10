package mx.gob.queretaro.views;

/**
 *
 * @author ijimeneza
 */
public class View {
    
    
    public void menu(){
        System.out.println("Menu de selección.\n");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar un estudiante.");
        System.out.println("2. Buscar un estudiante.");
        System.out.println("3. Modificar un estudiante.");
        System.out.println("4. Eliminar estudiante");
        System.out.println("Ingrese la opción: ");
    }
    
    public void menuC(){
        System.out.println("Menu de selección.\n");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar una carrera.");
        System.out.println("2. Ver todas las carreras");
        System.out.println("3. Buscar una carrera.");
        System.out.println("4. Modificar una Carrera.");
        System.out.println("5. Eliminar carrera");
        System.out.println("Ingrese la opción: ");
    }
    
    public void Choices(){
        System.out.println("Menu de selección.\n");
        System.out.println("Escoga lo que quiere revisar:");
        System.out.println("1. Carreras.");
        System.out.println("2. Estudiante.");
    }
    
}
