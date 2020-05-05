package Soru1Thread;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Piece implements Runnable
{
	
	volatile List<Integer> oddList;
	volatile List<Integer> evenList;
	List<Integer> liste;
	
	
	
	public  Piece(List<Integer> liste) {
		this.liste=liste;
		oddList=new ArrayList<Integer>(5000);
		evenList=new ArrayList<Integer>(5000);
	}
	
	@Override
	public void run() {
		Object lockObject=new Object();
		
		synchronized (lockObject) {
			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i)%2==0) {
					evenList.add(liste.get(i));
				}
				else {
					oddList.add(liste.get(i));
				}
			}
			
		}
	}

	

}
