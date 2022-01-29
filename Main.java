package com.greatLearning.dataStruc;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> linkedListData = new LinkedList<Integer>();
		System.out.println("enter the total no of floors in the building");
		int floorLen = sc.nextInt();
		for (int i = 1; i <= floorLen; i++) {
			System.out.println("enter the floor size given on day : " + i);
			linkedListData.add(sc.nextInt());
		}
		int j = 0;
		LinkedList<Integer> temp = new LinkedList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println("The order of construction is as follows");
		for (int i = j; i < linkedListData.size(); i++) {
			temp.add(linkedListData.get(i));
			int c = linkedListData.get(i);
			System.out.println("\nDay: " + (i + 1));
			boolean isFloorbig = true;
			for (int k = i + 1; k < linkedListData.size(); k++) {
				if (c < linkedListData.get(k)) {
					isFloorbig = false;
				}
			}

			if (isFloorbig) {
				Collections.sort(list, Collections.reverseOrder());
				for (int a = 0; a < list.size(); a++) {
					if(temp.getLast()>=list.get(a)) {
						temp.add(list.get(a));
						list.remove(list.get(a));
						break;
					}
				}
				Collections.sort(temp, Collections.reverseOrder());
				for (int a = 0; a < temp.size(); a++) {
					for(int b=i+1;b<linkedListData.size();b++) {
						if(temp.get(a)<linkedListData.get(b) && !list.contains(temp.get(a))) {
							list.add(temp.get(a));
							temp.remove(temp.get(a));
							if(temp.size()==a) {
								
								break;
							}
							a=0;
						}
					}
					
				}

				if(linkedListData.size()==i) {
					temp.add(list.getLast());
					list.remove(list.getLast());
				}
				Collections.sort(temp, Collections.reverseOrder());
				Iterator<Integer> itr = temp.iterator();
				while (itr.hasNext()) {
					System.out.print(itr.next() + " ");
				}
				temp.clear();
			}
		}
		j++;
		Collections.sort(temp, Collections.reverseOrder());
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
}
