package tech.pathtoprogramming.service;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.doesNotHave;
import static org.mockito.ArgumentMatchers.any;

class Event {
    String organizerEmailAddress;
    String title;
    Date date;
    String agenda;
    String[] participants;

    public Event(String organizerEmailAddress, String title, Date date, String agenda, String[] participants) {
        this.organizerEmailAddress = organizerEmailAddress;
        this.title = title;
        this.date = date;
        this.agenda = agenda;
        this.participants = participants;
    }
}

class EmailService {

    private static EmailService instance;

    private EmailService() {
    }

    public static EmailService getInstance() {
        if (instance == null) {
            instance = new EmailService();
        }
        return instance;
    }

    public void send(Event event) {
        String host = "65.54.254.145";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(event.organizerEmailAddress));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("my-group@hotmail.com"));

            // Set Subject: header field
            message.setSubject(event.title);

            // Now set the actual message
            message.setText(event.agenda);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Scheduler {

    private EmailService emailService;
    private List<Event> events;

    public Scheduler() {
        this.emailService = EmailService.getInstance();
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);

        System.out.println("Event added");

        sendEmail(event);
    }

    protected void sendEmail(Event event) {
        emailService.send(event);
    }
}

class SchedulerTest {

    @Test
    void addEvent_addsEventToTheList() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Scheduler scheduler = Mockito.spy(new Scheduler());

        Mockito.doNothing().when(scheduler).sendEmail(any());

        Event event = new Event(
                "steven_a_diamante@bcbsil.com",
                "Java COP Meeting",
                new GregorianCalendar(2020, Calendar.NOVEMBER, 4).getTime(),
                "Learn how to apply TDD to Legacy Code",
                new String[]{"Warren", "Brittney", "Nick", "Eric", "Danny"}
        );

        scheduler.addEvent(event);

        assertThat(scheduler.getEvents().size()).isEqualTo(1);
        assertThat(scheduler.getEvents().get(0).agenda).isEqualTo("Learn how to apply TDD to Legacy Code");
        assertThat(stream.toString()).isEqualTo("Event added\n");
    }
}
