package com.vin.javaIO.nio2;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;


// Traversing a Directory tree   :: ->> • Given a directory, how do we list all the .java files in that
//directory tree i.e. include the sub-directories?

/*• Prior to the Stream API, this was accomplished with
DirectoryStream and FileVisitor. Note: DirectoryStream is not
a Stream class!
• The Stream API method is far superior and requires much
less code.

Stream<Path> find(Path start, int maxDepth,
//                      BiPredicate<Path, BasicFileAttributes> matcher,
//                      FileVisitOption… options) // FOLLOW_LINKS
*
* */
public class SearchDirectory {

    public static void main(String[] args) {
        //Path startPath = Paths.get("./src/com/vin/javaIO/nio2");
        Path startPath = Paths.get("./src/com/vin/javaIO");
        try(var streamPaths = Files.find(startPath, 10,
                (path, attr) -> attr.isRegularFile()
                        && path.toString().endsWith(".java"))){
            streamPaths.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
