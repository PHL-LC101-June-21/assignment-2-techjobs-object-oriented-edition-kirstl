package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job tester1 = new Job();
        Job tester2 = new Job();
        assertNotEquals(tester1.getId(),tester2.getId());
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job tester3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("Product tester","Product tester");
       assertEquals("ACME", "ACME");
        assertEquals("Desert", "Desert");
       assertEquals("Quality control", "Quality control");
        assertEquals("Persistence", "Persistence");


        assertTrue(tester3.getName() instanceof String);
        assertTrue(tester3.getEmployer() instanceof Employer);
        assertTrue(tester3.getLocation() instanceof Location);
        assertTrue(tester3.getPositionType() instanceof PositionType);
        assertTrue(tester3.getCoreCompetency() instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality(){
        Job tester4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job tester5 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(tester4.equals(tester5));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job tester6 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String stringTest = tester6.toString() ;

        assertEquals('\n', stringTest.charAt(0));
        assertEquals('\n', stringTest.charAt(stringTest.length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job tester7 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String [] stringData = tester7.toString().split("\n");

        assertEquals("ID: 4", stringData[1]);
        assertEquals("Name: Product tester", stringData[2]);
        assertEquals("Employer: ACME", stringData[3]);
        assertEquals("Location: Desert", stringData[4]);
        assertEquals("Position Type: Quality control", stringData[5]);
        assertEquals("Core Competency: Persistence", stringData[6]);

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job tester8 = new Job("", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String [] stringData2 = tester8.toString().split("\n");

        assertEquals("ID: 3", stringData2[1]);
        assertEquals("Name: Data not available", stringData2[2]);
        assertEquals("Employer: ACME", stringData2[3]);
        assertEquals("Location: Desert", stringData2[4]);
        assertEquals("Position Type: Quality control", stringData2[5]);
        assertEquals("Core Competency: Persistence", stringData2[6]);

    }
}
