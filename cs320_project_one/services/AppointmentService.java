package services;

import java.util.ArrayList;

public class AppointmentService {

	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	public int checkArrayForId(String id) {
		
		for(int i = 0; i < appointmentList.size(); i++) {
			if (id.equals(appointmentList.get(i).getAppointmentId())) {
				return i;
			}
		}
		return -100;
	}
	
	public void addAppointment(Appointment newAppointment) {
		if(checkArrayForId(newAppointment.getAppointmentId()) == -100) {
			appointmentList.add(newAppointment);
		}
		else {
			throw new IllegalArgumentException("ID already exists");
		}
	}
	
	public int arraySize() {
		return appointmentList.size();
	}
	
	public void deleteAppointment(String id) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			appointmentList.remove(checkArrayForId(id));
		}
		
	}
	
	public Appointment pullAppointment(String id) {
		if (checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			return appointmentList.get(checkArrayForId(id));
		}
		
	}
}
