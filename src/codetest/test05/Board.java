package codetest.test05;

public class Board {
    int size;
    String[][] map;

    Board(int size) {
        this.size = size;
        map = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
    }
    public void print() {

        for (int row = 0; row < size; row++) {
        	System.out.printf("%2d", row);
            for (int col = 0; col < size; col++) {
                System.out.print(" " + map[row][col]);
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int col = 'A'; col <= 'S'; col++) {
            System.out.print(" " + (char)col);
        }
        System.out.println();
    }
    
	public boolean playOmok(String pos, Player player) {
		String[] pos_rc = pos.split(" ");
		
		int row = Integer.parseInt(pos_rc[1]);
		int col = Integer.parseInt(String.valueOf(pos_rc[0].toUpperCase().charAt(0) - 65));

		while(true) {
			if(col > 18 || row > 18 || !map[row][col].equals(".")) {
	    		System.out.println("이 위치에 돌을 놓을 수 없습니다. 다시 입력해 주세요");
			} else if (!isThreeThree(player, row, col)) {
				System.out.println("이 위치는 33룰에 의해 돌을 놓을 수 없습니다. 다시 입력해 주세요");
			} else {
				break;
			}

			String new_pos = player.getInput();
			String[] new_pos_rc = new_pos.split(" ");
			row = Integer.parseInt(new_pos_rc[1]);
			col = Integer.parseInt(String.valueOf(new_pos_rc[0].toUpperCase().charAt(0) - 65));
			System.out.println(row + " " + col);
		}
    	
    	map[row][col] = player.getStone();
    	
    	print();
    	return isOmok(player, row, col);
    }
    
	public boolean isThreeThree(Player player, int row, int col) {
		int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dx = { 0, 0, -1, 1, -1, 1, 1, -1 }; // dfs
		int y = row;
		int x = col;
		int cnt3 = 0;
		for (int i = 0; i < 8; i += 2) {
			int cnt = 1;
			while (true) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= size || nx >= size || map[ny][nx].equals(".")) {
					break;
				}
				if (!map[ny][nx].equals(player.stone)) {
					cnt = 1;
					break;
				}
				cnt++;
				y = ny;
				x = nx;
			}
			y = row;
			x = col;
			while (true) {
				int ny = y + dy[i + 1];
				int nx = x + dx[i + 1];
				if (ny < 0 || nx < 0 || ny >= size || nx >= size || map[ny][nx].equals(".")) {
					break;
				}
				if (!map[ny][nx].equals(player.stone)) {
					cnt = 1;
					break;
				}
				cnt++;
				y = ny;
				x = nx;
			}
			if (cnt == 3) {
				cnt3++;
			}
		}
		if (cnt3 >= 2) {
			return false;
		}
		return true;

	}

    public boolean isOmok(Player player, int row, int col) {
		int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dx = { 0, 0, -1, 1, -1, 1, 1, -1 };
    	int y = row;
    	int x = col;
    	for(int i=0;i<8;i+=2) {
    		int cnt = 1;
    		while(true) {
    			int ny = y + dy[i];
    			int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= size || nx >= size || !map[ny][nx].equals(player.stone)
						|| map[ny][nx].equals(".")) {
					break;
				} else {
					cnt++;
				}
    			y = ny;
    			x = nx;
    		}
    		y = row;
    		x = col;
    		while(true) {
    			int ny = y + dy[i+1];
    			int nx = x + dx[i+1];
				if (ny < 0 || nx < 0 || ny >= size || nx >= size || !map[ny][nx].equals(player.stone)
						|| map[ny][nx].equals(".")) {
					break;
				} else {
					cnt++;
				}
    			y = ny;
    			x = nx;
    		}
			if (cnt == 5) {
    			System.out.println(player.name + "님이 승리하셨습니다.");
    			return true;
    		}
    	}
    	return false;
    	 
    }
}