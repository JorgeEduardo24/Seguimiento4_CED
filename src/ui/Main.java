package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static final String INYECTIVA = "INYECTVA"; 
	public static final String BIYECTIVA = "BIYECTIVA"; 
	public static final String SOBREYECTIVA = "SOBREYECTIVA"; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int elementosFaltantes = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> funcion = new HashMap<String,String>();
		
		System.out.println("Bienvenido !\nIngresa la cantidad de elementos del conjunto A: ");
		int cantidadElementosA = Integer.parseInt(br.readLine());
		String [] elementosA = new String[cantidadElementosA];
		System.out.println("Escriba los " +cantidadElementosA+ " elementos del conjunto A:");
		
		for(int i=0; i<cantidadElementosA;i++) {
			elementosA[i] = br.readLine();
		}
		
		System.out.println("Ingresa la cantidad de elementos del conjunto B: ");
		int cantidadElementosB = Integer.parseInt(br.readLine());
		String [] elementosB = new String[cantidadElementosB];
		System.out.println("Escriba los " +cantidadElementosB+ " elementos del conjunto B: ");
		
		for(int i=0; i<cantidadElementosB;i++) {
			elementosB[i]=br.readLine();
		}
		
		
		if(elementosA.length==elementosB.length) {
			for(int i=0; i<cantidadElementosA;i++) {
				funcion.put(elementosA[i], elementosB[i]);
			}
			
			System.out.println("Pares ordenados: ");
			for(Map.Entry m: funcion.entrySet()) {
				System.out.println("("+m.getKey()+" , "+m.getValue()+")");
			}
			System.out.println("Tipo de función: "+BIYECTIVA);
			
		}else if(elementosA.length>elementosB.length) {
			for(int i=0; i<cantidadElementosB;i++) {
				funcion.put(elementosA[i], elementosB[i]);
			}
			
			int j = 0;
			elementosFaltantes = cantidadElementosA - cantidadElementosB;
			while(j<elementosFaltantes) {
				funcion.put(elementosA[cantidadElementosB+j], funcion.get(elementosA[j]));
				j++;
			}
			
			System.out.println("Pares ordenados: ");
			for(Map.Entry m: funcion.entrySet()) {
				System.out.println("("+m.getKey()+" , "+m.getValue()+")");
			}
			System.out.println("Tipo de función: "+ SOBREYECTIVA);
		}
		
		else {
			for(int i=0; i<cantidadElementosA;i++) {
				funcion.put(elementosA[i], elementosB[i]);
			}
			
			int j = 0;
			elementosFaltantes = cantidadElementosB - cantidadElementosA;
			while(j<elementosFaltantes) {
				funcion.put(" ",elementosB[cantidadElementosA+j]);
				j++;
			}
			
			System.out.println("Pares ordenados: ");
			for(Map.Entry m: funcion.entrySet()) {
				System.out.println("("+m.getKey()+" , "+m.getValue()+")");
			}
			System.out.println("Tipo de función: "+ INYECTIVA);
		}
		
	}
}
