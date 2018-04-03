import java.util.Collections;

public class KoogiPidu {
    public static void main(String[] args) {

        double[] kulutused = {0, 38, 40, 38, 0};
        String[] lollPead = {"Klaus", "Karl", "Sten", "Mihkel", "Joosep"};
        double näkku = 0;

        for (int i = 0; i < kulutused.length; i++) {
            näkku += kulutused[i] / kulutused.length;
        }

        double[] soovibSaada = new double[5];
        for (int i = 0; i < kulutused.length; i++) {
            if (kulutused[i] > näkku) {
                soovibSaada[i] = kulutused[i] - näkku;
            }
        }

        double kanda;
        double kanna;
        int indeks;

        for (int i = 0; i < kulutused.length; i++) {
            if (kulutused[i] < näkku) {
                kanda = näkku - kulutused[i];
                indeks = suurimIndeks(kulutused);
                if (kulutused[indeks] - näkku <= kanda) {
                    while (kanda != 0) {
                        indeks = suurimIndeks(kulutused);
                        kanna = kulutused[indeks] - näkku;
                        if (kanna > kanda) {
                            kanna = kanda;
                        }
                        kanda = kanda - kanna;
                        kulutused[i] = kulutused[i] + kanna;
                        kulutused[indeks] = kulutused[indeks] - kanna;
                        System.out.println(lollPead[i] + " -> " + lollPead[indeks] + " " + kanna);
                    }
                } else {
                    kanna = näkku;
                    kanda = 0;
                    kulutused[i] = kanna;
                    kulutused[indeks] = kulutused[indeks] - kanna;
                    System.out.println(lollPead[i] + " -> " + lollPead[indeks] + " " + kanna);
                }
            }
        }
    }

    public static int suurimIndeks(double[] arr) {

        double suurim = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > suurim) {
                suurim = arr[i];
            }
        }

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==suurim){
                k=i;
                break;
            }
        }
        return k;
    }
}
