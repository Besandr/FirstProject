package individual.model.software.service;

import individual.model.RotationType;
import individual.model.software.Instruction;
import individual.model.software.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProgramsLoader {

    private final Instruction.TYPE DEFAULT_INSTRUCTION_TYPE = Instruction.TYPE.RINSING;
    private final RotationType DEFAULT_ROTATION_TYPE = RotationType.STOP;
    private final boolean DEFAULT_STATUS = false;
    private final int DEFAULT_WATER_TEMP = 0;
    private final int DEFAULT_ROTATION_TIME = 0;

    public List<Program> loadPrograms(String programsFilePath) {

        List<Program> programs = new ArrayList<>();

        String programsString = getProgramsAsString(programsFilePath);

        List<String> programStrings = getPropertyList(programsString, "program");

        for (String s : programStrings) {
            programs.add(getProgram(s));
        }

        return Collections.unmodifiableList(programs);
    }

    private String getProgramsAsString(String programsFilePath) {

        String programsString = "";

        try {
            Path programsPath = Paths.get(programsFilePath);
            programsString = Files.lines(programsPath).collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return programsString;
    }

    private Program getProgram(String sourceString) {

        String name = getPropertyString(sourceString, "name");
        SortedSet<Instruction> instructions = getInstructionsSet(sourceString);

        return new Program(name, instructions);
    }

    private SortedSet<Instruction> getInstructionsSet(String programString) {

        TreeSet<Instruction> instructionsSet = new TreeSet<>();

        List<String> instructionsStringList = getPropertyList(programString, "instruction");

        if (!instructionsStringList.isEmpty()) {

            for (String instructionString : instructionsStringList) {

                Instruction instruction = getInstructionFromString(instructionString);
                instructionsSet.add(instruction);

            }
        }

        return Collections.unmodifiableSortedSet(instructionsSet);
    }

    Instruction getInstructionFromString(String instructionString) {

        return new Instruction(
                getInstructionType(instructionString),
                getInstructionStatus(instructionString),
                getInstructionWaterTemp(instructionString),
                getInstructionRotationType(instructionString),
                getInstructionRotationTime(instructionString));
    }

    Instruction.TYPE getInstructionType(String sourceString) {

        String property = getPropertyString(sourceString, "type").toLowerCase();

        if (!property.isEmpty()) {

            for (Instruction.TYPE type : Instruction.TYPE.values()) {
                if (type.toString().toLowerCase().equals(property)) {
                    return type;
                }
            }
        }

        return DEFAULT_INSTRUCTION_TYPE;
    }

    RotationType getInstructionRotationType(String sourceString) {

        String property = getPropertyString(sourceString, "rotation_type").toLowerCase();

        if (!property.isEmpty()) {

            for (RotationType type : RotationType.values()) {
                if (type.toString().toLowerCase().equals(property)) {
                    return type;
                }
            }
        }

        return DEFAULT_ROTATION_TYPE;
    }

    boolean getInstructionStatus(String sourceString) {

        String property = getPropertyString(sourceString, "is_active").toLowerCase();

        if (!property.isEmpty()) {

            if (property.contains("true")) {
                return true;
            } else if (property.contains("false")) {
                return false;
            }
        }

        return DEFAULT_STATUS;
    }

    int getInstructionWaterTemp(String sourceString) {

        String property = getPropertyString(sourceString, "water_temp");

        if (!property.isEmpty()) {

            try{

                return Integer.parseInt(property);

            } catch (NumberFormatException e) {
                // return default
            }
        }

        return DEFAULT_WATER_TEMP;
    }

    int getInstructionRotationTime(String sourceString) {

        String property = getPropertyString(sourceString, "rotation_time");

        if (!property.isEmpty()) {

            try{

                return Integer.parseInt(property);

            } catch (NumberFormatException e) {
                // return default
            }
        }

        return DEFAULT_ROTATION_TIME;
    }

    String getPropertyString(String sourceString, String propertyName) {

        Pattern pattern = Pattern.compile("(<" + propertyName + ">)(.+)(</" + propertyName + ">)");
        Matcher matcher = pattern.matcher(sourceString);

        if (matcher.find()) {

            return matcher.group(2).trim();
        }

        return "";
    }

    private List<String> getPropertyList(String sourceString, String propertyName) {

        List<String> propertyList = new ArrayList<>();

        Pattern pattern = Pattern.compile("(<" + propertyName + ">)(.+?)(</" + propertyName + ">)");
        Matcher matcher = pattern.matcher(sourceString);

        while (matcher.find()) {

            propertyList.add(matcher.group(2).trim());

        }

        return propertyList;
    }
}
