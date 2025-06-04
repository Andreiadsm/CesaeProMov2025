package Ex03;

import java.util.ArrayList;

public class BarcoPesca {
   private String nome, cor;
   private int anoFabrico;
   private int tripulacao;
   private double capacidadeCargaKg;
   private MarcaBarco marca;

   private ArrayList<Peixe> PeixesPescados;
   private ArrayList<Marisco> MariscoPescado;

   public BarcoPesca(String nome, String cor, int anoFabrico, int tripulacao, double capacidadeCargaKg, MarcaBarco marca) {
      this.nome = nome;
      this.cor = cor;
      this.anoFabrico = anoFabrico;
      this.tripulacao = tripulacao;
      this.capacidadeCargaKg = capacidadeCargaKg;
      this.marca = marca;
      this.PeixesPescados = new ArrayList<Peixe>();
      this.MariscoPescado = new ArrayList<Marisco>();
   }

   public void pescarPeixe(Peixe peixeAtual) {
      if (cargaAtual() + peixeAtual.getPeso() <= this.capacidadeCargaKg) {
         this.PeixesPescados.add(peixeAtual);
         System.out.println("Peixe pescado: " + peixeAtual.getEspecie() + " | Peso: " + peixeAtual.getPeso() + " kg");
      } else {
         System.out.println("Peixe demasiado pesado. Carga excedida.");
      }
   }

   public void pescarMarisco(Marisco mariscoAtual) {
      if (cargaAtual() + mariscoAtual.getPeso() <= this.capacidadeCargaKg) {
         this.MariscoPescado.add(mariscoAtual);
         System.out.println("Marisco pescado: " + mariscoAtual.getEspecie() + " | Peso: " + mariscoAtual.getPeso() + " kg");
      } else {
         System.out.println("Marisco demasiado pesado. Carga excedida.");
      }
   }

   private double cargaAtual() {

      double cargaAtual = 0;
      for (Peixe peixeAtual : this.PeixesPescados)
         cargaAtual += peixeAtual.getPeso();
      for (Marisco mariscoAtual : this.MariscoPescado)
         cargaAtual += mariscoAtual.getPeso();
      return cargaAtual;
   }
   public void largarPeixe(Peixe peixeLargar) {
      this.PeixesPescados.remove(peixeLargar);
      System.out.println(peixeLargar.getEspecie() + " largados.");
   }

   public void largarMarisco(Marisco mariscoLargar) {
      this.MariscoPescado.remove(mariscoLargar);
      System.out.println(mariscoLargar.getEspecie() + " largados.");
   }

   public double calcularTotal() {
      double valorTotal = 0;
      for (Peixe peixeAtual : PeixesPescados)
         valorTotal += peixeAtual.getValorTotal();
      for (Marisco mariscoAtual : MariscoPescado)
         valorTotal += mariscoAtual.getValorTotal();
      return valorTotal;
   }

   public double salarioTripulacao() {
      return (this.calcularTotal()*0.6/ this.tripulacao);
   }

   public void exibirDetalhes() {
      System.out.println(nome + " | " + cor + " | " + anoFabrico + " | Tripulantes: " + tripulacao +
              " | Capacidade: " + capacidadeCargaKg + " kg | Marca: " + marca + this.cargaAtual() + " kg.");
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
   }
}
