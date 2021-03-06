package BLL.exeptions;

public class UserException extends Throwable {
    String exceptionMessage;
    String instructions;

    public UserException(String exceptionMessage,Exception exception){
        System.out.println( exceptionMessage+"\n" + exception);
        this.exceptionMessage=exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
