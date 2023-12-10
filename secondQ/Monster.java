package secondQ;


import java.lang.reflect.Field;
import java.util.*;

public class Monster {
	
	String eyeColor;
    String skinColor;
    String abilities;
    String size;
    String strength;
    String durability;
    String weakness;
    boolean defeatableByHumans;
    
    public Monster() {
    	//default constructor
    }
    
    public Monster(String eyeColor, String skinColor, String abilities,
                   String size, String strength, String durability, String weakness,
              boolean defeatableByHumans) {
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
        this.abilities = abilities;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.defeatableByHumans = defeatableByHumans;
    }

    public Monster(Monster parent) {
        this.eyeColor = parent.eyeColor;
        this.skinColor = parent.skinColor;
        this.abilities = parent.abilities;
        this.size = parent.size;
        this.strength = parent.strength;
        this.durability = parent.durability;
        this.weakness = parent.weakness;
        this.defeatableByHumans = parent.defeatableByHumans;
    }

    public void displayTraits() {
        System.out.println("Monster Traits:");
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Skin Color: " + skinColor);
        System.out.println("Abilities: " + abilities);
        System.out.println("Size: " + size);
        System.out.println("Strength: " + strength);
        System.out.println("Durability: " + durability);
        System.out.println("Weakness: " + weakness);
        System.out.println("Is the Monster deafeatable By Humans: " + defeatableByHumans);
    }

    private static Object getRandomTrait(Object traitValue1, Object traitValue2) {
        return Math.random() < 0.5 ? traitValue1 : traitValue2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster monster)) return false;
        return Objects.equals(eyeColor, monster.eyeColor) && Objects.equals(skinColor, monster.skinColor) && Objects.equals(abilities, monster.abilities) && Objects.equals(size, monster.size) && Objects.equals(strength, monster.strength) && Objects.equals(durability, monster.durability) && Objects.equals(weakness, monster.weakness) && Objects.equals(defeatableByHumans, monster.defeatableByHumans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eyeColor, skinColor, abilities, size, strength, durability, weakness, defeatableByHumans);
    }


    public static List<Monster> createBabyMonsters(Monster parent1, Monster parent2) {
        Set<Monster> children = new HashSet<>();

        Class<?> monsterClass = Monster.class;

        Field[] fields = monsterClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            try {
                
                Object traitValue1 = fields[i].get(parent1);
                Object traitValue2 = fields[i].get(parent2);
                
                Monster child1 = new Monster(parent1);
                Monster child2 = new Monster(parent2);
                fields[i].setAccessible(true);
                fields[i].set(child1, getRandomTrait(traitValue1, traitValue2));
                fields[i].set(child2, getRandomTrait(traitValue1, traitValue2));
                
                children.add(child1);
                children.add(child2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return children.stream().toList();
    }

}
