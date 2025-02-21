package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Appointment;

class AppointmentTest {

	@Test
	void testAppointmentClass() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888" , insertDate , "This is the description for the appointment");
		assertTrue(testAppointment.getAppointmentId().equals("7888"));
		assertTrue(testAppointment.getAppointmentDate().equals(insertDate));
		assertTrue(testAppointment.getAppointmentDesc().equals("This is the description for the appointment"));
	}
	
	@Test
	void GivenNullId_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		new Appointment(null , insertDate , "This is the description for the appointment");
		});
	}
	
	@Test
	void GivenIdOverTen_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("123456789010" , insertDate , "This is the description for the appointment");
		});
	}
	
	@Test
	void GivenIdAtTen_WhenCreatingAppointment_ThenSuccessfulCreation() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("1234567890", insertDate, "This is the description for the appointment");
		assertTrue(testAppointment.getAppointmentId().equals("1234567890"));
	}
	
	@Test 
	void GivenNullDescription_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("7888", insertDate, null);
		});
	}

	@Test
	void GivenDescriptionAtFifty_WhenCreatingAppointment_ThenSuccessfulCreation() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		assertTrue(testAppointment.getAppointmentDesc().equals("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"));
	}
	
	@Test
	void GivenDescriptionOverFifty_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888", insertDate, "thissisisisisisisisisisisisisiekkknjnekekdisisksknfndasjdkngadvda");
		});
	}
	
	@Test
	void GivenDateBeforeCurrent_WhenCreatingApplication_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2022, Month.AUGUST, 25, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888", insertDate, "this is the description");
		});
	}
	
}
