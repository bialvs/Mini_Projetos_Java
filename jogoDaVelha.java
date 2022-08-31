import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class jogoDaVelha {
	
	static ArrayList<Integer> posicaoJogador = new ArrayList<Integer>();
	static ArrayList<Integer> posicaoCpu = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char [] [] tabelaJogo = {{' ', '|',' ','|',' '}, {'-', '-','-','-','-'}, {' ', '|',' ','|',' '}, {'-', '-','-','-','-'}, {' ', '|',' ','|',' '}};
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Selecione sua posição entre 1 e 9:");
			int posicaoJogador = sc.nextInt();
		
			locPeca(tabelaJogo, posicaoJogador, "jogador");
			
			Random rd = new Random();
			int posicaoCpu = rd.nextInt(9) + 1;
			locPeca(tabelaJogo, posicaoCpu, "cpu");
				
			
			printTabelaJogo(tabelaJogo);
			
			String resultado = vencedor();
			System.out.println(resultado);
				
		}
	}
	public static void printTabelaJogo(char [] [] tabelaJogo) {
		
		for(char[] coluna : tabelaJogo) {
			for(char c : coluna) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void locPeca(char[] [] tabelaJogo, int posicao, String usuario) {
		
		char simbolo = ' ';
		
		if(usuario.equals("jogador")) {
			simbolo = 'X';
			posicaoJogador.add(posicao);
		} else if(usuario.equals("cpu")) {
			simbolo = 'O';
			posicaoCpu.add(posicao);
		}
		
		switch(posicao){
			case 1:
				tabelaJogo [0] [0] = simbolo;
				break;
			case 2:
				tabelaJogo [0] [2] = simbolo;
				break;
			case 3:
				tabelaJogo [0] [4] = simbolo;
				break;
			case 4:
				tabelaJogo [2] [0] = simbolo;
				break;
			case 5:
				tabelaJogo [2] [2] = simbolo;
				break;
			case 6:
				tabelaJogo [2] [4] = simbolo;
				break;
			case 7:
				tabelaJogo [4] [0] = simbolo;
				break;
			case 8:
				tabelaJogo [4] [2] = simbolo;
				break;
			case 9:
				tabelaJogo [4] [4] = simbolo;
				break;
			
	}
		
	}
	
	public static String vencedor() {
		
		List topoLinha = Arrays.asList(1,2,3);
		List meioLinha = Arrays.asList(4,5,6);
		List finalLinha = Arrays.asList(7,8,9);
		List esquerdoColuna = Arrays.asList(1,4,7);
		List meioColuna = Arrays.asList(2,5,8);
		List direitaColuna = Arrays.asList(3,6,9);
		List diagonal1 = Arrays.asList(3,5,7);
		List diagonal2 = Arrays.asList(1,5,9);
		
		List<List> condicaoVencedor = new ArrayList<List>();
		condicaoVencedor.add(topoLinha);	
		condicaoVencedor.add(meioLinha);
		condicaoVencedor.add(finalLinha);
		condicaoVencedor.add(esquerdoColuna);
		condicaoVencedor.add(meioColuna);
		condicaoVencedor.add(direitaColuna);
		condicaoVencedor.add(diagonal1);
		condicaoVencedor.add(diagonal2);
		
		for(List l : condicaoVencedor) {
			if(posicaoJogador.containsAll(l)) {
				return "Parabens voce venceu!";
			} else if (posicaoCpu.contains(l)) {
				return "Que pena! Tente novamente.";
			} else if (posicaoJogador.size() + posicaoCpu.size() == 9) {
				return "Velha!";
			}
		}
		
		return"";
	}
 
}
