package WorkWithData;

import GUI.Backend.SQL.WorkWithData;
import GUI.Backend.Toys.Toys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AddData {
    public static void main(String[] args) throws ParseException {
        String name[] = {"Iron Man", "Iron Woman", "Hulk", "Batman", "Kick Man", "Cool Man", "Obobus", "Bear", "Thomas"};
        String manufacture[] = {"USA", "Russia","India", "China", "Bangladesh", "Harvatia", "Holy Rome Empire", "Italy"};
        String type[] = {"Plush", "Plastic", "Hard plastic", "Soft"};
        Date datedateCome;
        Date datedateSell;
        String dateSell ="";
        String dateCome ="";
        WorkWithData a = new WorkWithData();
        for(int i=0;i<100;i++) {
            do {
                dateSell ="";
                dateCome ="";
                dateSell += String.valueOf(new Random().nextInt(2000, 2021));
                dateSell += "-";
                dateSell += String.valueOf(new Random().nextInt(1, 12));
                dateSell += "-";
                dateSell += String.valueOf(new Random().nextInt(1, 28));
                dateCome += String.valueOf(new Random().nextInt(2000, 2021));
                dateCome += "-";
                dateCome += String.valueOf(new Random().nextInt(1, 12));
                dateCome += "-";
                dateCome += String.valueOf(new Random().nextInt(1, 28));
                datedateCome = new SimpleDateFormat("yyyy-MM-dd").parse(dateCome);
                datedateSell = new SimpleDateFormat("yyyy-MM-dd").parse(dateSell);
            } while(datedateCome.after(datedateSell));


            a.add(new Toys(0, name[new Random().nextInt(name.length)], new Random().nextLong(99999), manufacture[new Random().nextInt(manufacture.length)], dateCome, dateSell, type[new Random().nextInt(type.length)], new Random().nextDouble(1000)));
        }
    }
}
