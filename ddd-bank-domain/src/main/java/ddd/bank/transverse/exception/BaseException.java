package ddd.bank.transverse.exception;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 *
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -308108559858339219L;

    private Case exceptionCase;

    private Object[] contextualDatas;

    protected BaseException() {
        super();
    }

    protected BaseException(Throwable t) {
        super(t);
    }

    /**
     * Constructor used for simple message associated where the Case object is too heavy to be used
     * @param message
     */
    public BaseException(String message){
        super(message);
    }

    public BaseException(Case exceptionCase, Object[] newContextualDatas) {
        super();
        this.exceptionCase = exceptionCase;
        setContextualDatas(newContextualDatas);
    }

    public BaseException(Case exceptionCase, Object[] newContextualDatas, Exception nestedException) {
        super(nestedException);
        this.exceptionCase = exceptionCase;
        setContextualDatas(newContextualDatas);
    }

    public Case getExceptionCase() {
        return this.exceptionCase;
    }

    private void setContextualDatas(Object[] newContextualDatas) {
        if (newContextualDatas == null) {
            this.contextualDatas = new String[0];
        } else {
            this.contextualDatas = Arrays.copyOf(newContextualDatas, newContextualDatas.length);
        }

    }

    public Object[] getContextualDatas() {
        return this.contextualDatas;
    }

    /**
     * Bug : MessageFormat ne fonctionne pas quand il y a un \"XXX 'XXX \". IL faut mettre double quote pour que le formating fonctionne
     *
     * @param msgToPrepare
     * @return
     */
    protected String prepareStringForMessageFormat(String msgToPrepare) {
        String regExpAllApostrophe = "'+";
        String replaceByDoubleApostrophe = "''";
        return msgToPrepare.replaceAll(regExpAllApostrophe, replaceByDoubleApostrophe);
    }

    @Override
    public String getMessage() {
        StringBuffer sb = new StringBuffer();
        sb.append(exceptionCase.getId()).append(" - ");
        if (getContextualDatas() != null) {
            sb.append(MessageFormat.format(prepareStringForMessageFormat(exceptionCase.getDescription()), getContextualDatas()));
            sb.append(" - ").append(exceptionCase.getSuggestion());
        } else {
            sb.append(exceptionCase.getSuggestion());
        }
        return sb.toString();
    }

}
