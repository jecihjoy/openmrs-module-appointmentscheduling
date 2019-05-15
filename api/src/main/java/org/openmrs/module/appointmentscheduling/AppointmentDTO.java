package org.openmrs.module.appointmentscheduling;

public class AppointmentDTO {

    private String patient;

    private String status;

    private String appointmentType;

    private String date;

    private String location;

    private String provider;

    public AppointmentDTO() {
    }

    public AppointmentDTO(String patient, String status, String appointmentType, String date, String location, String provider) {
        setPatient(patient);
        setStatus(status);
        setAppointmentType(appointmentType);
        setDate(date);
        setLocation(location);
        setProvider(provider);
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
