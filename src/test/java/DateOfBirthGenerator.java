import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateOfBirthGenerator {
    public static Calendar getCalendar() {
        Calendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2023);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        return gc;
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static void main(String[] args) {
        for (int i=0; i < 1000; i++){
            System.out.println(getCalendar().get(Calendar.MONTH));
            System.out.println(getCalendar().getTime());
        }
    }
}
