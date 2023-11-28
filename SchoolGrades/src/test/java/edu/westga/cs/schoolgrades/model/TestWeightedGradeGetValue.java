package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestWeightedGradeGetValue {

    private static final double DELTA = 0.001;
    private WeightedGrade weightedGrade;
    private Grade mockGrade;

    @BeforeEach
    public void setup() {
        mockGrade = Mockito.mock(Grade.class);
        
        Mockito.when(mockGrade.getValue()).thenReturn(100.0);
    }

    @Test
    public void shouldApplyZeroWeight() {
        weightedGrade = new WeightedGrade(mockGrade, 0);
        assertEquals(0, weightedGrade.getValue(), DELTA);
    }

    @Test
    public void shouldApplyWeightOfOne() {
        weightedGrade = new WeightedGrade(mockGrade, 1);
        assertEquals(100, weightedGrade.getValue(), DELTA);
    }

    @Test
    public void shouldApplyWeightBetweenZeroAndOne() {
        weightedGrade = new WeightedGrade(mockGrade, 0.5);
        assertEquals(50, weightedGrade.getValue(), DELTA);
    }
}
