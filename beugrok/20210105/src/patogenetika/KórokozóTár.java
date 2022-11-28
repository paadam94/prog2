package patogenetika;

public interface KórokozóTár {
    // hozzáadja a megkapott tömbben található kórokozókat a kórokozótárhoz
    void hozzáad(Kórokozó[] kórokozók);
    // visszaadja egy listában a természetes rendezettségük sorrendjében azokat a
    // koronavírusokat, amelyek veszélyt jelentenek a megkapott gazdatestre nézve
    java.util.List<Vírus> koronavírusokGazdában(String gazdatest);
    // visszaadja lexikografikusan növekvő sorrendben a kórokozótárban szereplő
    // kórokozók által okozott összes betegséget úgy, hogy egy betegség csak egyszer
    // szerepel a kollekcióban (null értékek és üres sztringek nélkül!)
    java.util.Collection<String> betegségek();
}
