package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
//	Player player = new Player();
//	player.name="Dan";
//    player.health=30;
//    player.weapon="Rifle";
//
//
//    int damage=10;
//    player.loseHealth(damage);
//    System.out.println("Remaining health " + player.healthRemaining());
//
//    damage=21;
//    player.loseHealth(damage);
//    System.out.println("Remaining health " + player.healthRemaining());

 EnhancedPlayer player = new EnhancedPlayer("Dan",200,"Sword");
        System.out.println("Initial health is " + player.getHealth());

    }
}