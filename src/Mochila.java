import java.util.Scanner;


public class Mochila {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int pesos[] = new int[10];
		int valores[] = new int[10]; 
		
		System.out.println("Qual a capacidade da mochila?");
		int capacidade = s.nextInt();
		
		System.out.println("Quantida de ítens?");
		int qtd_itens = s.nextInt();
		
		for (int i=1; i<=qtd_itens; i++) {
			System.out.println("Digite o peso do ítem "+i);
				pesos[i] = s.nextInt();
			
			System.out.println("Digite o valor do ítem "+i);		
				valores[i] = s.nextInt();
			
		}
		
		String matriz[][] = new String[qtd_itens+1][capacidade+1];
		
		for (int i = 0; i<=qtd_itens; i++) {
			for (int j = 0; j<= capacidade; j++) {
				
				if (i==0 || j == 0){
					matriz[i][j] = "0";
				} else {
					if (pesos[i] > j){
					matriz[i][j] = matriz[i-1][j];
					} else {
						if (pesos[i] <= j) {
							int v1 = Integer.parseInt(matriz[i-1][j]);
							int v2 = Integer.parseInt(matriz[i-1][j-pesos[i]]) + valores[i];
							
							if(v1 > v2){
								matriz[i][j] = v1+"";
							} else {
								matriz[i][j] = v2+"";
							}
						}
					}
				}
			
			}
			
			System.out.println(+(i+1)+"º Iteração: \n");
			for (int k = 0; k < matriz.length; k++) {
				for (int l = 0; l <= matriz.length; l++) {
					System.out.printf(matriz[k][l] + "  ");
				}
				System.out.println();
			}
			
		}

	}
	
}
