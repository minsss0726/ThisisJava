package codetest.test05;

//Runner
public class OmokRunner {

	public static void main(String[] args) {
		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board = new Board(19);
		play(board, user, computer);
	}

	private static void play(Board board, Player user, Player computer) {
		board.print();

		while (true) {


			String user_input = user.getInput();
			if (board.playOmok(user_input, user)) {
				break;
			}


			String com_input = computer.getInput();
			if (board.playOmok(com_input, computer)) {
				break;
			}
		}

	}

}

