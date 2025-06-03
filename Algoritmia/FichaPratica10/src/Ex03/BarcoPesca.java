package Ex03;

import java.util.ArrayList;

public class BarcoPesca {
   private String nome, cor, anoFabrico;
   private int tripulacao;
   private double capacidadeCargaKg;
   private Marca marca;

   public enum Marca {
      Bentz, Devlin, Mazury, Quicksilver, Saver, Smartliner, Voraz, Wooldridge
   }

   private ArrayList<Peixe> PeixesPescados;
   private ArrayList<Marisco> MariscoPescado;

   public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCargaKg) {
      this.nome = nome;
      this.cor = cor;
      this.anoFabrico = anoFabrico;
      this.tripulacao = tripulacao;
      this.capacidadeCargaKg = capacidadeCargaKg;
      this.marca = marca;
      this.PeixesPescados = new ArrayList<>();
      this.MariscoPescado = new ArrayList<>();
   }

   private double cargaAtual() {
      double total = 0;
      for (Peixe peixeAtual : PeixesPescados) total += peixeAtual.getPeso();
      for (Marisco mariscoAtual : MariscoPescado) total += mariscoAtual.getPeso();
      return total;
   }

   public void pescarPeixe(Peixe peixeAtual) {
      if (cargaAtual() + peixeAtual.getPeso() <= capacidadeCargaKg) {
         this.PeixesPescados.add(peixeAtual);
         System.out.println("Peixe pescado: " + peixeAtual.getEspecie() + " | Peso: " + peixeAtual.getPeso() + " kg");
      } else {
         System.out.println("Peixe demasiado pesado. Carga excedida.");
      }
   }

   public void pescarMarisco(Marisco mariscoAtual) {
      if (cargaAtual() + mariscoAtual.getPeso() <= capacidadeCargaKg) {
         this.MariscoPescado.add(mariscoAtual);
         System.out.println("Marisco pescado: " + mariscoAtual.getEspecie() + " | Peso: " + mariscoAtual.getPeso() + " kg");
      } else {
         System.out.println("Marisco demasiado pesado. Carga excedida.");
      }
   }

   public void largarPeixe() {
      this.PeixesPescados.clear();
   }

   public void largarMarisco() {
      this.MariscoPescado.clear();
   }

   public double calcularTotal() {
      double total = 0;
      for (Peixe peixeAtual : PeixesPescados) total += peixeAtual.getValorTotal();
      for (Marisco mariscoAtual : MariscoPescado) total += mariscoAtual.getValorTotal();
      return total;
   }

   public double salarioTripulacao() {
      double restante = calcularTotal() * 0.60;
      return restante / tripulacao;
   }

   public void exibirDetalhes() {
      System.out.println(nome + " | " + cor + " | " + anoFabrico + " | Tripulantes: " + tripulacao +
              " | Capacidade: " + capacidadeCargaKg + " kg | Marca: " + marca);
   }

   public void imprimirRelatorio() {
      System.out.println("\n=== RELATÓRIO DE PESCA ===");
      exibirDetalhes();
      System.out.println("Carga Atual: " + cargaAtual() + " kg");

      int contadorPeixe = 1;
      for (Peixe peixeAtual : PeixesPescados) {
         System.out.println("Peixe nº " + contadorPeixe++ + ": ");
         peixeAtual.exibirDetalhes();
      }

      int contadorMarisco = 1;
      for (Marisco mariscoAtual : MariscoPescado) {
         System.out.println("Marisco nº " + contadorMarisco++ + ": ");
         mariscoAtual.exibirDetalhes();
      }

      System.out.printf("\nValor total pescado: %.2f €\n", calcularTotal());
      System.out.printf("Salário por tripulante: %.2f €\n", salarioTripulacao());
      System.out.println("============================\n");
   }
}
