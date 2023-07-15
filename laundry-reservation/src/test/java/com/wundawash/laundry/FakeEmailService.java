package com.wundawash.laundry;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeEmailService implements EmailService {

    private final Queue<ConfirmationEmailDto> emails;

    public FakeEmailService() {
        this.emails = new ArrayDeque<>();
    }

    @Override
    public void sendConfirmationEmail(ConfirmationEmailDto email) {
        emails.add(email);
    }

    public void shouldHaveSentExactly(ConfirmationEmailDto expectedEmail) {
        assertThat(emails).hasSize(1);
        assertThat(emails.stream().findFirst())
                .isPresent()
                .contains(expectedEmail);
    }
}
