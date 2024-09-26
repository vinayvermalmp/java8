package com.vin.javaIO.nio2;

import java.io.*;

/*
• Serialisation is the process of converting an in-memory Java object and saving it to a file (byte stream).
• De-serialisation is the opposite: it is the process of converting from a file to a Java object.
• To inform Java that your class is serialisable, you implement the marker interface Serializable.
A “marker interface” is an interface that has no methods.
• Apply Serializable to data oriented classes as their state is not short-lived.

As we are serialising objects, instance variables (and not static variables) are serialised.
• private static final long serialVersionUID = 1L;
although static, it is serialised as part of serialisation.
used to synchronise the class definition with the stored data e.g. what if a new field was inserted into the
class definition and you were attempting to deserialise a file that was serialised with the old
class definition i.e. without that new field? This results in an InvalidClassException during deserialisation.

• Serialisation requires the use of two classes:
 ObjectOutputStream
 ObjectInputStream
• These classes are considered high-level classes and will wrap lower level classes such as FileOutputStream and
FileInputStream.
• Typically, we will start with a file stream, wrap it in a buffered stream to improve performance and
then wrap the buffered stream with an object stream to access the serialisation/deserialisation methods.

* */
class InfoMedium{
    private String theMedium;

    InfoMedium(){ // IS called when de-serialising as this class IS NOT Serializable
        theMedium="Unknown";
    }
    public void setMedium(String aMedium){
        theMedium = aMedium;
    }
    public String getMedium(){
        return theMedium;
    }
}
class Book extends InfoMedium implements Serializable{
    private BookMarker p = new BookMarker();
    private String theAuthor; // if 'transient', then 'null' is value

    Book(){ // IS NOT called when de-serialising as this class IS Serializable
        theAuthor = "Unknown";
    }
    public void setAuthor(String aAuthor){
        theAuthor = aAuthor;
    }
    public String getAuthor(){
        return theAuthor;
    }
    @Override
    public String toString() {
        return getMedium() + "; " + getAuthor() ;
    }
}
class BookMarker implements Serializable{
    private Image I = new Image();
    //    private transient Image l = new Image(); // fix #2, mark as 'transient'
}
//class Image {}// generates a java.io.NotSerializableException when serialising
class Image implements Serializable{ } // fix #1

//class Image{} // fix #2, see BookMarker class

public class Serialisation {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        // Serialise a Book
        // creates file here: C:\Users\skennedy\Documents\NetbeansProjects\Udemy
        try(var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("book.ser")))){
            Book b = new Book();
            b.setMedium("Print");
            b.setAuthor("Sean Kennedy");
            System.out.println("BEFORE: "+b);
            out.writeObject(b);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        // Deserialise a Book
        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("book.ser")))){
            Book b = (Book) in.readObject();
            System.out.println("AFTER: " + b);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
