package br.maua.maps;

import br.maua.models.Item;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, Item> itemMap = new LinkedHashMap<>();


        itemMap.put("Item1", new Item("Maca", 1));
        itemMap.put("Item2", new Item("Pera", 2));
        itemMap.put("Item3", new Item("Maca", 1));
        itemMap.put("Item1", new Item("Banana", 3));

        itemMap.forEach((chave, valor) -> System.out.println("Chave:" + chave + "\nValor" + valor));
    }
}