package com.example.notes.exception;

public class ErrorResponse {

    private String status;
    private String message;
    private String details;

    /**
     * Instantiates a new Error response.
     *
     *
     * @param status the status
     * @param message the message
     * @param details the details
     */
    public ErrorResponse( String status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }


    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
