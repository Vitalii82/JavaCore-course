package com.solvd.course;

import com.solvd.course.model.Airport;
import com.solvd.course.model.Flight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AirportTest {
    @Test
    public void testGetFlights() {
        Airport a = new Airport("Test", "Loc", List.of(new Flight("1","FN",100,60,"A","B")));
        assertEquals(1, a.getFlights().size());
    }
}
