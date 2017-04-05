package com.hacker.rank.ds.stack.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class Checker implements Comparator{

    public int compare(Object a, Object b) {
        Player p1 = (Player) a;
        Player p2 = (Player) b;
        int returnValue;
        returnValue = p2.score -p1.score;
        if(returnValue == 0){
            returnValue = p1.name.compareTo(p2.name);
        }
        return returnValue;
    }
}
