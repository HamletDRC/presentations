package backnotout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Example {

    void getAddress(int addressID, Person p) {
        Address a = lookupAddress(addressID);
        p.setAddress(a);
    }

    Address getAddress(int addressID) {
        return lookupAddress(addressID);
    }

    static void getEvenNumbers(int bottom, int top, List<Integer> target) {
        for (int x = bottom; x <= top; x++) {
            if (x % 2 == 0) {
                target.add(x);
            }
        }
    }

    static List<Integer> getEvenNumbers(int bottom, int top) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int x = bottom; x <= top; x++) {
            if (x % 2 == 0) {
                result.add(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> target = new ArrayList<>();
        getEvenNumbers(10, 20, target);
        System.out.println("target = " + target);

        target = getEvenNumbers(10, 20);
        System.out.println("target = " + target);

    }

    class Widget {
        JPanel userPanel;

        Widget() {
            createUserPanel();
        }

        void createUserPanel() {
            userPanel = new JPanel();
            userPanel.add(new JLabel("First Name:"));
            userPanel.add(new JTextField());
            userPanel.add(new JLabel("Last Name:"));
            userPanel.add(new JTextField());
        }
    }

    class Widget2 {
        final JPanel userPanel;

        public Widget2() {
            this.userPanel = createUserPanel();
        }

        JPanel createUserPanel() {
            JPanel userPanel = new JPanel();
            userPanel.add(new JLabel("First Name:"));
            userPanel.add(new JTextField());
            userPanel.add(new JLabel("Last Name:"));
            userPanel.add(new JTextField());
            return userPanel;
        }
    }

    static class Person {
        Address address;

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    static class Address {
    }
    private Address lookupAddress(int addressID) {
        return null;
    }
}
