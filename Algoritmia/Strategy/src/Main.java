public class Main {
    public static void main (String [] args){
        Hero fada = new Hero ("Fada", 100, 20, new RangedAttackStrategy());

        fada.attack();
        fada.attack();

        fada.setFormaAtaque(new MagicAttackStrategy());

        fada.attack();

        fada.setFormaAtaque(new SilentAttackStrategy());

        fada.attack();

    }
}
