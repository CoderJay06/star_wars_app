public class GenericsTest {

    public static void main(String[] args) {
        Yoda yoda = new Yoda();
        ObiWan obiWan = new ObiWan();
        Mickey mickey = new Mickey();

        GenericsStarWars gsw = new GenericsStarWars();

        //call your method here with the above objects
        System.out.println(gsw.getOnlyStarWarsCharacter(obiWan));
    }
}