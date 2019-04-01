package org.openmrs.module.appointmentscheduling.rest.resource.openmrs1_9;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.VisitType;
import org.openmrs.api.context.Context;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.AppointmentType;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.appointmentscheduling.rest.controller.AppointmentRestController;
import org.openmrs.module.webservices.rest.web.ConversionUtil;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.Date;

import static org.openmrs.module.appointmentscheduling.Appointment.AppointmentStatus;

@Resource(name = RestConstants.VERSION_1 + AppointmentRestController.APPOINTMENT_SCHEDULING_REST_NAMESPACE + "/appointmentreporting",
        supportedClass = Appointment.class, supportedOpenmrsVersions = {"1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*"})
public class AppointmentReportingResource1_9 extends DataDelegatingCrudResource<Appointment> {

    @Override
    public Appointment getByUniqueId(String uniqueId) {
        return null;
    }

    @Override
    protected void delete(Appointment delegate, String reason, RequestContext context) throws ResponseException {

    }

    @Override
    public Appointment newDelegate() {
        return null;
    }

    @Override
    public Appointment save(Appointment delegate) {
        return null;
    }

    @Override
    public void purge(Appointment delegate, RequestContext context) throws ResponseException {

    }

    @Override
    protected PageableResult doGetAll(RequestContext context) throws ResponseException {
        AppointmentService service = Context.getService(AppointmentService.class);
        return new NeedsPaging<Appointment>(service.getAllAppointments(context.getIncludeAll()), context);
    }

    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation representation) {
        if (representation instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("timeSlot", Representation.DEFAULT);
            description.addProperty("visit", Representation.REF);
            description.addProperty("patient", Representation.DEFAULT);
            description.addProperty("status");
            description.addProperty("reason");
            description.addProperty("cancelReason");
            description.addProperty("appointmentType", Representation.REF);
            description.addProperty("voided");
            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (representation instanceof FullRepresentation || representation instanceof RefRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("timeSlot", Representation.FULL);
            description.addProperty("visit", Representation.FULL);
            description.addProperty("patient", Representation.FULL);
            description.addProperty("status");
            description.addProperty("reason");
            description.addProperty("cancelReason");
            description.addProperty("appointmentType", Representation.FULL);
            description.addProperty("voided");
            description.addProperty("auditInfo", findMethod("getAuditInfo"));
            description.addSelfLink();
            return description;
        }

        return null;
    }

    @Override
    protected PageableResult doSearch(RequestContext context) {
        String status = context.getRequest().getParameter("status");
        if(status == null){
            status = "SCHEDULED";
        }
        AppointmentStatus appointmentStatus = AppointmentStatus.valueOf(status);

        Date fromDate = context.getParameter("fromDate") != null ? (Date) ConversionUtil.convert(
                context.getParameter("fromDate"), Date.class) : null;

        Date toDate = context.getParameter("toDate") != null ? (Date) ConversionUtil.convert(context.getParameter("toDate"),
                Date.class) : null;

        AppointmentType appointmentType = context.getParameter("appointmentType") != null ? Context.getService(
                AppointmentService.class).getAppointmentTypeByUuid(context.getParameter("appointmentType")) : null;

        Provider provider = context.getParameter("provider") != null ? Context.getProviderService().getProviderByUuid(
                context.getParameter("provider")) : null;

        Patient patient = context.getParameter("patient") != null ? Context.getPatientService().getPatientByUuid(
                context.getParameter("patient")) : null;

        Location location = context.getParameter("location") != null ? Context.getLocationService().getLocationByUuid(
                context.getParameter("location")) : null;

        VisitType visitType = context.getParameter("visitType") != null ? Context.getVisitService().getVisitTypeByUuid(
                context.getParameter("visitType")) : null;

        Integer minDays = context.getParameter("minDefaultPeriod") != null ? (Integer) ConversionUtil.convert(
                context.getParameter("minDefaultPeriod"), Integer.class) : 0;

        Integer maxDays = context.getParameter("maxDefaultPeriod") != null ? (Integer) ConversionUtil.convert(
                context.getParameter("maxDefaultPeriod"), Integer.class) : 0;

        if (fromDate != null && toDate == null){
            return new NeedsPaging<Appointment>(Context.getService(AppointmentService.class).getDailyAppointmentReports(
                    fromDate, provider, appointmentType, appointmentStatus, patient, visitType, location), context);

        }else if(fromDate != null && toDate  != null){

            return new NeedsPaging<Appointment>(Context.getService(AppointmentService.class).getMonthlyAppointmentReports(
                    fromDate, toDate, provider, appointmentType, appointmentStatus, patient, visitType, location), context);

        }else if(minDays != null || maxDays != null ){
            return new NeedsPaging<Appointment>(Context.getService(AppointmentService.class).getDefaultersList(
                    minDays, maxDays, provider, appointmentType, visitType, location), context);
        }
        return null;
    }

}
