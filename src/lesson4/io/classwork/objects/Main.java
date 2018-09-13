package lesson4.io.classwork.objects;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(4.0, 2.0);
        Point p3 = new Point(6.0, 8.0);
        Line line1 = new Line(p1, p2, 1);
        Line line2 = new Line(p2, p3, 2);
        String fileName = "/Users/Andrey/Documents/Учеба/TempFiles/object.txt";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(line1);
            objectOutputStream.writeObject(line2);
            line1.setPoint1(new Point(11.0, 11.0));
            objectOutputStream.reset();
            objectOutputStream.writeObject(line1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Line> lines = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            for (int i = 0; i < 3; i++) {
                lines.add((Line) objectInputStream.readObject());
            }
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
