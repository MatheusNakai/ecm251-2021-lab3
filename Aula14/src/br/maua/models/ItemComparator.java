package br.maua.models;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.nome.compareTo(o2.nome);
    }
}
