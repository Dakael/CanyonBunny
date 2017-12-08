package com.adamkayla.canyonbunny;

public class CupRunner {

	public static void main(String[] args) {
		Cup greenCup = new Cup("Green");
		Cup blueCup = new Cup("Blue");
		
		System.out.println(greenCup.color);
		blueCup.setColor("Wewo");
		System.out.println(blueCup.color);
	}

}
