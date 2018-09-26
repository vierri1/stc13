package lesson10.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> stringList = new ArrayList<>();
        String str = "lksdjfl;kadsfkjsad;fladsfaskdfjlk;sadfa;lskdfjsa;lfkj dsljfdsjfklsdjf;lks akf;jds klf;jas kjf ;dlsf j" +
                "kldsjf ;lkdjfka jldfj als;jdf dlsajf ;lsdjfldjf  dlfsjadfjsad;fkjasdl; jasd;l flfjkasdl;fjkdsajf ;lasdjfla;sdjf " +
                ";kldfj l;aksdjf;kldskfjsad;klfjl;dskfsd flkjsdlfkjdsklmldsjkdsmflksjfk;ajfjdasfjas;ldjf;lkasjfl;jaslfjsafjasdfj;asjf;as" +
                "kldsjf lk;asjdfk jdsafjsdd;sfjdsnkldsaf;jsdljfdskfasgnd;fj aklw f;alkdsfj lkadjs flkjdasfklmasfijwmlkjf dkasf ;saklj " +
                "kflda jfk;lasj f;jasdlk f;ajsdk fdskljfdskfjkdsjf;lasdf ;lnasd ljasldkfj ;aslksan g;ak akg";
        while (true) {
            int rand = random.nextInt(4);
            if (rand == 1) {
                if (stringList.size() != 0) {
                    stringList.remove(stringList.size() - 1);
                    System.out.println("op");
                }
            } else {
                String s = new String(str);
                stringList.add(s);
            }
        }
    }
}
