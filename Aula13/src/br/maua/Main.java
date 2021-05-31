package br.maua;

import br.maua.model.Item;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        File file = new File("dados.txt");

        //Realiza a leitura do conteudo desse arquivo
        try{
            //Cria elemento para iterar pelo arquivo
            Scanner scanner = new Scanner(file);
            //Passa por todos os elementos do arquivo
            while(scanner.hasNext()){
                String linha = scanner.nextLine();
                items.add(Item.pegaItem(linha));

            }

            exibeResumo(items);

            criarNota(items);
        }
        catch (Exception exception){

            System.out.printf("algo deu errado");

        }

    }

    private static void criarNota(List<Item> items) throws Exception{
        FileWriter fileWriter = new FileWriter("nota.csv");
        fileWriter.write("=== Resumo Pedido===\n");
        fileWriter.append("Total de Items: "+ items.size()+"\n");
        double total = 0;
        fileWriter.append("Items:\n");
        for (Item item:items){
            fileWriter.append(item.nome+"\t\t\t"+item.preco+"\n");
            total+= item.preco;
        }
        fileWriter.append("Total do pedido: "+total+"\n");
        fileWriter.close();
    }


    private static void exibeResumo(List<Item> items){

        System.out.println("=== Resumo Pedido===");
        System.out.println("Total de Items: "+ items.size());
        double total = 0;
        System.out.println("Items:");
        for (Item item:items){
            System.out.println(item.nome+"\t\t\t"+item.preco);
            total+= item.preco;
        }
        System.out.println("Total do pedido: "+total);
    }
}
