package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) throws InvalidPhoneNumberFormatException {

        PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];
      for(int n = 0; n < phoneNumbers.length;  n++){
    phoneNumbers[n]=createRandomPhoneNumber();
}
       return phoneNumbers ;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = RandomNumberFactory.createInteger(111,111);
        int centralOfficeCode = RandomNumberFactory.createInteger(111,111);
        int phoneLineCode = RandomNumberFactory.createInteger(1111,1111);

        return createPhoneNumberSafely(areaCode,centralOfficeCode, phoneLineCode);
    }




    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {


        String number = "";
        if(String.valueOf(areaCode).length() == 3 && String.valueOf(centralOfficeCode).length() == 3 && String.valueOf(phoneLineCode).length() == 4){
            number =String.format("(%03d)-%03d-%04d", areaCode, centralOfficeCode, phoneLineCode);
        } try {
            return createPhoneNumber(number);

        } catch (InvalidPhoneNumberFormatException e) {
            logger.warning(areaCode + "-" + centralOfficeCode + "-" + phoneLineCode + "-" + " is not a valid phone number ");
            return null;
        }


    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.info("Attempting to create a new phoneNumber with a value" + phoneNumberString);
        return new PhoneNumber(phoneNumberString);
    }



}
