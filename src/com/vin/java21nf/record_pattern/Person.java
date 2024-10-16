package com.vin.java21nf.record_pattern;

public record Person(String name , Integer age) { }  // component list, name() and age() accessors
enum Ability{WEAK, AVERAGE, STRONG}

record Player(Person person, Ability ability){}  // person() and ability() accessors
record Doubles(Player player1, Player Player2){}  // player1() and player2() accessors

record Pair<T> (T x, T y){} // // x() and y() accessors
