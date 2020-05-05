package Soru1Thread;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> liste=new ArrayList<Integer>(10000);
		for (int i = 1; i <= 10000; i++) {
			liste.add(i);
		}
		
		List<Integer> oddIntegers=new ArrayList<Integer>();
		List<Integer> evenIntegers=new ArrayList<Integer>();
		
		
		List<Integer> parca1=liste.subList(1, 2500);
		List<Integer> parca2=liste.subList(2501, 5000);
		List<Integer> parca3=liste.subList(5001, 7500);
		List<Integer> parca4=liste.subList(7501, 10000);
		
		
		Piece piece1=new Piece(parca1);
		Piece piece2=new Piece(parca2);
		Piece piece3=new Piece(parca3);
		Piece piece4=new Piece(parca4);
		
		
		Thread thread1=new Thread(piece1);
		Thread thread2=new Thread(piece2);
		Thread thread3=new Thread(piece3);
		Thread thread4=new Thread(piece4);
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		oddIntegers.addAll(piece1.oddList);
		oddIntegers.addAll(piece2.oddList);
		oddIntegers.addAll(piece3.oddList);
		oddIntegers.addAll(piece4.oddList);

		evenIntegers.addAll(piece1.evenList);
		evenIntegers.addAll(piece2.evenList);
		evenIntegers.addAll(piece3.evenList);
		evenIntegers.addAll(piece4.evenList);

		
		

	}
}
