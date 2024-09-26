package com.vin.javaIO.nio2;

import java.io.*;

class ImportantBook implements Serializable{
    private String author;
    private String isbn;
    private int authorAge; // effectively 'transient'
    private static final long serialVersionUID = 1234567L;

    // The following ObjectStreamField[] states what fields are to be serialised.
    // Any field left out is essentially 'transient'.
    // Thus, 'authorAge' is not serialised as it is not listed.
    private static final ObjectStreamField[] fieldsToSerilise = {
            new ObjectStreamField("author", String.class),
            new ObjectStreamField("isbn", String.class)
    };

    public ImportantBook(String author, String isbn, int authorAge) {
        this.author = author;
        this.isbn = isbn;
        this.authorAge = authorAge;
    }

    @Override
    public String toString(){
        return author +" ; "+ isbn + " ; "+ authorAge;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException{
        ObjectOutputStream.PutField fields = oos.putFields();
        // if we were concerned with security, we could encrpyt the data first...
        fields.put("author", author);
        fields.put("isbn", isbn);
        oos.writeFields();
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        ObjectInputStream.GetField fields =  ois.readFields();
        // if 'author' has no value, 'null' will be used
        // if we had encrpyted the data first, now we would decrypt it...
        author = (String) fields.get("author", null);
        isbn = (String) fields.get("isbn", null);
    }
}
public class CustomSerialisation {
    public static void main(String[] args) {
        try(var b = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("importantBoom.ser")))){
            ImportantBook ib = new ImportantBook("Joe Bloggs", "111-2-333-55555-1", 35);
            System.out.println("Befor: "+ ib);
            b.writeObject(ib);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try(var b = new ObjectInputStream(new BufferedInputStream(new FileInputStream("importantBoom.ser")))){
            ImportantBook nb = (ImportantBook) b.readObject();
            System.out.println("AFTER: "+ nb);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
