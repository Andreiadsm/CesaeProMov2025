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
}