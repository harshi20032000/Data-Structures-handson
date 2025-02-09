package com.indiavisualisedsa.ds_visualiser.elshad_karimov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Arraylist {

	public static void main(String[] args) {
		ArrayList<String> bikes = new ArrayList<>();
		bikes.add("Hero Xpulse 200");
		bikes.add("Hero Xoom 160");
		bikes.add("Hero Xtreme 250");
		bikes.add("Hero Maveric 450");
		bikes.add("Honda CB350");
		bikes.add("Honda CBR200");
		bikes.add("Yamaha Aerox169");
		bikes.add("Yamaha MT15");
		bikes.add("Suzuki V-strom");
		bikes.add("Honda NX500");
		bikes.add("Honda XL750 Transalp");
		bikes.add("BMW G 310 GS");
		bikes.add("Royal Enfield Himalayan 450");
		bikes.add("Royal Enfield Hunter 350");
		bikes.add("Royal Enfield Meteor 350");
		bikes.add("Hero Xpulse 210");
		System.out.println("Size: "+bikes.size());
		System.out.println(bikes.get(bikes.size()-1));
		System.out.println(bikes.get(0));
		System.out.println("Iterating using for loop");
		//Iterating using for loop
		for(int i=0; i<bikes.size(); i++) {
			System.out.print(bikes.get(i)+", ");
		}
		System.out.println();
		System.out.println("Iterating using while loop");
		//Iterating using while loop
		int i=0; 
		while(i<bikes.size()) {
			System.out.print(bikes.get(i)+", ");
			i++;
		}
		System.out.println();
		System.out.println("Iterating using advance for loop");
		//Iterating using advance for loop
		for (String e : bikes) {
			System.out.print(e+", ");
		}
		System.out.println();
		System.out.println("Iterating using iterator loop");
		//Iterating using iterator loop
		Iterator<String> iterator = bikes.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next()+", ");
		System.out.println();
		System.out.println("Iterating using forEach loop");
		//Iterating using forEach loop
		bikes.forEach(e -> System.out.print(e+", "));
		System.out.println();
		System.out.println("Iterating using enumeration loop");
		//Iterating using enumeration loop
		Enumeration<String> enumeration = Collections.enumeration(bikes);
		while(enumeration.hasMoreElements())
			System.out.print(enumeration.nextElement()+", ");
		System.out.println();
		System.out.println("Learning streams different functions");
		System.out.println("Printing all bikes having Hero in it.");
		//Iterating using streams loop
		List<String> filteredList = bikes.stream().filter(e -> e.startsWith("Hero")).collect(Collectors.toList());
		filteredList.forEach(e -> System.out.println(e+", "));
		System.out.println("Sorting: ");
		bikes.stream().sorted().forEach(e ->System.out.print(e+", "));
		System.out.println();
		System.out.println("Transforming all Strings here in upper case.");
		bikes.stream().map(String::toUpperCase).forEach(e -> System.out.print(e+", "));
	}

}
