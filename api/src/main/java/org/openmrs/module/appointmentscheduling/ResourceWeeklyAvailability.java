package org.openmrs.module.appointmentscheduling;

import org.openmrs.BaseOpenmrsData;

public class ResourceWeeklyAvailability extends BaseOpenmrsData {

    private Integer resourceWeeklyAvailabilityId;

    private AppointmentResource appointmentResource;

    private String monday;

    private String tuesday;

    private String wednesday;

    private String thursday;

    private String friday;

    private String saturday;

    private String sunday;

    public ResourceWeeklyAvailability() {
    }

    public ResourceWeeklyAvailability(AppointmentResource appointmentResource, String monday, String tuesday,
                                      String wednesday, String thursday, String friday, String saturday, String sunday) {
        setAppointmentResource(appointmentResource);
        setMonday(monday);
        setTuesday(tuesday);
        setWednesday(wednesday);
        setThursday(thursday);
        setFriday(friday);
        setSaturday(saturday);
        setSunday(sunday);
    }

    public Integer getResourceWeeklyAvailabilityId() {
        return resourceWeeklyAvailabilityId;
    }

    public void setResourceWeeklyAvailabilityId(Integer resourceWeeklyAvailabilityId) {
        this.resourceWeeklyAvailabilityId = resourceWeeklyAvailabilityId;
    }

    public AppointmentResource getAppointmentResource() {
        return appointmentResource;
    }

    public void setAppointmentResource(AppointmentResource appointmentResource) {
        this.appointmentResource = appointmentResource;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    @Override
    public Integer getId() {
        return getResourceWeeklyAvailabilityId();
    }

    @Override
    public void setId(Integer id) {
        setResourceWeeklyAvailabilityId(id);
    }
}