package Exceptions;

public class CustomerLoginError extends Exception {


    @Override
    public String getMessage() {
        return "Customer login error: wrong login name or password.";
    }
}
