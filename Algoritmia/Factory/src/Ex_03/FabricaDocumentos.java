package Ex_03;

import Ex_02.Taco;
import Ex_02.TacoCarne;
import Ex_02.TacoFrango;
import Ex_02.TacoVeggie;

public class FabricaDocumentos {
    public static Document opcao(String autor, String nome, String extensao){

        switch (opcao){
            case "Excel":
                String nome;
                return new Excel(autor, nome, extensao);


        }
    }
}

