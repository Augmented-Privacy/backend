package ap.hackathon.augmentedprivacy.generator;

import ap.hackathon.augmentedprivacy.domain.Transaction;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TransactionGenerator {

    public Transaction generate() {
        Transaction transaction = new Transaction();
Category random = Category.getRandom();
        transaction.setAmount(random.getAmount());
        transaction.setDescription(random.getRandomKeyword());
        // Do stuff
        return transaction;
    }

    public enum Category {

        SUPERMARKTEN(BigInteger.valueOf(5), BigInteger.valueOf(100_000), Arrays.asList("Albert Heijn", "Super de Boer", "Deen", "Jumbo", "Aldi", "Boni", "Dekamarkt", "Lidl", "Hoogvliet", "Konmar", "Maxis", "Makro", "Carrefour", "Colruyt", "Delhaize", "Prima", "Spar")),
        MODEWINKELS(BigInteger.valueOf(100), BigInteger.valueOf(1_000_000), Arrays.asList("Bomont", "Bonprix", "Bristol", "C&A", "Calvin Klein", "Chasin", "Christine le Duc", "CoolCat", "De Bijenkorf", "Duetz", "H&M", "Hema", "KinderKleding", "Mango", "Miss Etam")),
        TELECOMBEDRIJVEN(BigInteger.valueOf(250), BigInteger.valueOf(9000), Arrays.asList("KPN", "telecom", "telekom", "T-Mobile", "telfort", "youfone", "Hollandsnieuwe", "Ben", "Orange", "Vodafone", "Simpel", "Delta")),
        NUTSBEDRIJVEN(BigInteger.valueOf(500), BigInteger.valueOf(30000), Arrays.asList("Qurrent", "Powerpeers", "Eneco", "Oxxio", "Budget Energie", "Essent", "Nuon", "E.ON", "Engie", "Energie direct")),
        FAMILIELEDEN(BigInteger.valueOf(1), BigInteger.valueOf(1_000_000), Arrays.asList("tante", "oom", "ome", "nonkel", "Mama", "mamma", "pappa", "papa", "oma", "opa", "neef", "nicht", "")),
        HUUR(BigInteger.valueOf(12000), BigInteger.valueOf(300000), Arrays.asList("Huur", "Servicekosten huur", "Contributie woningbouwvereniging", "Boeteheffing", "Achterstallige huur", "Rente over achterstallige huur")),
        HYPOTHEEKAFSCHRIJVINGEN(BigInteger.valueOf(12000), BigInteger.valueOf(300000), Arrays.asList("Afschrijving hypotheek", "Premie hypotheek", "Bijdrage VvE", "Extra storting hypotheek", "Extra aflossing hypotheek")),
        BELASTINGEN(BigInteger.valueOf(3000), BigInteger.valueOf(10_000_000), Arrays.asList("Gemeentebelasting", "Hondenbelasting", "Wegenbelasting", "Boete voor te hard rijden", "Inkomstenbelasting", "Kansspelbelasting", "Erfbelasting")),
        GOEDE_DOELEN(BigInteger.valueOf(100), BigInteger.valueOf(5000), Arrays.asList("Dierenambulance", "Stichting DOEN", "Unicef", "Oxfam Novib", "Natuurmonumenten", "KWF Kankerfonds", "Hersenstichting", "Plan", "Cordaid", "Artsen zonder grenzen")),
        ELEKTRONICA_WINKELS(BigInteger.valueOf(1000), BigInteger.valueOf(1200000), Arrays.asList("BCC", "Expert", "Media Markt", "CoolBlue", "Krefel", "Eldi", "Excellent", "Maxwell")),
        BABY_ARTIKELEN(BigInteger.valueOf(100), BigInteger.valueOf(30000), Arrays.asList("Prenatal", "Baby-Dump", "BabyPark", "Bambino", "MamaLoes", "babyartikelen.nl", "bayuitzetonline.nl")),
        SPORT_ARTIKELEN(BigInteger.valueOf(100), BigInteger.valueOf(20000), Arrays.asList("Sportwereld", "Decathlon", "SportKnaller", "Sport Wereld", "Perry Sport", "Sportartikelen.nl", "Adidas Flagship")),
        TANKEN(BigInteger.valueOf(1000), BigInteger.valueOf(25000), Arrays.asList("ESSO", "SHELL", "Texaco", "TinQ", "Q8", "Den Witten Pomp Bierbeek", "Garage Scherpenzeel")),
        HORECA(BigInteger.valueOf(500), BigInteger.valueOf(50000), Arrays.asList("Cafe het knalletje", "Family Kitchen", "Garden Cafe", "Hotel de Zeurpiet", "Frituur den nonkel", "'t Schuurtje", "Discotheek ZOMG", "Pannenkoekenhuis PlatZak")),
        SPAREN(BigInteger.valueOf(1000), BigInteger.valueOf(100000), Arrays.asList("Spaarrekening gezamelijk", "Spaardoel auto", "Spaardeposito", "Belegging", "Pensioensparen")),
        LEESMATERIAAL(BigInteger.valueOf(1000), BigInteger.valueOf(2500), Arrays.asList("Groene Amsterdammer", "Volkskrant", "Parool", "AD", "NRC", "Elsevier Weekblad", "Oor", "Tina", "TruckStar", "Men's Health"));

        private BigInteger fromCents;
        private BigInteger toCents;
        private List<String> keywords;

        Category(BigInteger low, BigInteger to, List<String> strings) {
            this.fromCents = low;
            this.toCents = to;
            this.keywords = strings;
        }

        static Category getRandom() {
            int pick = new Random().nextInt(Category.values().length);
            return Category.values()[pick];
        }

        BigInteger getAmount() {
          return  BigInteger.valueOf(0);
        }

        String getRandomKeyword() {
            int pick = new Random().nextInt(keywords.size());
            return keywords.get(pick);
        }

    }

}
