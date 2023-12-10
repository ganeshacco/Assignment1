package secondQ;

import java.util.List;
import java.util.Scanner;

public class MonsterCreation {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Monster 1:");
        Monster parent1 = createMonster(scanner);
        System.out.println("\nCreate Monster 2:");
        Monster parent2 = createMonster(scanner);

        List<Monster> babyMonsters = Monster.createBabyMonsters(parent1, parent2);
        System.out.println("\nTotal number of child monsters created: "+babyMonsters.size());
        int i=1;
        for(Monster babyMonster: babyMonsters){
            System.out.println("\nBaby Monster Traits:"+i++);
            babyMonster.displayTraits();
        }
        scanner.close();
    }
    private static Monster createMonster(Scanner scanner) {
        System.out.print("Eye Color: ");
        String eyeColor = scanner.nextLine();
        System.out.print("Skin Color: ");
        String skinColor = scanner.nextLine();
        System.out.print(" Abilities: ");
        String abilities = scanner.nextLine();
        System.out.print("Size: ");
        String size = scanner.nextLine();
        System.out.print("Strength: ");
        String strength = scanner.nextLine();
        System.out.print("Durability: ");
        String durability = scanner.nextLine();
        System.out.print("Weakness: ");
        String weakness = scanner.nextLine();
        System.out.print("is it defeatableByHumans: ");
        boolean defeatableByHumans = scanner.nextBoolean();
        return new Monster(eyeColor, skinColor, abilities, size,
                strength, durability, weakness, defeatableByHumans);
    }

}
