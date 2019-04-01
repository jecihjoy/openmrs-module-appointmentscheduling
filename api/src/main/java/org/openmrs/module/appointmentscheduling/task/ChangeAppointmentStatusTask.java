package org.openmrs.module.appointmentscheduling.task;

import org.joda.time.DateTime;
import org.openmrs.api.context.Context;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.scheduler.tasks.AbstractTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;

public class ChangeAppointmentStatusTask extends AbstractTask{

    private static final Logger log = LoggerFactory.getLogger(ChangeAppointmentStatusTask.class);


    @Override
    public void execute() {
        AppointmentService appointmentService = Context.getService(AppointmentService.class);

        Date endOfYesterday = new DateTime().withTime(21,30,59,999).minusDays(1).toDate();

        log.error("TASK RUNNING");
        log.error("TASK RUNNING" + endOfYesterday);

        for (Appointment appointment : appointmentService.getAppointmentsByConstraints(null, endOfYesterday, null, null, null, null,
                Appointment.AppointmentStatus.getAppointmentsStatusByTypes(Arrays.asList(Appointment.AppointmentStatusType.SCHEDULED)))) {
            appointment.setStatus(Appointment.AppointmentStatus.MISSED);
            appointmentService.saveAppointment(appointment);
        }

    }

}
