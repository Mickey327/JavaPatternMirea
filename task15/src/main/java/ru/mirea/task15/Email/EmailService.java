package ru.mirea.task15.Email;

import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

public interface EmailService {
    @Async
    void sendSimpleEmail(String toAddress, String subject, String message);
    @Async
    void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException;
}
