package io.com.product.api.productmanagement.exception.response;
import java.util.List;
import java.util.Objects;

/**
 * {@summary error response class. }
 * @author abhis
 *
 */
public class ErrorResponse {

    /**
     * {@summary int errorcode. }
     * It stores response error code.
     */
    private Integer errorCode;
    /**
     * {@summary list od error msg. }
     * It stores list of error messages.
     */
    private List<String> errorMessages;
    /**
     * {@summary def cons. }
     * Default constructor.
     */
    public ErrorResponse() {
    }
    /**
     *{@summary agr const. }
     * @param errorCode stores response status name.
     * @param errorMessages stores list of error messages.
     */
    public ErrorResponse(final Integer errorCode,
            final List<String> errorMessages) {
        this.errorCode = errorCode;
        this.errorMessages = errorMessages;
    }
    /**
     *{@summary retrun int. }
     * @return status code name
     */
    public final Integer getErrorCode() {
        return errorCode;
    }
    /**
     *{@summary return void. }
     * @param errorCode set status code name.
     */
    public final void setErrorCode(final Integer errorCode) {
        this.errorCode = errorCode;
    }
    /**
     *{@summary list of string error. }
     * @return list of messages describing the error.
     */
    public final List<String> getErrorMessages() {
        return errorMessages;
    }
    /**
     *{@summary return void. }
     * @param errorMessages stores list of messages
     */
    public final void setErrorMessages(final List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
    /**
     * {@summary hashcode. }
     * To return hash code of object.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(errorMessages, errorCode);
    }
    /**
     * {@summary equal method. }
     * Compares two objects of error response class.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ErrorResponse other = (ErrorResponse) obj;
        return Objects.equals(errorMessages, other.errorMessages)
                && Objects.equals(errorCode, other.errorCode);
    }
}
