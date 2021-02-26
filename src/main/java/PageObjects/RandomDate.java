package PageObjects;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    public LocalDate generateRandomDate(long start, long end)
    {
        long randomEpochDay = ThreadLocalRandom.current().longs(start,end).findAny().getAsLong();
        return (LocalDate.ofEpochDay(randomEpochDay));
    }
}
