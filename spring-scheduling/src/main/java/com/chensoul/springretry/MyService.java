package com.chensoul.springretry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.sql.SQLException;


public interface MyService {

    @Retryable
    void retryService();

    @Retryable(value = SQLException.class)
    void retryServiceWithRecovery(String sql) throws SQLException;

    @Retryable(value = SQLException.class , maxAttempts = 2, backoff = @Backoff(delay = 100))
    void retryServiceWithCustomization(String sql) throws SQLException;

    @Retryable(value = SQLException.class, maxAttemptsExpression = "${retry.maxAttempts}",
                        backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    void retryServiceWithExternalConfiguration(String sql) throws SQLException;

    @Recover
    void recover(SQLException e, String sql);

    void templateRetryService();
}
