public class GenericsStarWars {

    // generic method that has an argument/parameter that only
    // allows a Star Wars Character or an extension of a Star Wars Character
    public static <T extends StarWarsCharacter> String getOnlyStarWarsCharacter(T character) {
        return character.getName();
    }
}