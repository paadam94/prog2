package patogenetika;

public class Vírus extends Kórokozó {
        protected boolean isCorona;

        public boolean isCorona() {
            return this.isCorona;
        }
        public Vírus( String name,
                      String nameOfDisease,
                      String[] victims,
                      boolean isCorona) {
            super('V', name, nameOfDisease, victims);
            this.isCorona = isCorona;
        }

        @Override
        public String toString() {
            if (isCorona) {
                return String.join(super.toString(),
                        "; koronavirus");
            } else {
                return String.join(super.toString(),
                        "; nem koronavirus");
            }
        }
}
