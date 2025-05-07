package codetest.test05;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Player {
	String name;
	String stone;

	Player(String name, String stone) {
		this.name = name;
		this.stone = stone;
	}

	public String getInput() {
		System.out.print(name + "> ");
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		return input;
	}
}

