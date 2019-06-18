package individual.model.software.service;

import individual.model.RotationType;
import individual.model.software.Instruction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramsLoaderTest {

    ProgramsLoader programsLoader;
    String instructionString;

    @Before
    public void init(){
        programsLoader = new ProgramsLoader();
        instructionString =
                "        <instruction>\n" +
                        "            <type>PRE_WASHing</type>\n" +
                        "            <is_active>true</is_active>\n" +
                        "            <water_temp>30</water_temp>\n" +
                        "            <rotation_type>SLOW</rotation_type>\n" +
                        "            <rotation_time>3000</rotation_time>\n" +
                        "        </instruction>";
    }

    @Test
    public void getInstructionFromString() {

        Instruction result = programsLoader.getInstructionFromString(instructionString);

        assertEquals("Instructions type isn't PRE_WASHING", Instruction.TYPE.PRE_WASHING, result.currentType);
        assertTrue("Instructions is_active field didn't true", result.IS_ACTIVE);
        assertEquals("Instructions temp isn't 30 degree", 30, result.WATER_TEMP);
        assertEquals("Instructions rotation type isn't normal", RotationType.SLOW, result.MOTOR_ROTATION_TYPE);
        assertEquals("Instructions rotation time isn't 3000", 3000, result.ROTATION_TIME);
    }

    @Test
    public void testGetPropertyStringValidSource(){

        String testString = "<rotation_type>SLOW</rotation_type>";

        assertEquals("Should return \"SLOW\"","SLOW", programsLoader.getPropertyString(testString, "rotation_type"));

    }

    @Test
    public void testGetPropertyStringInvalidSource(){

        String testString = "<rotation_type>SLOW<rotation_type>";

        assertEquals("Should return \"\"(default value)","", programsLoader.getPropertyString(testString, "rotation_type"));

    }

    @Test
    public void getInstructionTypeFromStringShouldReturnPreWash() {

        assertEquals("Type should be PRE_WASHING", Instruction.TYPE.PRE_WASHING, programsLoader.getInstructionType(instructionString));
    }

    @Test
    public void getInstructionStatusShouldReturnTrue() {

        String sourceString = "            <type>PRE_WASHING</type>\n" +
                              "            <is_active>tRuE</is_active>";

        assertTrue("IS_ACTIVE status should be true", programsLoader.getInstructionStatus(sourceString));
    }

    @Test
    public void getInstructionStatusShouldReturnFalse() {

        String sourceString = "            <type>PRE_WASHING</type>\n" +
                "            <is_active>FALSE</is_active>";

        assertFalse("IS_ACTIVE status should be true", programsLoader.getInstructionStatus(sourceString));
    }

    @Test
    public void getInstructionWaterTempShouldReturn30() {

        String sourceString = "            <water_temp>30</water_temp>\n" +
                              "            <rotation_type>SLOW</rotation_type>";

        assertEquals("Water temp should be 30 degrees", 30, programsLoader.getInstructionWaterTemp(sourceString));
    }

    @Test
    public void getInstructionWaterTempShouldReturn0() {

        String sourceString = "            <water_temp>a30</water_temp>\n" +
                "            <rotation_type>SLOW</rotation_type>";

        assertEquals("Water temp should be 0 degrees(default value)", 0, programsLoader.getInstructionWaterTemp(sourceString));
    }

    @Test
    public void getInstructionRotationTimeShouldReturn0() {

        String sourceString = "<rotation_type>SLOW</rotation_type>\n" +
                              "<rotation_time>z4500</rotation_time>";

        assertEquals("Water temp should be 0(default value)", 0, programsLoader.getInstructionRotationTime(sourceString));
    }

    @Test
    public void getInstructionRotationTimeShouldReturn4500() {

        String sourceString = "<rotation_type>SLOW</rotation_type>\n" +
                "<rotation_time>4500</rotation_time>";

        assertEquals("Water temp should be 4500", 4500, programsLoader.getInstructionRotationTime(sourceString));
    }

    @Test
    public void getInstructionRotationTypeShouldReturnHighSpinning() {

        String sourceString = "<rotation_type>HIGH_spinning</rotation_type>\n" +
                "<rotation_time>4500</rotation_time>";

        assertEquals("Instruction rotation type should be HIGH_SPINNING", RotationType.HIGH_SPINNING, programsLoader.getInstructionRotationType(sourceString));
    }

    @Test
    public void getInstructionRotationTypeShouldReturnStop() {

        String sourceString = "<rotation_type>qwerty</rotation_type>\n" +
                "<rotation_time>4500</rotation_time>";

        assertEquals("Instruction rotation type should be STOP (default value)", RotationType.STOP, programsLoader.getInstructionRotationType(sourceString));
    }

}