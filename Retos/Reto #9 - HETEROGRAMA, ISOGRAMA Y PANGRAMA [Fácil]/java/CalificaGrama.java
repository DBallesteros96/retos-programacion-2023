/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.calificagrama;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */

/*Dada una frase la califica en heterograma, isograma o pangrama*/
public class CalificaGrama {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Map<String, Integer> mapa = new HashMap<>() {
            {
                put("a", 0);
                put("b", 0);
                put("c", 0);
                put("d", 0);
                put("e", 0);
                put("f", 0);
                put("g", 0);
                put("h", 0);
                put("i", 0);
                put("k", 0);
                put("l", 0);
                put("m", 0);
                put("n", 0);
                put("o", 0);
                put("p", 0);
                put("q", 0);
                put("r", 0);
                put("s", 0);
                put("t", 0);
                put("u", 0);
                put("v", 0);
                put("w", 0);
                put("x", 0);
                put("y", 0);
                put("z", 0);
            }
        };

        System.out.println("Comprobar tipo de frase.");
        System.out.print("Introduzca la frase a comprobar: ");
        String frase = teclado.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.toLowerCase().charAt(i);
            try {
                mapa.put(Character.toString(caracter), mapa.get(Character.toString(caracter)) + 1);
            } catch (Exception e) {
                //Ignorará los caracteres que no se encuentren en el diccionario
            }

        }

        /*
        for (Map.Entry entry : mapa.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", valor: " + entry.getValue());
        }*/
        compruebaHeterograma(mapa);
        compruebaIsograma(mapa);
        compruebaPangrama(mapa);

    }

    public static boolean compruebaHeterograma(Map<String, Integer> mapa) {

        //Un heterograma es una frase que no contiene ninguna letra repetida.
        for (int cantidad : mapa.values()) {
            if (cantidad > 1) {
                System.out.println("NO es un heterograma.");
                return false;
            }
        }
        System.out.println("SI es un heterograma.");
        return true;
    }

    public static boolean compruebaIsograma(Map<String, Integer> mapa) {

        //Un isograma es una palabra o frase en la que cada letra aparece el mismo número de veces
        int numero = 0;
        for (int cantidad : mapa.values()) {
            if (cantidad != 0) {
                if (numero == 0) {
                    numero = cantidad;
                } else {
                    if (cantidad != numero) {
                        System.out.println("NO es un isograma.");
                        return false;
                    }
                }

            }
        }
        System.out.println("SÍ es un isograma.");
        return true;
    }
    
    public static boolean compruebaPangrama(Map<String, Integer> mapa){
        
        //Un pangrama es una frase que contiene todas las letras del abecedario
        for (int cantidad : mapa.values()){
            if(cantidad == 0){
                System.out.println("NO es un pangrama.");
                return false;
            }
        }
        System.out.println("SÍ es un pangrama.");
        return true;
    }
}
