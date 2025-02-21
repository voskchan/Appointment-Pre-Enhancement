package services;

import java.time.LocalDateTime;


public class Appointment {

	private String appointmentId;
	private LocalDateTime appointmentDate;
	private String appointmentDesc;
	
	public Appointment(String appointmentId, LocalDateTime appointmentDate, String appointmentDesc) {
		
		if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else if(appointmentDate == null || appointmentDate.isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		else if(appointmentDesc == null || appointmentDesc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		else {
			this.appointmentId = appointmentId;
			this.appointmentDate = appointmentDate;
			this.appointmentDesc = appointmentDesc;
		}
		
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	
	
	
}
