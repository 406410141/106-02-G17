package tetris;

public class Selection {

	private int select;
	
	final int START = 1;
	final int SETTING = 2;
	final int LEADERBOARD = 3;
	
	public void setSelection(int select) {
		switch(select) {
		case 1:
			System.out.println("Start the game");
			//gaming(); �}�l�C��
			break;
			
		case 2:
			System.out.println("Setting");
			//setting(); �i�J�]�w
			break;
			
		case 3:
			System.out.println("Leaderboard");
			//leaderboard(); �i�J�Ʀ�]
			break;
		}
	}
}
