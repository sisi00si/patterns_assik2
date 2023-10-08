package strategy;

import scheduler.Appointment;

public interface AppointmentStrategy {
    void schedule(Appointment appointment);
    void view();
    void cancel(int appointmentId);
}
