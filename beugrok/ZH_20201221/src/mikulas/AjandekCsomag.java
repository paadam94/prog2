package mikulas;

public interface AjandekCsomag {
    // visszaadja az ajadekok osszerteket
    int osszErtek();

    // visszaadja a t-nel nehezebb ajadekok szamat
    int nehezekSzama(double t);

    // visszaadja a gyerekjatekokat a termeszetes rendezettseguk sorrendjeben ugy,
    // hogy az egyenlo gyerekjatekok kozul csak egy szerepel a kollekcioban
    java.util.Collection<GyerekJatek> gyerekjatekok();

    double atlagErtek();
}
