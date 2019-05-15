/*
package org.openmrs.module.appointmentscheduling.rest.resource.openmrs1_9;

import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.VisitType;
import org.openmrs.api.context.Context;
import org.openmrs.module.appointmentscheduling.Appointment;
import org.openmrs.module.appointmentscheduling.AppointmentType;
import org.openmrs.module.appointmentscheduling.AppointmentDailyCount;
import org.openmrs.module.appointmentscheduling.TimeSlot;
import org.openmrs.module.appointmentscheduling.api.AppointmentService;
import org.openmrs.module.appointmentscheduling.rest.controller.AppointmentRestController;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.ConversionUtil;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.api.RestService;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.api.Searchable;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingReadableResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;

@Resource(name = RestConstants.VERSION_1 + "/appointmentreport",
        supportedClass = AppointmentDailyCount.class, supportedOpenmrsVersions = {"1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*"})
public class DailyAppointmentCountsResource1_9 extends BaseDelegatingReadableResource<AppointmentDailyCount> implements Searchable {

    */
/* BaseDelegatingReadableResource<Extension> implements Searchable {

    private AppFrameworkService getService() {
        return Context.getService(AppFrameworkService.class);
    }

    p
*//*

    private AppointmentService getService(){
        return Context.getService(AppointmentService.class);
    }
    @Autowired
    private RestService service;

    @Override
    public AppointmentDailyCount getByUniqueId(String s) {
        return null;
    }

    @Override
    protected void delete(AppointmentDailyCount appointmentDailyCount, String s, RequestContext requestContext) throws ResponseException {

    }

    @Override
    public AppointmentDailyCount newDelegate() {
        return null;
    }

    @Override
    public AppointmentDailyCount save(AppointmentDailyCount appointmentDailyCount) {
        return null;
    }

    @Override
    public void purge(AppointmentDailyCount appointmentDailyCount, RequestContext requestContext) throws ResponseException {

    }
    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation representation) {
        if (representation instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("date");
            description.addProperty("dailyCount");
            description.addProperty("appointments", Representation.REF);
            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (representation instanceof FullRepresentation || representation instanceof RefRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("date");
            description.addProperty("dailyCount");
            description.addProperty("appointments", Representation.FULL);
            description.addSelfLink();
            return description;
        }

        return null;
    }
*/
/*
    @Override
    public NeedsPaging<AppointmentDailyCount> doGetAll(RequestContext context) {
        return new NeedsPaging<AppointmentDailyCount>(getService().getAppointmentDailyCount(null, null,
                null, null), context);
    }*//*


    @Override
    protected PageableResult doSearch(RequestContext context) {

*/
/*
        String status = context.getRequest().getParameter("status");

        Appointment.AppointmentStatus appointmentStatus = Appointment.AppointmentStatus.valueOf(status);

        Date fromDate = context.getParameter("fromDate") != null ? (Date) ConversionUtil.convert(
                context.getParameter("fromDate"), Date.class) : null;

        Date toDate = context.getParameter("toDate") != null ? (Date) ConversionUtil.convert(context.getParameter("toDate"),
                Date.class) : null;

        AppointmentType appointmentType = context.getParameter("appointmentType") != null ? Context.getService(
                AppointmentService.class).getAppointmentTypeByUuid(context.getParameter("appointmentType")) : null;

        Provider provider = context.getParameter("provider") != null ? Context.getProviderService().getProviderByUuid(
                context.getParameter("provider")) : null;

        Location location = context.getParameter("location") != null ? Context.getLocationService().getLocationByUuid(
                context.getParameter("location")) : null;

        VisitType visitType = context.getParameter("visitType") != null ? Context.getVisitService().getVisitTypeByUuid(
                context.getParameter("visitType")) : null;

*//*


        return new NeedsPaging<AppointmentDailyCount>(getService().getAppointmentDailyCount(null, null,
                null, null), context);
        //(Date fromDate, Date toDate, Location location, Provider provider)
        //		return appointmentDAO.getAppointmentDailyCount(null, null, null, null, null, null, null);
    }
}
*/
