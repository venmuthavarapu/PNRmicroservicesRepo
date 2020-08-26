/**
 * CalculatorCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package mypack;


/**
 *  CalculatorCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class CalculatorCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public CalculatorCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public CalculatorCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for divide method
     * override this method for handling normal response from divide operation
     */
    public void receiveResultdivide(mypack.CalculatorStub.DivideResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from divide operation
     */
    public void receiveErrordivide(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for add method
     * override this method for handling normal response from add operation
     */
    public void receiveResultadd(mypack.CalculatorStub.AddResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from add operation
     */
    public void receiveErroradd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for multiply method
     * override this method for handling normal response from multiply operation
     */
    public void receiveResultmultiply(
        mypack.CalculatorStub.MultiplyResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from multiply operation
     */
    public void receiveErrormultiply(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for subtract method
     * override this method for handling normal response from subtract operation
     */
    public void receiveResultsubtract(
        mypack.CalculatorStub.SubtractResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from subtract operation
     */
    public void receiveErrorsubtract(java.lang.Exception e) {
    }
}
