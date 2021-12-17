package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.enums.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NovaReceitaView {

    Scanner scanner;
    Receita receita;
    String nome;
    String nomeReceita, modoDePreparo;
    int categoriaReceita, tempoDePreparo;
    String resp = "s";
    public List<String> ingredientes = new ArrayList<>();
    public List<Object> All = new ArrayList<>();

    public NovaReceitaView() {

        this.scanner = new Scanner(System.in);
        System.out.println("Qual o nome da receita? ");
        nomeReceita = scanner.nextLine();

        for (Categoria cat : Categoria.values()) {
            System.out.printf("%d - %s\n", cat.ordinal(), cat.name());
        }

        System.out.println("Qual categoria se encaixa? ");
        categoriaReceita = scanner.nextInt();

        System.out.println("Tempo de preparo? (Em min) ");
        tempoDePreparo = scanner.nextInt();

        do {

            System.out.println("Coloque os ingredientes: ");
            ingredientes.add(scanner.next());

            System.out.println("Deseja continuar? ");
            resp = scanner.next();

        } while (resp.equals("s"));

        System.out.println("Modo de preparo... ");
        modoDePreparo = scanner.next();

        System.out.println("Sua receita é:");
        System.out.println("Nome: " + nomeReceita);
        System.out.println("Categoria: " + categoriaReceita);
        System.out.println("Tempo de preparo: " + tempoDePreparo + "min");
        System.out.println("Ingredientes: " + ingredientes);
        System.out.println("Modo de preparo: " + modoDePreparo);

        All.add(nomeReceita); All.add(categoriaReceita); All.add(tempoDePreparo); All.add(ingredientes); All.add(modoDePreparo);

    }

    public void askNome() {
        System.out.println("Qual o nome da receita?");
        nome = scanner.nextLine();
        if (nome.isBlank()) {
            System.out.println("Nome inválido!");
            askNome();
        }
    }

    public void askCategoria() {
        System.out.println("Qual a categoria da receita?");
        for (Categoria cat : Categoria.values()) {
            System.out.printf("%d - %s\n", cat.ordinal(), cat.name());
        }
        int categoria = scanner.nextInt();
        if (categoria < 0 || categoria >= Categoria.values().length) {
            System.out.println("Categoria inválida!");
            askCategoria();

        }
    }

    public String getNomeReceita() {
        return nomeReceita;
    }
}
