package ddd.bank.transverse.exception;

/**
 *
 */
public class DomainException extends BaseException {
    private static final long serialVersionUID = 6413485124943479155L;

    protected DomainException(){
        super();
    }

    protected DomainException(Throwable t){
        super(t);
    }

    public DomainException(String message){
        super(message);
    }

    public DomainException(Case exceptionCase, Object[] contextualDatas) {
        super(exceptionCase, contextualDatas);
    }

    public DomainException(Case exceptionCase, Object[] contextualDatas, Exception nestedException) {
        super(exceptionCase, contextualDatas, nestedException);
    }
}
