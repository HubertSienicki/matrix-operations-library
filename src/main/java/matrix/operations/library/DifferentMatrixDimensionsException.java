/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.operations.library;

/**
 *
 * @author kneiv
 */
public class DifferentMatrixDimensionsException extends Exception {
    
    public DifferentMatrixDimensionsException(String message) {
        super(message);
    }

    public DifferentMatrixDimensionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DifferentMatrixDimensionsException(Throwable cause) {
        super(cause);
    }

    public DifferentMatrixDimensionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
