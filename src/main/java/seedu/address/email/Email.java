package seedu.address.email;

import seedu.address.email.exceptions.EmailSendFailedException;
import seedu.address.email.exceptions.LoginFailedException;
import seedu.address.email.exceptions.NotAnEmailException;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

/**
 * API of Email component
 */

public interface Email {
    /**
     * Returns a log-in session object that can be used to send and receive email
     * @param email The email address that needs to be logged in
     * @param password Password
     * @throws NoSuchProviderException if the email provider does not exist
     * @throws NotAnEmailException if the given email is not valid
     */
    public void login(String email, String password) throws LoginFailedException;

    /**
     * Checks emails from the logged in email
     * @return A String array in which each element is an email
     */
    public String[] checkEmails();

    /**
     *
     * @param recipients Recipients' emails
     * @param title Title of the email
     * @param message Message to be included in email
     * @throws NotAnEmailException if the given emails is/are not valid
     * @throws MessagingException if the emails were failed to send
     */
    public void sendEmail(String[] recipients, String title, String message) throws NotAnEmailException, EmailSendFailedException;

    /**
     * Return the current logged in email
     * @return Email address
     */
    public String getEmail();

    /**
     * Check if there is an email logged in or not
     * @return whether there is an email logged in
     */
    public boolean isLoggedIn();
}