package backjun;

import java.util.Arrays;

public class Game0248 {

	int box_size;
	int[][] box_value;
	int move_count = 0;

	public Game0248(int box_size, int[][] box_value) {
		super();
		this.box_size = box_size;
		this.box_value = box_value;
	}

	public int solution() {
		int answer = 0;

		return answer;
	}

	public void right() {
		System.out.println(Arrays.toString(box_value));
		for (int i = 0; i < box_size; i++) {
			for (int j = box_size - 1; j >= 0; j--) {
				if (j == box_size - 1) {
					if (box_value[i][j] == 0) {
						move_count++;
					}
				} else {
					if (box_value[i][j] == 0) {
						move_count++;
					} else if (box_value[i][j] != 0) {
						box_value[i][j + move_count] = box_value[i][j];
						box_value[i][j] = 0;
						move_count = 0;
					}
				}
			}
		}
		System.out.println(Arrays.toString(box_value));
	}

	public int[][] getBox_value() {
		return box_value;
	}

	public void left() {

	}

	public void up() {

	}

	public void down() {

	}

	@Override
	public String toString() {
		return "Game0248 [box_size=" + box_size + ", box_value=" + Arrays.toString(box_value) + ", move_count="
				+ move_count + "]";
	}

}
