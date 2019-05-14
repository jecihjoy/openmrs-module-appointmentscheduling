package org.openmrs.module.appointmentscheduling.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.api.context.Context;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.AppointmentDTO;
import org.openmrs.module.appointmentscheduling.AppointmentType;
import org.openmrs.module.appointmentscheduling.TimeSlot;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.appointmentscheduling.exception.TimeSlotFullException;
import org.openmrs.module.appointmentscheduling.rest.controller.AppointmentRestController;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.validation.ValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + AppointmentRestController.APPOINTMENT_SCHEDULING_REST_NAMESPACE +"/test")
//@RequestMapping(value = RestConstants.VERSION_1 + "/appointmentmodule"  + "/appointmentdto")
public class AppointmentDTOController {
    protected final Log log = LogFactory.getLog(this.getClass());

/*
    @RequestMapping(value = "/appointmentdto", method = RequestMethod.POST,
            headers = { "Accept=application/json", "Content-Type=application/json" })
    public String saveAppointment(@RequestParam (value = "value") String value){


        return value;

    }*/

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Appointment getTestData() {
        Appointment appointment = new Appointment(new TimeSlot(),null,null,null, Appointment.AppointmentStatus.MISSED, new Date(),null, null);
        return appointment;
    }

    @RequestMapping( method = RequestMethod.POST, value = "/testdto")
    @ResponseBody
    public AppointmentDTO getPostedData( @RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setPatient(Context.getPatientService().getPatientByUuid(appointmentDTO.getPatient()));
        appointment.setStatus(Appointment.AppointmentStatus.valueOf(appointmentDTO.getStatus()));
        appointment.setAppointmentType(Context.getService(AppointmentService.class).getAppointmentTypeByUuid(appointmentDTO.getAppointmentType()));
        appointment.setDate(appointmentDTO.getDate());
        appointment.setLocation(Context.getLocationService().getLocationByUuid(appointmentDTO.getLocation()));
        appointment.setProvider(Context.getProviderService().getProviderByUuid(appointmentDTO.getProvider()));

        save(appointment, false);

        return appointmentDTO;

    }

    protected Appointment save(Appointment appointment, Boolean allowOverbook) {
        log.error("reached here" + appointment);
        log.error("reached here" + appointment.getPatient());
        log.error("reached here" + appointment.getStatus());
        log.error("reached here" + appointment.getAppointmentType());
        log.error("reached here" + appointment.getDate());
        log.error("reached here" + appointment.getLocation());
        log.error("reached here" + appointment.getProvider());
        if (appointment.getId() != null) {
            // existing appointments get updated
            return Context.getService(AppointmentService.class).saveAppointment(appointment);
        } else {
            // new appointments get booked
            try {
                return Context.getService(AppointmentService.class).bookAppointment(appointment, allowOverbook);
            }
            catch (TimeSlotFullException e) {
                Errors errors = new BindException(appointment, "");
                errors.reject("appointmentscheduling.Appointment.error.timeSlotFull");
                throw new ValidationException("appointmentscheduling.Appointment.error.timeSlotFull", errors);
            }
        }
    }

/*    @RequestMapping(method = RequestMethod.POST,
            headers = { "Accept=application/json", "Content-Type=application/json" })
    public  @ResponseBody AppointmentDTO saveAppointment(@RequestBody AppointmentDTO appointmentDTO){


        AppointmentService service = Context.getService(AppointmentService.class);
        Appointment appointment = new Appointment();
        appointment.setPatient(Context.getPatientService().getPatientByUuid(appointmentDTO.getPatient()));
        appointment.setStatus(Appointment.AppointmentStatus.valueOf(appointmentDTO.getStatus()));
        appointment.setAppointmentType(Context.getService(AppointmentService.class).getAppointmentTypeByUuid(appointmentDTO.getAppointmentType()));
        appointment.setDate(appointmentDTO.getDate());
        appointment.setLocation(Context.getLocationService().getLocationByUuid(appointmentDTO.getLocation()));
        appointment.setProvider(Context.getProviderService().getProviderByUuid(appointmentDTO.getProvider()));

        save(appointment, false);

        return appointmentDTO;

    }*/
    /*
@RequestMapping(value = "/appointmentdto", method = RequestMethod.POST,
            headers = { "Accept=application/json", "Content-Type=application/json" })
    public Appointment saveAppointment(@RequestParam AppointmentDTO appointmentDTO){
        AppointmentService service = Context.getService(AppointmentService.class);
        Appointment appointment = new Appointment();
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setAppointmentType(appointmentDTO.getAppointmentType());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setLocation(appointmentDTO.getLocation());
        appointment.setProvider(appointmentDTO.getProvider());

        return save(appointment, false);
    }*/

}