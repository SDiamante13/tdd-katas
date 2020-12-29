package tech.pathtoprogramming.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginServiceTest {

    private LoginService loginService = new LoginService();

    @Test
    void login_returnsAString() {
        String username = "sam445";

        String result = loginService.login(username);

        assertThat(result).isEqualTo("");
    }
}
