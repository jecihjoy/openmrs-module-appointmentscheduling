package org.openmrs.module.appointmentscheduling;

import org.openmrs.BaseOpenmrsData;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AppointmentDailyCount extends BaseOpenmrsData implements Serializable {

    private Date date;

    private int dailyCount;

    private List<Appointment> appointments;

    public AppointmentDailyCount() {

    }

    public AppointmentDailyCount(Date date, int dailyCount, List<Appointment> appointments) {
        this.date = date;
        this.dailyCount = dailyCount;
        this.appointments = appointments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public int getDailyCount() {
        return dailyCount;
    }

    public void setDailyCount(int dailyCount) {
        this.dailyCount = dailyCount;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer integer) {

    }
}
