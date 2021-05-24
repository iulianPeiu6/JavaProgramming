package interfaces;

import lab3package.Church;
import lab3package.Museum;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {

    default LocalTime getOpeningTime() {
        return LocalTime.of(9,30);
    }

    default LocalTime getClosingTime() {
        return LocalTime.of(20,0);
    }

    static Duration getVisitingDuration(Church church) {

        return Duration.between(church.getClosingTime() , church.getOpeningTime());
    }

    static Duration getVisitingDuration(Museum museum) {

        return Duration.between(museum.getClosingTime() , museum.getOpeningTime());
    }

}
