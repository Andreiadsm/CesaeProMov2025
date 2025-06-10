package jogo;

import entidades.*;
import itens.*;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {

    public static void listarItensPermitidos(Heroi heroi, Vendedor vendedor) {
        System.out.println("Itens disponíveis para o teu herói:");
        int contador = 1;
        boolean encontrou = false;

        for (ItemHeroi item : vendedor.getLoja()) {
            boolean podeUsar = false;
            for (TipoHeroi tipoPermitido : item.getHeroisPermitidos()) {
                if (tipoPermitido == heroi.getTipoHeroi()) {
                    podeUsar = true;
                }
            }
            if (podeUsar) {
                String estado;
                if (heroi.getOuro() >= item.getPreco()) {
                    estado = "Disponível";
                } else {
                    estado = "Ouro insuficiente";
                }
                System.out.println(contador + " - " + item.getNome() + " (" + item.getPreco() + " ouro) " + estado);
                contador++;
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum item compatível com o teu herói.");
        }
    }

    public static Sala criarLabirintoAleatorio(Heroi heroi) {
        ArrayList<Sala> todasAsSalas = new ArrayList<>();
        Random random = new Random();

        Sala entrada = new Sala("Entrada do Labirinto");
        todasAsSalas.add(entrada);

        int numeroDeSalas = 6 + random.nextInt(3); // entre 6 e 8 salas
        for (int i = 1; i < numeroDeSalas; i++) {
            Sala novaSala = new Sala("Sala " + i);

            if (random.nextBoolean()) {
                novaSala.setDanoArmadilha(5 + random.nextInt(16));
            }

            if (random.nextInt(100) < 30) {
                novaSala.setVendedor(Vendedor.criarVendedorInicial());

            }

            if (random.nextInt(100) < 50) {
                NPC inimigo = new NPC("Inimigo " + i, 30 + random.nextInt(40), 5 + random.nextInt(6), 10);
                novaSala.adicionarInimigo(inimigo);
            }

            todasAsSalas.add(novaSala);
        }

        for (int i = 0; i < todasAsSalas.size() - 1; i++) {
            todasAsSalas.get(i).adicionarLigacao(todasAsSalas.get(i + 1));
            if (i + 2 < todasAsSalas.size() && random.nextBoolean()) {
                todasAsSalas.get(i).adicionarLigacao(todasAsSalas.get(i + 2));
            }
        }

        return entrada;
    }
}