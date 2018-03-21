package ap.hackathon.augmentedprivacy.generator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public enum Category {

    SUPERMARKTEN(5, 100_000, Arrays.asList("Albert Heijn", "Super de Boer", "Deen", "Jumbo", "Aldi", "Boni", "Dekamarkt", "Lidl", "Hoogvliet", "Konmar", "Maxis", "Makro", "Carrefour", "Colruyt", "Delhaize", "Prima", "Spar")),
    MODEWINKELS(100, 1_000_000, Arrays.asList("Bomont", "Bonprix", "Bristol", "C&A", "Calvin Klein", "Chasin", "Christine le Duc", "CoolCat", "De Bijenkorf", "Duetz", "H&M", "Hema", "KinderKleding", "Mango", "Miss Etam")),
    TELECOMBEDRIJVEN(250, 9000, Arrays.asList("KPN", "telecom", "telekom", "T-Mobile", "telfort", "youfone", "Hollandsnieuwe", "Ben", "Orange", "Vodafone", "Simpel", "Delta")),
    NUTSBEDRIJVEN(500, 30000, Arrays.asList("Qurrent", "Powerpeers", "Eneco", "Oxxio", "Budget Energie", "Essent", "Nuon", "E.ON", "Engie", "Energie direct")),
    FAMILIELEDEN(1, 1_000_000, Arrays.asList("tante", "oom", "ome", "nonkel", "Mama", "mamma", "pappa", "papa", "oma", "opa", "neef", "nicht")),
    HUUR(12000, 300000, Arrays.asList("Huur", "Servicekosten huur", "Contributie woningbouwvereniging", "Boeteheffing", "Achterstallige huur", "Rente over achterstallige huur")),
    HYPOTHEEKAFSCHRIJVINGEN(12000, 300000, Arrays.asList("Afschrijving hypotheek", "Premie hypotheek", "Bijdrage VvE", "Extra storting hypotheek", "Extra aflossing hypotheek")),
    BELASTINGEN(3000, 10_000_000, Arrays.asList("Gemeentebelasting", "Hondenbelasting", "Wegenbelasting", "Boete voor te hard rijden", "Inkomstenbelasting", "Kansspelbelasting", "Erfbelasting")),
    GOEDE_DOELEN(100, 5000, Arrays.asList("Dierenambulance", "Stichting DOEN", "Unicef", "Oxfam Novib", "Natuurmonumenten", "KWF Kankerfonds", "Hersenstichting", "Plan", "Cordaid", "Artsen zonder grenzen")),
    ELEKTRONICA_WINKELS(1000, 1200000, Arrays.asList("BCC", "Expert", "Media Markt", "CoolBlue", "Krefel", "Eldi", "Excellent", "Maxwell")),
    BABY_ARTIKELEN(100, 30000, Arrays.asList("Prenatal", "Baby-Dump", "BabyPark", "Bambino", "MamaLoes", "babyartikelen.nl", "bayuitzetonline.nl")),
    SPORT_ARTIKELEN(100, 20000, Arrays.asList("Sportwereld", "Decathlon", "SportKnaller", "Sport Wereld", "Perry Sport", "Sportartikelen.nl", "Adidas Flagship")),
    TANKEN(1000, 25000, Arrays.asList("ESSO", "SHELL", "Texaco", "TinQ", "Q8", "Den Witten Pomp Bierbeek", "Garage Scherpenzeel")),
    HORECA(500, 50000, Arrays.asList("Cafe het knalletje", "Family Kitchen", "Garden Cafe", "Hotel de Zeurpiet", "Frituur den nonkel", "'t Schuurtje", "Discotheek ZOMG", "Pannenkoekenhuis PlatZak")),
    SPAREN(1000, 100000, Arrays.asList("Spaarrekening gezamelijk", "Spaardoel auto", "Spaardeposito", "Belegging", "Pensioensparen")),
    LEESMATERIAAL(1000, 2500, Arrays.asList("Groene Amsterdammer", "Volkskrant", "Parool", "AD", "NRC", "Elsevier Weekblad", "Oor", "Tina", "TruckStar", "Men's Health"));

    private int fromCents;
    private int toCents;
    private List<String> keywords;

    Category(int low, int to, List<String> strings) {
        this.fromCents = low;
        this.toCents = to;
        this.keywords = strings;
    }

    static Category getRandom() {
        int pick = new Random().nextInt(Category.values().length);
        return Category.values()[pick];
    }

    BigInteger getAmount() {
        int randomNum = ThreadLocalRandom.current().nextInt(fromCents, toCents + 1);
        return BigInteger.valueOf(randomNum);
    }

    String getRandomKeyword() {
        int pick = new Random().nextInt(keywords.size());
        return keywords.get(pick);
    }

}