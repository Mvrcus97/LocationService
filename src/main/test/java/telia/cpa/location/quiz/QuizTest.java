package telia.cpa.location.quiz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telia.cpa.location.*;
import telia.cpa.location.quiz.*;

import static org.junit.jupiter.api.Assertions.*;


public class QuizTest {


    Quiz quiz;
    @BeforeEach
    void beforeEach() {
       quiz = new Quiz();
    }

    @Test
    void testCreation() {
       //Sørenga:
        Polygon sorenga = new Polygon();
        sorenga.createPolygonFromWKT("MULTIPOLYGON ((10.753031807853403 59.90327532929673,10.749555664970103 59.90161821842869,10.75187309355897 59.90017624948714,10.755306321098032 59.90133843830541,10.756164627982798 59.90198408118742,10.753718453361216 59.90359813347945,10.753031807853403 59.90327532929673))");

        Point positionInside = new Point(59.902480, 10.753627);
        Point positionOutside = new Point(59.904331, 10.750322);

        assertTrue(sorenga.isInside(positionInside));
        assertTrue(!sorenga.isInside(positionOutside));
        String sorengaHint = "Et moderne område kjent som en badeplass";
        QuizLocation quizLocation = new QuizLocation(sorenga, sorengaHint);
        quiz.addQuizLocation(quizLocation);

        quizLocation = quiz.getQuizLocation(0);
        assertEquals(quizLocation.getHint(), sorengaHint);










    }



}//end QuizTest

