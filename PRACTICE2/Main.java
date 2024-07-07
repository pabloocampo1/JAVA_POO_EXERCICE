/*
 * Proyecto 4: Sistema de Gestión de Vehículos
Descripción
Crea un sistema para gestionar vehículos en una empresa de alquiler. El sistema debe permitir agregar vehículos, asignar vehículos a clientes y calcular el costo de alquiler.

Clases y Herencia
Vehículo: Clase base con atributos encapsulados como marca, modelo y año.
Coche y Moto: Clases derivadas de Vehículo con atributos adicionales como número de puertas para coches y tipo de motor para motos.
Cliente: Clase que representa a un cliente con atributos como nombre y lista de vehículos alquilados.
Funciones
Métodos para establecer y obtener los atributos de los vehículos y clientes (usando getters y setters).
Métodos para asignar un vehículo a un cliente.
Métodos para calcular el costo de alquiler de un vehículo.
Método para mostrar la información de los vehículos y clientes.
 */

package PRACTICE2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Auto carro1 = new Auto("toyota", "prado", "red", 2023, 4);
        Cliente cliente = new Cliente("juan", 19, 34353);
        System.out.println("los autos rentados de "+cliente.getNombre());
        cliente.rentarAuto(carro1.getMarca());
        cliente.listaDeAutos();
    }
}



//clase abstracta para vehiculo
abstract class Vehiculo{
    private String marca;
    private String modelo;
    private String color;
    private int anio;

    public Vehiculo(String marca, String modelo, String color,int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
    }

    public void mostrarInfo() {
        System.out.println("el auto es:"+marca+ ", "+modelo+ ", " +color + ", "+anio);
    }
    //getter para mostrar solo la marca
    public String getMarca() {
        return marca;
    }

    //setter para cambiarle el color
    public void setColor(String color) {
        this.color = color;
    }

    abstract double calcularCosto();


}


class Auto extends Vehiculo{
    int numeroPuertas;
    
    public Auto(String marca, String modelo, String color,int anio, int numeroPuertas){
        super(marca,modelo, color, anio);
        this.numeroPuertas = numeroPuertas;
    };

    @Override
    public double calcularCosto() {
        Scanner input = new Scanner(System.in);
        System.out.println("digite el costo por hora del vehiculo: ");
        double costoHora = input.nextDouble();
        
        System.out.println("digite el total de horas: ");
        int horasTotales = input.nextInt();
        input.close();
        return costoHora * horasTotales;
    };
};

// clase para los clientes

class Cliente{
    private ArrayList<String> autosPrestados;
    private String nombre;
    private int edad;
    private int idCliente;

    public Cliente(String nombre, int edad, int idCliente){
        this.nombre = nombre;
        this.edad = edad;
        this.idCliente = idCliente;
        this.autosPrestados = new ArrayList<>();
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void rentarAuto(String auto ){
        autosPrestados.add(auto);
    }
    public void listaDeAutos(){
        if(autosPrestados.size() < 1){
            System.out.println("no hay autos");
        }else{
            for (String auto : autosPrestados) {
                System.out.println("- "+auto);
            }
        }
    };
}
