package mx.poc.cors.exceptions;

public class InternalException extends BaseException{

    public InternalException(final Exception e) {
        super(e);
    }

    public InternalException(final String desc, final Exception e) {
        super(desc, e);
    }

    public InternalException(final String string) {
        super(string);
    }
}
