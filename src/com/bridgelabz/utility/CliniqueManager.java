package com.bridgelabz.utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Ajit This class manages a list of Patients, Doctors and the
 *         appointments made by Patients
 *
 */
public class CliniqueManager {

	String appointmentFile = "/home/bridgeit/Desktop/text file for inventory management/DocPatMapping.json";
	String patientsFile = "/home/bridgeit/Desktop/text file for inventory management/Doctor.json";
	String doctorsFile = "/home/bridgeit/Desktop/text file for inventory management/Patient.json";
	List<Patient> patientList;
	List<Doctor> doctorList;
	Map<Integer, Map<Integer, List<Integer>>> appointmentDetails;
	Gson gson;

	/**
	 * @throws IOException
	 *             populate list from JSON corresponding files
	 */
	public CliniqueManager() throws IOException {
		try (FileReader patientFr = new FileReader(patientsFile);
				FileReader doctorFr = new FileReader(doctorsFile);
				FileReader appointmentFr = new FileReader(appointmentFile);) {
			gson = new GsonBuilder().disableHtmlEscaping().create();

			// read patient data from JSON file
			Type patientType = new TypeToken<List<Patient>>() {
			}.getType();
			patientList = gson.fromJson(patientFr, patientType);

			// read doctor data from JSON file
			Type doctorType = new TypeToken<List<Doctor>>() {
			}.getType();
			doctorList = gson.fromJson(doctorFr, doctorType);

			// read appointment details from JSON file
			Type appointmentType = new TypeToken<Map<Integer, Map<Integer, List<Integer>>>>() {
			}.getType();
			appointmentDetails = gson.fromJson(appointmentFr, appointmentType);
		}

	}

	/**
	 * displays all the patients present in the clinique
	 */
	public void displayPatients() {
		for (Patient p : patientList)
			System.out.println(p);

	}

	/**
	 * displays all the doctors present in the clinique
	 */
	public void displayDoctors() {
		for (Doctor d : doctorList)
			System.out.println(d);
	}

	/**
	 * 
	 * saves the appointments to a file
	 * 
	 * @throws IOException
	 */
	public void saveAppointments() throws IOException {

		try (FileWriter appointmentWriter = new FileWriter(appointmentFile)) {

			gson.toJson(appointmentDetails, appointmentWriter);

		}
	}

	/**
	 * displays the weeks report of doctor's appointments with patients on each day
	 */
	public void displayReport() {
		System.out.printf("%2s %-15s PatientList \n", "No", "Doctor");
		for (Map.Entry<Integer, Map<Integer, List<Integer>>> outerEntry : appointmentDetails.entrySet()) {
			Integer i = outerEntry.getKey();

			Map<Integer, List<Integer>> docPatMap = outerEntry.getValue();
			for (Entry<Integer, List<Integer>> innerEntry : docPatMap.entrySet()) {
				Integer docId = innerEntry.getKey();
				String docName = null;

				// add stream concept here
				for (Doctor doctor : doctorList) {
					if (doctor.getId() == docId) {
						docName = doctor.getName();
					}
				}

				// display day and doctor details
				System.out.printf("%2d %-15s ", i, docName);

				List<Integer> docPatients = innerEntry.getValue();
				for (Integer patientId : docPatients) {
					System.out.printf("%2d, ", patientId);
				}
				System.out.println();
			}
		}
	}

	/**
	 * @param day
	 *            i.e. day on which the appointment is to be made
	 * @param pId
	 *            i.e. patient id who is making the appointment
	 * @param docId
	 *            i.e. doctor id with whom the appointment is being booked
	 * @return true if appointment is booked successfully false otherwise
	 */
	public boolean makeAppointment(int day, int pId, int docId) {
		// dig in the map to first find the doctor's
		Map<Integer, List<Integer>> docPatMap = appointmentDetails.get(day);

		List<Integer> dailyPatients = docPatMap.get(docId);

		if (dailyPatients == null) {
			dailyPatients = new ArrayList<>();
		}

		// check if the doctors appointments are full for that day
		if (dailyPatients.size() == 3) {
			System.out.println("Sorry, the appointments are full for this doctor");
			return false;
		}

		// now check if the patient has already booked an appointment for that day
		// add filter streams to optimize this
		for (Integer patientId : dailyPatients) {
			if (patientId == pId) {
				System.out.println("You have already booked an appointment");
				return false;
			}
		}

		// if these conditions fail then add the patient to the doctors appointment for
		// that day
		dailyPatients.add(pId);
		System.out.println("Appointment made successfully");
		System.out.println(dailyPatients);
		return true;

	}

	/**
	 * @param day
	 *            inorder to get the availability of doctors and their IDs
	 */
	public void showDailyDoctors(int day) {
		

			displayDoctors();
		
	}

}