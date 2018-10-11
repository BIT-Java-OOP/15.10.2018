package converter;

import exception.NotWorkingConverterException;

public class Converter<T> {
    private Class clazz;

    public Converter(Class clazz) {
        this.clazz = clazz;
    }

    public T getConvertedData(Object data) {
        return yourMethod(data);
    }

    private T yourMethod(Object data) {
        try {
            T convertedObject = (T) clazz.getConstructor().newInstance();

            /*
            write as small amount of code as its possible
            to make tests green, modify only this class,
            Good Luck and Have Fun
             */

            return convertedObject;
        } catch (Exception e) {
            System.out.println("Doesnt work, try again");
            e.printStackTrace();
            throw new NotWorkingConverterException();
        }
    }
}
