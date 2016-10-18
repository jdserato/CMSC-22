package Lab-6---RPG;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public class RPG {

    private Random rand = new Random();
    public static final int START_LEVEL = 1;
    public static final int FLEE_PROBABILITY = 8; // there is a 25% of flee probability
    public static final int HIGHER_FLEE_PROBABILITY = 4; // there is a 50% of flee probability
    public static final int SA_PROBABILITY = 5; // there is a 40% of special attack hit
    public static final int HIGHER_SA_PROBABILITY = 3; // there is a 67% of special attack hit

    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
        String[] monsters = {
                "Ogre", // has attribute FORTIFY (up-armor) (by 1/3 chance) or VIGOR (absorbs health) (secondary attribute; by 1/3 chance)
                "Elf", // has attribute TACTICS (up-attack) (by 1/3 chance) or MAGNIFY (increase accuracy) (secondary attribute: by 2/9 chance)
                "Zombie", // has attribute INFECTION (decrease enemy health) (by 1/2 chance) or SPIT (decrease enemy accuracy (secondary attribute; by 1/4 chance)
                "Dragon" // has attribute REGENERATION (increase self health) (by 1/2 chance) and/or FIRE BREATH (by 2/7 chance)
        };
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    // coin toss
    public boolean coinToss(int k) {
        int rand = randInt(0, k - 1);
//        System.out.println("Options are up to " + (k - 1) + ". The coin says " + rand + ".");
//        sleep(500);
        return (rand <= 1);
    }

    // pause the game for awhile for dramatic effect!
    public static void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // display pre-game
    public static void display(String name){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Which one would you want to know, " + name + "?\n" +
            "1. General\n" +
            "2. Heroes\n" +
            "3. Monsters\n" +
            "4. EXIT");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Well, you are to choose which hero you want to play.");
                    sleep(1000);
                    System.out.println("These are Swordsman, Archer, or Giant. You can know more of them in Module 2.");
                    sleep(2000);
                    System.out.println("Each of the heroes has four abilities. (1) Attack, (2) Special Attack, (3) Accuracy Loss, and (4) Flee.");
                    sleep(3500);
                    System.out.println("(1) Attack - can not usually be dodged!");
                    sleep(1500);
                    System.out.println("(2) Special Attack - are stronger than Attack but can be dodged (usually 40% chance of hit)!");
                    sleep(3000);
                    System.out.println("(3) Accuracy Loss - can decrease accuracy of enemy!");
                    sleep(1500);
                    System.out.println("(4) Flee - chance to escape the duel (only 25% if health is greater than 10 HP)!");
                    sleep(3500);
                    System.out.println("The Monster is randomly selected and has certain attributes. You can learn more about them in Module 3.");
                    sleep(5000);
                    System.out.println("The game is over when the hero flees or one died.");
                    sleep(2000);
                    System.out.println("That's all you really need to know!");
                    sleep(1500);
                    break;
                case 2:
                    System.out.println("There are three heroes in this gameplay: (1) Swordsman, (2) Archer, (3) Giant");
                    sleep(3000);
                    System.out.println("First is the SWORDSMAN.");
                    sleep(1500);
                    System.out.println("The Swordsman is a brave soldier ready for a close-fight combat.");
                    sleep(2800);
                    System.out.println("The Swordsman has the following stats:");
                    sleep(1500);
                    System.out.println("Initial Health: 35");
                    sleep(1250);
                    System.out.println("Quick Attack: 5");
                    sleep(1250);
                    System.out.println("Armor: 4");
                    sleep(1250);
                    System.out.println("Special Attack: 10");
                    sleep(1250);
                    System.out.println("Although nothing is really special in this Swordsman, it has the stable stats.");
                    sleep(2500);
                    System.out.println("Second is the ARCHER.");
                    sleep(1500);
                    System.out.println("The Archer is an accurate soldier best at a far-target combat.");
                    sleep(2800);
                    System.out.println("The Archer has the following stats:");
                    sleep(1500);
                    System.out.println("Initial Health: 25");
                    sleep(1250);
                    System.out.println("Quick Attack: 5");
                    sleep(1250);
                    System.out.println("Armor: 3");
                    sleep(1250);
                    System.out.println("Special Attack: 12");
                    sleep(1250);
                    System.out.println("Despite of its vulnerability, its accuracy is almost perfect.");
                    sleep(2500);
                    System.out.println("Third is the GIANT.");
                    sleep(1500);
                    System.out.println("The Giant is a gigantic soldier best at a combat with stronger enemies.");
                    sleep(2800);
                    System.out.println("The Giant has the following stats:");
                    sleep(1500);
                    System.out.println("Initial Health: 50");
                    sleep(1250);
                    System.out.println("Quick Attack: 5");
                    sleep(1250);
                    System.out.println("Armor: 7");
                    sleep(1250);
                    System.out.println("Special Attack: 7");
                    sleep(1250);
                    System.out.println("It has enormous health and armor but relatively low on Attacks.");
                    sleep(2500);
                    System.out.println("That's all you need to know about Heroes.");
                    sleep(2250);
                    break;
                case 3:
                    System.out.println("There are four monsters in this gameplay: (1) Ogre, (2) Elf, (3) Zombie, (4) Dragon");
                    sleep(3000);
                    System.out.println("Although all of them have the same range of health, each of them has different attributes");
                    sleep(3175);
                    System.out.println("First is the OGRE.");
                    sleep(1500);
                    System.out.println("The Ogre is a blacksmith and has the power to do evil magic.");
                    sleep(2800);
                    System.out.println("The Ogre has the following stats:");
                    sleep(1500);
                    System.out.println("(1) Fortify - the Ogre can increase its armor, 33% chance");
                    sleep(2000);
                    System.out.println("(2) Vigor - the Ogre can absorb its enemy's HP by 1, 33% chance.");
                    sleep(2000);
                    System.out.println("Second is the ELF.");
                    sleep(1500);
                    System.out.println("The Elf is a smart monster that can learn the techniques of its enemy.");
                    sleep(2800);
                    System.out.println("The Elf has the following stats:");
                    sleep(1500);
                    System.out.println("(1) TACTICS - the Elf can increase its attack, 33% chance.");
                    sleep(2000);
                    System.out.println("(2) MAGNIFY - the Elf can increase its accuracy, 22% chance.");
                    sleep(2000);
                    System.out.println("Third is the ZOMBIE.");
                    sleep(1500);
                    System.out.println("The Zombie is a monster that scares its enemy.");
                    sleep(2800);
                    System.out.println("The Zombie has the following stats:");
                    sleep(1500);
                    System.out.println("(1) INFECTION - the Zombie can cut its enemy's health by 2, 33% chance.");
                    sleep(2000);
                    System.out.println("(2) SPIT - the Zombie can cut its enemy's accuracy by 2, 25% chance.");
                    sleep(2000);
                    System.out.println("Fourth is the DRAGON.");
                    sleep(1500);
                    System.out.println("The Dragon is a huge monster that takes care of its own.");
                    sleep(2800);
                    System.out.println("The Dragon has the following stats:");
                    sleep(1500);
                    System.out.println("(1) REGENERATION - the Dragon can increase its own health by 2, 50% chance.");
                    sleep(2000);
                    System.out.println("(2) FIRE BREATH - the Dragon can increase its own attack by 1, 30% chance.");
                    sleep(2000);
                    System.out.println("That's all you need to know about Monsters.");
                    sleep(2250);
                    break;
                case 4:
                    System.out.println("Are you ready? HERE WE GO! In ");
                    System.out.println("5");
                    sleep(1000);
                    System.out.println("4");
                    sleep(1000);
                    System.out.println("3");
                    sleep(1000);
                    System.out.println("2");
                    sleep(1000);
                    System.out.println("1");
                    sleep(1000);
                    System.out.println("0");
                    sleep(1000);
                    System.out.println("\n\n\n\n\n\n\n\n");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Input");
            }
        }while(choice != 4);
    }

    // to display and choose attack
    public int chooseAttack(Hero attacker){
        Scanner sc = new Scanner(System.in);
        System.out.println("What will you do?");
        System.out.println(attacker.moves());
        return sc.nextInt();
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender, int choice) {
        int remHp = 1;
        Hero hero = null;
        Monster monster = null;
        if (choice == 1){
            hero = (Hero) attacker;
        }
        else{
            monster = (Monster) attacker;
        }

        // Attack Stage
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(500);
        int monsterDamage = attacker.attack();
        int heroDamage = 0;
        int c = 0;
        if (choice == 1) {
            c = chooseAttack(hero);
        }
        if (coinToss((int) ((attacker.getMaximumAccuracy() - attacker.getAccuracy()) * 2) + 1)) {
            if (choice == 1) {
                switch (c) {
                    case 1:
                        System.out.println(attacker.getName() + " used Attack!");
                        //System.out.println("Monster dealt " + attacker.attack() + " HP of damage.");
                        heroDamage = attacker.attack();
                        break;
                    case 2:
                        System.out.println(attacker.getName() + " used the Special Attack!");
                        sleep(1000);
                        if (attacker.getName().toCharArray()[0] == 'A') {
                            if (coinToss(HIGHER_SA_PROBABILITY)) {
                                heroDamage = hero.getSpecialAttack();
                            } else {
                                System.out.println("But " + defender.getName() + " has dodged.");
                                heroDamage = 0;
                            }
                        } else if (coinToss(SA_PROBABILITY)) {
                            heroDamage = hero.getSpecialAttack();
                        } else {
                            System.out.println("But " + defender.getName() + " has dodged.");
                            heroDamage = 0;
                        }
                        break;
                    case 3:
                        if (defender.getAccuracy() > 1) {
                            defender.setAccuracy(defender.getAccuracy() - 0.5);
                            System.out.println("Enemy's accuracy successfully fell!");
                            heroDamage = 0;
                        } else {
                            System.out.println("Enemy's accuracy cannot go down any further!");
                        }
                        break;
                    case 4:
                        if (attacker.getHp() <= 10) {
                            if (coinToss(HIGHER_FLEE_PROBABILITY)) {
                                System.out.println("Successfully flee!");
                                return true;
                            }
                        }
                        if (coinToss(FLEE_PROBABILITY)) {
                            System.out.println("Successfully flee!");
                            return true;
                        } else {
                            System.out.println("Cannot flee!");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input");
                }
                sleep(1000);
            }

            // Damage Dealing Phase
            if (choice == 1 && heroDamage > defender.getArmor()){
                remHp = defender.takeDamage(heroDamage);
                System.out.println(defender.getName() + " dealt " + (heroDamage - defender.getArmor()) + " HP of damage.");
                sleep(500);
                hero.setEXP(hero.getEXP() + heroDamage);
                System.out.print("Received " + heroDamage + " EXP. Now your EXP reached " + hero.getEXP());
                if (hero.getEXP() >= hero.getExpLevelUp() * hero.getLevel()) {
                    hero.setLevel(hero.getLevel() + 1);
                    System.out.printf(". You have levelled up to %d!\n", hero.getLevel());
                    sleep(450);
                    System.out.println("You gained 5 HP.");
                    hero.setHp(hero.getHp() + 5);
                }
                else {
                    System.out.print(" and your Level is at " + hero.getLevel() + ".\n");
                }
            }
            else if (choice == 1 && heroDamage <= defender.getArmor() && heroDamage > 0) {
                System.out.println(defender.getName() + " negated " + attacker.getName() + "'s attack!");
            }
            else if (choice == 2 && monsterDamage <= defender.getArmor() && monsterDamage > 0) {
                System.out.println(defender.getName() + " negated " + attacker.getName() + "'s attack!");
            }
            else if (choice == 2 && monsterDamage > defender.getArmor()){
                remHp = defender.takeDamage(monsterDamage);
                System.out.println(attacker.getName() + " has dealt " + (monsterDamage - defender.getArmor()) + " HP to " + defender.getName() + ".");
            }
            sleep(1500);


        } else {
            System.out.println(defender.getName() + " has dodged.");
        }

        // Applying Monster Attributes EVEN IF Hero dodged
        if (choice == 2){
            sleep(1500);
            for (int i = 1; attacker.getName().toCharArray()[i] != '\0'; i++){
                if (attacker.getName().toCharArray()[i] == 'O') { //'O' for Ogre Attribute
                    if (coinToss(6) && monster.getArmor() < 5) {
                        System.out.println(attacker.getName() + " raised its armor due to FORTIFY!");
                        monster.setArmor(monster.getArmor() + 1);
                    }
                    else if (coinToss(6)) {
                        System.out.println(attacker.getName() + " absorbed " + defender.getName() + "'s HP due to VIGOR!");
                        monster.setHp(monster.getHp() + 1);
                        defender.setHp(defender.getHp() - 1);
                    }
                    break;
                }
                else if (attacker.getName().toCharArray()[i] == 'E') { //'E' for Elf Attribute
                    if (coinToss(6)  && monster.getAttackDamage() < 16) {
                        System.out.println(attacker.getName() + " raised its attack due to TACTICS!");
                        monster.setAttackDamage(monster.getAttackDamage() + 1);
                    }
                    else if (coinToss(9) && attacker.getAccuracy() < attacker.getMaximumAccuracy()){
                        System.out.println(attacker.getName() + " raised its own accuracy due to MAGNIFY!");
                        attacker.setAccuracy(attacker.getAccuracy() + 0.5);
                    }
                    break;
                }
                else if (attacker.getName().toCharArray()[i] == 'Z') { //'Z' for Zombie Attribute
                    if (coinToss(6) && defender.getHp() >= 2) {
                        System.out.println(attacker.getName() + " has cut " + defender.getName() + "'s HP due to INFECTION!");
                        defender.setHp(defender.getHp() - 2);
                    }
                    else if (coinToss(8) && defender.getAccuracy() > 1) {
                        System.out.println(attacker.getName() + " has cut " + defender.getName() + "'s accuracy due to SPIT!");
                        defender.setAccuracy(defender.getAccuracy() - 0.5);
                    }
                    break;
                }
                else if (attacker.getName().toCharArray()[i] == 'D') { //'D' for Dragon Attribute
                    if (coinToss(4)) {
                        System.out.println(attacker.getName() + " has increased its HP due to REGENERATION!");
                        attacker.setHp(attacker.getHp() + 2);
                    }
                    if (coinToss(7)) {
                        System.out.println(attacker.getName() + " has increased its attack due to FIRE BREATH!");
                        monster.setAttackDamage(monster.getAttackDamage() + 1);
                    }
                    break;
                }
            }
            sleep(500);
        }

        // Aftermath Phase
        if (defender.getHp() > 0 && defender.getHp() <= 10){
            System.out.println(defender.getName() + " is growling deeply.");
            sleep(250);
        }
        if (remHp <= 0) {
            System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
            return true;
        }

        sleep(2000);
        return false;
    }

    // game...
    public static void main(String[] args) {
        RPGCharacter hero;
        RPG rpg = new RPG();

        // Welcoming Remarks
        System.out.println("Welcome to the game of all time - the RPG!");

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String playerName = sc.nextLine();

        System.out.println("Do you want to know what this game is all about?\n1. Yes\n2. No");
        int know = sc.nextInt();

        if (know == 1){
            display(playerName);
        }

        System.out.print("Please choose your hero:\n" +
                "1. Swordsman\n" +
                "2. Archer\n" +
                "3. Giant\n");
        int choice = sc.nextInt();
        if (choice < 0 || choice > 3){
            throw new IllegalArgumentException("Invalid input.");
        }
        if (choice == 1){
            hero = new Swordsman("Swordsman " + playerName, START_LEVEL);
        }
        else if (choice == 2){
            hero = new Archer("Archer " + playerName, START_LEVEL);
        }
        else{
            hero = new Giant("Giant " + playerName, START_LEVEL);
        }

        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(25, 60), rpg.randInt(8, 15));

        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count + " ==");
            // hero's turn
            boolean heroVsMonster = rpg.duel(hero, monster, 1);
            if (heroVsMonster) break;


            // monster's turn
            boolean monsterVsHero = rpg.duel(monster, hero, 2);
            if (monsterVsHero) break;

            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
    }
}
