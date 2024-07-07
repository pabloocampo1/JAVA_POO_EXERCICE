/*gestion de estudiantes */
package PRACTICE1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("juan", 20);
        Cursos newCurso = new Cursos("Matematicas", "232Nm32");
        String curso = newCurso.nombreCurso();
        estudiante.agregarCurso(curso);
        
        estudiante.agregarNotas(2.6);
        estudiante.agregarNotas(5.0);
        estudiante.mostrarInformacion();
    }
    
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    };

    //getter para mostrar informacion de la persona
    public void mostrarNombre(){
        System.out.println("nombre: "+this.nombre);
    };
    public void mostrarEdad(){
        System.out.println("la edad es: "+this.edad+" años.");
    };
    //setter para cambiar los atributos
    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    };
    public void cambiarEdad(int edad) {
        this.edad = edad;
    };
};



class Estudiante extends Persona{

    //listas para almacenar los datos de cursos y notas
    private ArrayList<String> listaCursos;
    private ArrayList<Double> listaNotas;
    
    public Estudiante(String nombre, int edad){
        super(nombre, edad);
        this.listaCursos = new ArrayList<>();
        this.listaNotas = new ArrayList<>();
    }

    //metodo para mostrar la informacion de un estudiante
    public void mostrarInformacion(){
        System.out.println("informacion del estudiante:");
        mostrarNombre();
        mostrarEdad();
        System.out.println("Cursos: ");
        mostrarCursos();
        System.out.println("promedio de notas: ");
        mostrarPromedio();
    }
    //metodo para agregar notas
    public void agregarNotas(double nota){
        if(nota > 0 && nota <= 5.0){
            listaNotas.add(nota);
            System.out.println("nota agregada correctamente.");
        }else{
            System.out.println(nota+" es una nota no valida");
        }
    }

    //metodo para agregar cursos
    public void agregarCurso(String curso){
        listaCursos.add(curso);
        System.out.println("Curso agregado correctamente.");
    }

    //metodo para borrar cursos
    public void borrarCurso(String curso){
        while (true) {
            if (listaCursos.size() < 1){
                System.out.println("no hay cursos agregados.");
                break;
            }
            try {
                for (String i : listaCursos) {
                    if (i == curso) {
                        listaCursos.remove(curso);
                        break;
                    };
                };
            }catch (Exception e) {
                System.out.println("el curso no se encontro, intentalo nuevamente");
            };
        }
    };

    //metodo para  mostrar el promedio de las notas
    public void mostrarPromedio(){
        double sumaNotas = 0;
        double promedioNotas;
        int cantidadNotas = listaNotas.size();
        if (listaNotas.size() < 1) {
            System.out.println("no hay notas.");
        }else{
            for (double i : listaNotas) {
                sumaNotas+=i;
            };
            promedioNotas = sumaNotas / cantidadNotas;
            System.out.println("el promedio de notas es: "+promedioNotas);
        };

    };

    //metodo para mostrar todos los cursos de una estudiante
    public void mostrarCursos(){
        int contador = 1;
        for (String i : listaCursos) {
            System.out.println(contador+ ":" + i);
            contador++;
        }
    };

    //metodo para limpiar las notas
    public void limpiarNotas(){
        listaNotas.clear();
    };
    //metodo para limpiar los cursos
    public void limpiarCursos(){
        listaCursos.clear();
    };

};

class Cursos {
    private String nombreCurso;
    private String codigoCurso;
    public Cursos(String nombreCurso, String codigoCurso){
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
    };

    //metodo para cambiar el nombre de un curso

    public void cambiarNombre (String nombreNuevo) {
        this.nombreCurso = nombreNuevo;
    }
    //metodo para cambiar el codigo de un curso
    public void cambiarCodigo (String codigoNuevo) {
        this.codigoCurso = codigoNuevo;
    }

    public String nombreCurso(){
        return this.nombreCurso;
    }

    //mostrar informacion de un curso
    public void mostrarInformacionCurso () {
        System.out.println("nombre: "+this.nombreCurso);
        System.out.println("codigo: "+this.codigoCurso);
    }


}