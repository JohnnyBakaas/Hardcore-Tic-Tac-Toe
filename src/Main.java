import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] [] bord = {
				{'T','T','T'},
				{'T','T','T'},
				{'T','T','T'}, };
	
		printUtBord(bord);
		
		char spiller = 'X';
		
		while (true) {
			
			System.out.println("Spiller " + spiller + ", hvor vil du plasere brikken din?");
			
			System.out.println("Først, velg mellom A, B og C");
			String brukerImputBokstav = sc.next();
			int brukerImputBokstavTilInt = 99;
			if (brukerImputBokstav.equals("A")) {
				brukerImputBokstavTilInt = 0;
			} else if (brukerImputBokstav.equals("B")) {
				brukerImputBokstavTilInt = 1;
			} else if (brukerImputBokstav.equals("C")) {
				brukerImputBokstavTilInt = 2;
			} else {
				System.out.println("Du er dum");
				break;
			}
			
			System.out.println("Så, velg mellom 1, 2 og 3");
			String brukerImputTall = sc.next();
			int brukerImputTallTilInt = 99;
			if (brukerImputTall.equals("1")) {
				brukerImputTallTilInt = 0;
			} else if (brukerImputTall.equals("2")) {
				brukerImputTallTilInt = 1;
			} else if (brukerImputTall.equals("3")) {
				brukerImputTallTilInt = 2;
			} else {
				System.out.println("Du er dum");
				break;
			}
			if (bord[brukerImputTallTilInt][brukerImputBokstavTilInt] == 'T') {
				bord[brukerImputTallTilInt][brukerImputBokstavTilInt] = spiller;
				printUtBord(bord);
			} else {
				char spiller2 = 'Y';
				if (spiller =='X') {
					spiller2 = 'O';
				} else {
					spiller2 = 'X';
				}
				
				System.out.println("Spiller " + spiller + " det er ikke lov! Som straff taper du. Gratulerer til " + spiller2 + " du vinner");
				break;
			}
			if (isWinner(spiller, bord)) {
				System.out.println("Gratulerer spiller " + spiller + "! Du vant!");
				break;
			}
				
			
			
			if (spiller =='X') {
				spiller = 'O';
			} else {
				spiller = 'X';
				
			}
			
			
			
		}
		
	}
	public static void printUtBord(char[][] navnPaArray) {
		System.out.println(" ABC");
		for (int i=0; i<3; i++) {
			System.out.print(i+1);
			for (int j=0; j<3; j++) {
				System.out.print(navnPaArray[i][j]);
				}
			System.out.println();
			}
		System.out.println();
	}
	private static boolean isWinner(char player, char[][] board) {
		
		//rows
		boolean row1 = (board[0][0] == player && board[0][1] == player && board[0][2] == player);
		boolean row2 = (board[1][0] == player && board[1][1] == player && board[1][2] == player);
		boolean row3 = (board[2][0] == player && board[2][1] == player && board[2][2] == player);
		
		//Columns
		boolean col1 = (board[0][0] == player && board[1][0] == player && board[2][0] == player);
		boolean col2 = (board[0][1] == player && board[1][1] == player && board[2][1] == player);
		boolean col3 = (board[0][2] == player && board[1][2] == player && board[2][2] == player);
		
		//Diagonal 
		boolean diag1 = (board[0][0] == player && board[1][1] == player && board[2][2] == player); 
		boolean diag2 = (board[0][2] == player && board[1][1] == player && board[2][0] == player); 
		
		return row1 || row2 || row3 || col1 || col2 || col3 || diag1 || diag2; 

	}

}
