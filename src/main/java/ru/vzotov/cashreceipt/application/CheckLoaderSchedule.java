package ru.vzotov.cashreceipt.application;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckLoaderSchedule {

    private static final long ONE_MINUTE = 60 * 1000;
    private static final long TEN_MINUTES = 10 * 60 * 1000;
    private static final long THIRTY_MINUTES = 3 * TEN_MINUTES;

    private final CheckRegistrationService registrationService;

    public CheckLoaderSchedule(CheckRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Scheduled(fixedDelay = THIRTY_MINUTES, initialDelay = ONE_MINUTE)
    public void triggerLoadChecks() {
        registrationService.loadNewChecks();
    }

}
