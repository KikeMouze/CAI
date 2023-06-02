/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cai;

//  Se ha realizado la importación de dos librerías
/*  En cuanto la librería random permite obtener un numero aleatorio y tambien se ha usado scanner para ingresar valores de entrada*/
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kike
 */
public class CAI {
  
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
        int nivelDificultad = obtenerNivelDificultad(scanner);
        int tipoProblema = obtenerTipoProblema(scanner);
        
        int preguntasCorrectas = 0;
        int preguntasTotal = 0;
        
        while (preguntasCorrectas < 10) {
            String pregunta = generarPregunta(nivelDificultad, tipoProblema);
            System.out.println(pregunta);
            
            int respuesta = scanner.nextInt();
            
            if (verificarRespuesta(pregunta, respuesta)) {
                darRetroalimentacion(true);
                preguntasCorrectas++;
            } else {
                darRetroalimentacion(false);
            }
            
            preguntasTotal++;
        }
        
        double porcentajeCorrectas = (double) preguntasCorrectas / preguntasTotal * 100;
        if (porcentajeCorrectas < 75) {
            System.out.println("Por favor pide ayuda adicional a tu instructor.");
        } else {
            System.out.println("¡Felicidades, estás listo para pasar al siguiente nivel!");
        }
        
        scanner.close();
    }
    
    public static int obtenerNivelDificultad(Scanner scanner) {
        System.out.println("Elige el nivel de dificultad:");
        System.out.println("1. Números de un dígito");
        System.out.println("2. Números de dos dígitos");
        System.out.println("3. Números de tres dígitos o más");
        
        return scanner.nextInt();
    }
    
    public static int obtenerTipoProblema(Scanner scanner) {
        System.out.println("Elige el tipo de problema:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Mezcla aleatoria");
        
        return scanner.nextInt();
    }
    
       public static String generarPregunta(int nivelDificultad, int tipoProblema) {
        Random random = new Random();
        
        int num1, num2;
        
        switch (nivelDificultad) {
            case 1:
                num1 = random.nextInt(9) + 1;
                num2 = random.nextInt(9) + 1;
                break;
            case 2:
                num1 = random.nextInt(99) + 1;
                num2 = random.nextInt(99) + 1;
                break;
            case 3:
                num1 = random.nextInt(999) + 1;
                num2 = random.nextInt(999) + 1;
                break;
            default:
                num1 = 0;
                num2 = 0;
                break;
        }
        
        String pregunta;
        int respuesta;
        
        switch (tipoProblema) {
            case 1:
                pregunta = "¿Cuánto es " + num1 + " + " + num2 + "?";
                respuesta = num1 + num2;
                break;
            case 2:
                pregunta = "¿Cuánto es " + num1 + " - " + num2 + "?";
                respuesta = num1 - num2;
                break;
            case 3:
                pregunta = "¿Cuánto es " + num1 + " * " + num2 + "?";
                respuesta = num1 * num2;
                break;
            case 4:
                num2 = random.nextInt(Math.min(num1, 999)) + 1;
                pregunta = "¿Cuánto es " + num1 + " / " + num2 + "?";
                respuesta = num1 / num2;
                break;
            case 5:
                int operadorIndex = random.nextInt(4);
                char operador;
                
                switch (operadorIndex) {
                    case 0:
                        pregunta = "¿Cuánto es " + num1 + " + " + num2 + "?";
                        respuesta = num1 + num2;
                        break;
                    case 1:
                        pregunta = "¿Cuánto es " + num1 + " - " + num2 + "?";
                        respuesta = num1 - num2;
                        break;
                    case 2:
                        pregunta = "¿Cuánto es " + num1 + " * " + num2 + "?";
                        respuesta = num1 * num2;
                        break;
                    case 3:
                        num2 = random.nextInt(Math.min(num1, 999)) + 1;
                        pregunta = "¿Cuánto es " + num1 + " / " + num2 + "?";
                        respuesta = num1 / num2;
                        break;
                    default:
                        pregunta = "";
                        respuesta = 0;
                        break;
                }
                break;
            default:
                pregunta = "";
                respuesta = 0;
                break;
        }
        
        
        return pregunta;
    }
    public static boolean verificarRespuesta(String pregunta, int respuesta) {
    int indiceUltimoEspacio = pregunta.lastIndexOf(" ");
    int num1 = Integer.parseInt(pregunta.substring(indiceUltimoEspacio + 1, pregunta.length() - 1));
    
    String[] partesPregunta = pregunta.split(" ");
    int num2 = Integer.parseInt(partesPregunta[2]);
    
    char operador = partesPregunta[3].charAt(0);
    
    switch (operador) {
        case '+':
            return respuesta == (num1 + num2);
        case '-':
            return respuesta == (num1 - num2);
        case '*':
            return respuesta == (num1 * num2);
        case '/':
            return respuesta == (num1 / num2);
        default:
            return false;
    }
}

    public static void darRetroalimentacion(boolean respuestaCorrecta) {
        String[] comentariosPositivos = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
        String[] comentariosNegativos = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.",
                                         "¡No te rindas!", "No. Sigue intentando."};
        
        if (respuestaCorrecta) {
            System.out.println(comentariosPositivos[new Random().nextInt(comentariosPositivos.length)]);
        } else {
            System.out.println(comentariosNegativos[new Random().nextInt(comentariosNegativos.length)]);
        }  
          } 
    }

   

