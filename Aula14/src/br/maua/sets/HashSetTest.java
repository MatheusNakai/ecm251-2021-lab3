package br.maua.sets;

import br.maua.models.Item;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Item> itemSet = new HashSet<>();

        itemSet.add(new Item("Maca",1));
        itemSet.add(new Item("Pera",2));
        itemSet.add(new Item("Maca",1));
        itemSet.add(new Item("Banana",3));

        itemSet.forEach( item -> System.out.println(item));
    }
}
