package br.maua.maps;

import br.maua.models.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Item> itemMap = new TreeMap<>();


        itemMap.put("Item1", new Item("Maca", 1));
        itemMap.put("Item2", new Item("Pera", 2));
        itemMap.put("Item3", new Item("Maca", 1));
        itemMap.put("Item1", new Item("Banana", 3));

        itemMap.forEach((chave, valor) -> System.out.println("Chave:" + chave + "\nValor" + valor));
    }
}
