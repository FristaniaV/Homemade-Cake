package homemadeCake;

import java.util.ArrayList;
import java.util.Scanner;

public class HomemadeCake {

	Scanner scan = new Scanner(System.in);

	ArrayList<String> flaList = new ArrayList<>();
	ArrayList<Integer> floList = new ArrayList<>();
	ArrayList<String> toppList = new ArrayList<>();
	ArrayList<Integer> sugarList = new ArrayList<>();
	ArrayList<Integer> bakedList = new ArrayList<>();

	String flavor;
	int flour;
	String topping;
	int sugar = 100;
	int cakeNum;
	int cakeNum2;
	String repTopping;

	public HomemadeCake() {

		Menu();
	}

	public void Menu() {

		int choose;

		do {
			System.out.println("HOMEMADE CAKE");
			System.out.println("=============");
			System.out.println("1. Add cake to bake");
			System.out.println("2. Bake cake");
			System.out.println("3. Change cake topping");
			System.out.println("4. View cake list");
			System.out.println("5. Exit");
			System.out.print("Choice: ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 404;
			}
			scan.nextLine();
		} while (choose < 1 || choose > 5);

		if (choose == 1) {
			Add();
		} else if (choose == 2) {
			Bake();
		} else if (choose == 3) {
			Change();
		} else if (choose == 4) {
			View();
		} else if (choose == 5) {
			System.exit(0);
		}

	}

	public void Add() {

		do {
			System.out.print("Choose cake flavor [Cheese | Chocolate | Vanilla](Case Sensitive): ");
			flavor = scan.nextLine();
		} while (!(flavor.equals("Cheese")) && !(flavor.equals("Chocolate")) && !(flavor.equals("Vanilla")));
		flaList.add(flavor);

		do {
			System.out.print("Input how many flour will be used (gram) [>0]: ");
			try {
				flour = scan.nextInt();
			} catch (Exception e) {
				flour = 404;
			}
			scan.nextLine();
		} while (flour < 1);
		floList.add(flour);

		do {
			System.out.print("Input your cake topping [Cream | Oreo](Case Sensitive): ");
			topping = scan.nextLine();
		} while (!(topping.equals("Cream")) && !(topping.equals("Oreo")));
		toppList.add(topping);

		sugarList.add(sugar);

		System.out.println("The cake is made!");
		System.out.println();
		System.out.println(flaList.size() + " cake(s) are in the list");
		System.out.println();
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();
	}

	public void Bake() {
		if (flaList.isEmpty()) {
			System.out.println("There is no cake that has been made yet!");
		} else {
			for (int i = 0; i < flaList.size(); i++) {
				System.out.println("Cake number " + (i + 1));
				System.out.println("===========");
				System.out.println("Cake flavor: " + flaList.get(i));
				System.out.println("Cake flour: " + floList.get(i));
				System.out.println("Cake sugar: " + sugarList.get(i));
				System.out.println("Cake topping: " + toppList.get(i));
				if (bakedList.isEmpty()) {
					System.out.println("The cake has not been baked yet");
				} else if (flaList.get(bakedList.get(i)-1).equals(flaList.get(i))){
					System.out.println("The cake is already baked");
				}
				System.out.println();
			}

			do {
				System.out.print("Input cake number [1.." + flaList.size() + "]: ");
				System.out.println();
				try {
					cakeNum = scan.nextInt();
				} catch (Exception e) {
					cakeNum = 404;
				}
				scan.nextLine();
			} while (cakeNum < 1 || cakeNum > flaList.size());

			bakedList.add(cakeNum);

			System.out.println("Mixing " + flaList.get(cakeNum - 1) + " flavor, " + floList.get(cakeNum - 1)
					+ " gram of flour, " + sugarList.get(cakeNum - 1) + " gram of sugar");
			System.out.println("Baking the cake..");
			System.out.println();
			System.out.println("Press any key to continue...");
			scan.nextLine();
			Menu();

		}
	}

	public void Change() {
		if (flaList.isEmpty()) {
			System.out.println("There is no cake that has been made yet!");
		} else {
			for (int i = 0; i < flaList.size(); i++) {
				System.out.println("Cake number " + (i + 1));
				System.out.println("===========");
				System.out.println("Cake flavor: " + flaList.get(i));
				System.out.println("Cake flour: " + floList.get(i));
				System.out.println("Cake sugar: " + sugarList.get(i));
				System.out.println("Cake topping: " + toppList.get(i));
				if (bakedList.isEmpty()) {
					System.out.println("The cake has not been baked yet");
				} else if (flaList.get(bakedList.get(i)-1).equals(flaList.get(i))){
					System.out.println("The cake is already baked");
				}
				System.out.println();
			}
			do {
				System.out.print("Input cake number [1.." + flaList.size() + "]: ");
				System.out.println();
				try {
					cakeNum2 = scan.nextInt();
				} catch (Exception e) {
					cakeNum2 = 404;
				}
				scan.nextLine();
			} while (cakeNum2 < 1 || cakeNum2 > flaList.size());

			do {
				System.out.print("Input your new cake topping [Cream | Oreo]: ");
				repTopping = scan.nextLine();
			} while (!(repTopping.equals("Cream")) && !(repTopping.equals("Oreo")));

			toppList.set(cakeNum2, repTopping);
			System.out.println("The topping is changed!");
			System.out.println();
			System.out.println("Press any key to continue...");
			scan.nextLine();
			Menu();
		}
	}

	public void View() {
		if (flaList.isEmpty()) {
			System.out.println("There is no cake that has been made yet!");
		} else {
			for (int i = 0; i < flaList.size(); i++) {
				System.out.println("Cake number " + (i + 1));
				System.out.println("===========");
				System.out.println("Cake flavor: " + flaList.get(i));
				System.out.println("Cake flour: " + floList.get(i));
				System.out.println("Cake sugar: " + sugarList.get(i));
				System.out.println("Cake topping: " + toppList.get(i));
				if (bakedList.isEmpty()) {
					System.out.println("The cake has not been baked yet");
				} else if (flaList.get(bakedList.get(i)-1).equals(flaList.get(i))) {
					System.out.println("The cake is already baked");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Press any key to continue...");
			scan.nextLine();
			Menu();
		}
	}

	public static void main(String[] args) {
		new HomemadeCake();
	}

}
