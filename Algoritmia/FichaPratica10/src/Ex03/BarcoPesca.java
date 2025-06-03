package Ex03;

import Ex01.Musica;
import Ex02.Pessoa;

import java.util.ArrayList;

public class BarcoPesca {
   private String nome,cor,anoFabrico;
   private int tripulacao;
   double capacidadeCargaKg;
   enum Marca{};

   private ArrayList <Peixe> PeixesPescados;
   private ArrayList <Marisco> MariscoPescado;

   public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCargaKg) {
      this.nome = nome;
      this.cor = cor;
      this.anoFabrico = anoFabrico;
      this.tripulacao = tripulacao;
      this.capacidadeCargaKg = capacidadeCargaKg;
   }

   public double getCapacidadeCargaKg() {
      return capacidadeCargaKg;
   }

   public void pescarPeixe (Peixe peixeNovo){
      if(this.capacidadeCargaKg> peixeNovo.getPeso()) {
         this.PeixesPescados.add(peixeNovo);
      }
   }
   public void pescarMarisco (Marisco mariscoNovo){
      if(this.capacidadeCargaKg> mariscoNovo.getPeso()) {
         this.MariscoPescado.add(mariscoNovo);
         System.out.println("Peixe pescado: " + mariscoNovo.getEspecie() + " peso: " + mariscoNovo.getPeso());
      }else{
         System.out.println("Peixe demasiado pesado.");
      }
   }
   public void largarPeixe (){
      this.PeixesPescados.clear();
   }
   public void largarMarisco (){
      this.MariscoPescado.clear();
   }

   public void exibirDetalhes() {
      System.out.println(this.nome + " | " + this.cor + " | " + this.anoFabrico + " | " + this.tripulacao + " | " + this.capacidadeCargaKg);
   }
   public void imprimirRelatorio(){

      int contadorPeixe = 1;
      int contadorMarisco =1;
      for (Peixe peixeAtual : this.PeixesPescados){
         System.out.println("Inscrito nº " + contadorPeixe++ + ": ");
         peixeAtual.exibirDetalhes();
      }
      for (Marisco mariscoAtual : this.MariscoPescado){
         System.out.println("Inscrito nº " + contadorMarisco++ + ": ");
         mariscoAtual.exibirDetalhes();
      }
   }
}
