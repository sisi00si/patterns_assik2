import decorator.ReminderDecorator;
import scheduler.Appointment;
import singleton.AppointmentScheduler;
import strategy.AppointmentStrategy;
import strategy.BasicAppointmentStrategy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = AppointmentScheduler.getInstance();


        BasicAppointmentStrategy basicStrategy = new BasicAppointmentStrategy(new ArrayList<>());

        // Decorate the BasicAppointmentStrategy with a reminder
        ReminderDecorator reminderDecorator = new ReminderDecorator();
        reminderDecorator.setScheduler(basicStrategy);

        scheduler.setAppointmentStrategy(reminderDecorator);

        Appointment appointment1 = new Appointment("2023-10-10", "10:00 AM", "General Checkup");
        Appointment appointment2 = new Appointment("2023-10-12", "02:30 PM", "Dental Cleaning");

        scheduler.scheduleAppointment(appointment1);
        scheduler.scheduleAppointment(appointment2);

        System.out.println("Scheduled Appointments:");
        scheduler.viewAppointments();

        int appointmentIdToCancel = 1;
        scheduler.cancelAppointment(appointmentIdToCancel);

        System.out.println("\nAppointments after Cancellation:");
        scheduler.viewAppointments();
    }
}