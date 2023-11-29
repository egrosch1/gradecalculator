package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TestCompositeGradeConstructor {

	
	
	@Test
	public void shouldNotAllowNullStrategy() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new CompositeGrade(null);
		});
	}
	
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		SumOfGradesStrategy mockStrategy = mock(SumOfGradesStrategy.class);
		CompositeGrade grade = new CompositeGrade(mockStrategy);
		assertTrue(grade.getGrades().isEmpty());
	}

}
