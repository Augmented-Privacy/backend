package ap.hackathon.augmentedprivacy.generator;

import ap.hackathon.augmentedprivacy.domain.Transaction;

import java.util.Arrays;
import java.util.List;

public class TransactionGenerator {

    public Transaction generate() {
        Transaction transaction = new Transaction();
        // Do stuff
        return transaction;
    }

    private final List<String> SUPERMARKTEN = Arrays.asList(new String[]{"Albert Heijn", "Super de Boer", "Deen", "Jumbo", "Aldi", "Boni", "Dekamarkt", "Lidl", "Hoogvliet", "Konmar", "Maxis", "Makro", "Carrefour", "Colruyt", "Delhaize", "Prima", "Spar" });
    private final List<String> MODEWINKELS = Arrays.asList(new String[]{"Bomont", "Bonprix", "Bristol", "C&A", "Calvin Klein", "Chasin", "Christine le Duc", "CoolCat", "De Bijenkorf", "Duetz", "H&M", "Hema", "KinderKleding", "Mango", "Miss Etam"});
    private final List<String> TELECOMBEDRIJVEN = Arrays.asList(new String[]{"KPN", "telecom", "telekom", "T-Mobile", "telfort", "youfone", "Hollandsnieuwe", "Ben", "Orange", "Vodafone", "Simpel", "Delta",});
    private final List<String> NUTSBEDRIJVEN = Arrays.asList(new String[]{"Qurrent", "Powerpeers", "Eneco", "Oxxio", "Budget Energie", "Essent", "Nuon", "E.ON", "Engie", "Energie direct"});
    private final List<String> FAMILIELEDEN = Arrays.asList(new String[]{"tante", "oom", "ome", "nonkel", "Mama", "mamma", "pappa", "papa", "oma", "opa", "neef", "nicht", ""});
    private final List<String> HUUR = Arrays.asList("Huur","Servicekosten huur","Contributie woningbouwvereniging","Boeteheffing","Achterstallige huur","Rente over achterstallige huur");
    private final List<String> HYPOTHEEKAFSCHRIJVINGEN = Arrays.asList("Afschrijving hypotheek","Premie hypotheek","Bijdrage VvE","Extra storting hypotheek","Extra aflossing hypotheek");
    private final List<String> BELASTINGEN = Arrays.asList("Gemeentebelasting","Hondenbelasting","Wegenbelasting","Boete voor te hard rijden","Inkomstenbelasting","Kansspelbelasting","Erfbelasting");
    private final List<String> GOEDE_DOELEN = Arrays.asList("Dierenambulance","Stichting DOEN","Unicef","Oxfam Novib","Natuurmonumenten","KWF Kankerfonds","Hersenstichting","Plan","Cordaid","Artsen zonder grenzen");
    private final List<String> ELEKTRONICA_WINKELS = Arrays.asList("BCC","Expert","Media Markt","CoolBlue","Krefel","Eldi","Excellent","Maxwell");
    private final List<String> BABY_ARTIKELEN = Arrays.asList("Prenatal","Baby-Dump","BabyPark","Bambino","MamaLoes","babyartikelen.nl","bayuitzetonline.nl");
    private final List<String> SPORT_ARTIKELEN = Arrays.asList("Sportwereld","Decathlon","SportKnaller","Sport Wereld","Perry Sport","Sportartikelen.nl","Adidas Flagship");
    private final List<String> TANKEN = Arrays.asList("ESSO","SHELL","Texaco","TinQ","Q8","Den Witten Pomp Bierbeek","Garage Scherpenzeel");
    private final List<String> HORECA = Arrays.asList("Cafe het knalletje","Family Kitchen","Garden Cafe","Hotel de Zeurpiet","Frituur den nonkel","'t Schuurtje","Discotheek ZOMG","Pannenkoekenhuis PlatZak");
    private final List<String> SPAREN = Arrays.asList("Spaarrekening gezamelijk","Spaardoel auto","Spaardeposito","Belegging","Pensioensparen");
    private final List<String> LEESMATERIAAL = Arrays.asList("Groene Amsterdammer","Volkskrant","Parool","AD","NRC","Elsevier Weekblad","Oor","Tina","TruckStar","Men's Health");

}
