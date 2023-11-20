package br.com.vainaweb.backendt3.desafios;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class MegaSena {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Vetor para armazenar números escolhidos pelo usuário
		int[]numerosEscolhidos = new int[7];
		
		int[] numerosSorteados = new int[7];
		
		// Sortear 7 números
		Random sorteio = new Random();
	
		int contador = 0;
		
		System.out.println("Sorteio MEGA-SENA Java \nEscolha 7 números inteiros de 0 a 100: ");
		
		while(contador < 7) {
			
			try {
				// Obter números do usuário
				numerosEscolhidos[contador] = sc.nextInt();
				contador++;
	
			}catch (InputMismatchException e) {
				System.err.println("você precisa digitar um inteiro! Tente novamente:");
				
				// Limpar buffer
				sc.nextLine();			
			}	
		}
		
		// Printar números escolhidos pelo usuário
		System.out.println("\nOs números escolhidos são: \n");
		for (int i = 0; i < numerosEscolhidos.length; i++) {
			System.out.println(numerosEscolhidos[i]);
		}
		
		System.out.println("\nOs números sorteados são: \n");
		for (int i = 0; i < numerosSorteados.length; i++) {
			
			// Sortear
			numerosSorteados[i] = sorteio.nextInt(101);
			System.out.println(numerosSorteados[i]);
		}
	
		int numerosCertos = 0;
		for (int numSorteado : numerosSorteados) {
			for (int numEscolhido : numerosEscolhidos ) {
				if (numSorteado == numEscolhido) {
					numerosCertos++;
				}
			}
		}
		
		if (numerosCertos == 5) {
			System.out.println("\nVocê acertou 5 números → Premio de 10 mil reais");
		}else if (numerosCertos == 6) {
			System.out.println("\nVocê acertou 6 números → Premio de 50 mil reais");
		}else if (numerosCertos == 7) {
			System.out.println("\nVocê acertou 7 números → Premio de 200 mil reais");
		}else {
			System.out.println("\nNão foi dessa vez :'(");
		}
		
		
		sc.close();
	}
}