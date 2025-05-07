package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRunner {

	public static void main(String[] args) {

		List<Board> list = new ArrayList<>();
		
		list.add(new Board("title1", "content1", "writer1"));
		list.add(new Board("title2", "content2", "writer2"));
		list.add(new Board("title3", "content3", "writer3"));
		list.add(new Board("title4", "content4", "writer4"));
		list.add(new Board("title5", "content5", "writer5"));

		int size = list.size();

		System.out.println("Object size : " + size);
		System.out.println();

		Board board = list.get(2);

		System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());

		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
		System.out.println();

		list.remove(2);
		list.remove(2);

		for (Board b : list) {
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}

	}

}
