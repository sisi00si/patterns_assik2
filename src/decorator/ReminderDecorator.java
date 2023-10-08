package decorator;

import scheduler.Appointment;
import strategy.AppointmentStrategy;

public class ReminderDecorator implements SchedulerDecorator {
    private AppointmentStrategy scheduler;

    @Override
    public void setScheduler(AppointmentStrategy scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void schedule(Appointment appointment) {
        scheduler.schedule(appointment);
        sendReminder(appointment);
    }

    @Override
    public void view() {
        scheduler.view();
    }

    @Override
    public void cancel(int appointmentId) {
        scheduler.cancel(appointmentId);
    }

    @Override
    public void sendReminder(Appointment appointment) {
        System.out.println("Reminder sent for appointment ID: " + appointment.getId());
    }
}