package strategy;

import scheduler.Appointment;

import java.util.ArrayList;
import java.util.List;

public class BasicAppointmentStrategy implements AppointmentStrategy {
    private List<Appointment> appointments = new ArrayList<>();


    public BasicAppointmentStrategy(ArrayList<Object> objects) {
      // for future
    }

    @Override
    public void schedule(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Basic appointment scheduled: " + appointment);
    }

    @Override
    public void view() {
        if (appointments.isEmpty()) {
            System.out.println("No basic appointments found.");
        } else {
            System.out.println("Basic Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    @Override
    public void cancel(int appointmentId) {
        boolean removed = false;
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                appointments.remove(appointment);
                removed = true;
                System.out.println("Basic appointment canceled with ID: " + appointmentId);
                break;
            }
        }
        if (!removed) {
            System.out.println("No basic appointment found with ID: " + appointmentId);
        }
    }
}
