/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author BMMil
 */
public class UserIOImpl implements UserIO {
    
    boolean validInput = false;
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public double readDouble(String prompt) {
        validInput = false;
        double num = 0;
        while (validInput == false) {
            print(prompt);
            String doubleString = sc.nextLine();
            try {
                num = Double.parseDouble(doubleString);
                validInput = true;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }

    @Override
    public double readDouble(String prompt, boolean acceptsNullInput) {
        validInput = false;
        double num = 0;
        while (validInput == false) {
            print(prompt);
            String doubleString = sc.nextLine();
            try {
                num = Double.parseDouble(doubleString);
                validInput = true;

            } catch (NumberFormatException e) {
                if (acceptsNullInput && doubleString.equals("")) {
                    return 0;
                }
                print("Please enter a valid number");
            }
        }
        return num;
    }

    @Override
    public double readDoubleBetween(String prompt, double min, double max) {
        validInput = false;
        double num = 0;

        while (!validInput) {
            print(prompt);
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            try {
                num = Double.parseDouble(s);
                validInput = num >= min && num <= max;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }

    
    @Override
    public float readFloat(String prompt) {
        validInput = false;
        float num = 0;
        while (validInput == false) {
            print(prompt);
            String doubleFloat = sc.nextLine();
            try {
                num = Float.parseFloat(doubleFloat);
                validInput = true;

            } catch (NumberFormatException e) {
                print("Please enter a valid float");
            }
        }
        return num;
    }

    @Override
    public float readFloatBetween(String prompt, float min, float max) {

        validInput = false;
        float num = 0;

        while (!validInput) {
            print(prompt);
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            try {
                num = Float.parseFloat(s);
                validInput = num >= min && num <= max;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }


    @Override
    public int readInt(String prompt) {
        validInput = false;
        int num = 0;
        while (validInput == false) {
            print(prompt);
            String intString = sc.nextLine();
            try {
                num = Integer.parseInt(intString);
                validInput = true;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }

    @Override
    public int readIntBetween(String prompt, int min, int max) {

        validInput = false;
        int num = 0;

        while (!validInput) {
            print(prompt);
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            try {
                num = Integer.parseInt(s);
                validInput = num >= min && num <= max;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }

   
    @Override
    public long readLong(String prompt) {
        validInput = false;
        long num = 0;
        while (validInput == false) {
            print(prompt);
            String longString = sc.nextLine();
            try {
                num = Long.parseLong(longString);
                validInput = true;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }

    @Override
    public long readLongBetween(String prompt, long min, long max) {

        validInput = false;
        long num = 0;

        while (!validInput) {
            print(prompt);
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            try {
                num = Long.parseLong(s);
                validInput = num >= min && num <= max;

            } catch (NumberFormatException e) {
                print("Please enter a valid number");
            }
        }
        return num;
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt) {
        boolean isValid = false;
        BigDecimal result = null;
        
        while (!isValid) {
            print(prompt);
            String userInput = sc.nextLine();
            
            try {
                BigDecimal str = new BigDecimal(userInput);
                result = str.setScale(2, RoundingMode.HALF_UP);
                isValid = result.compareTo(BigDecimal.ZERO) >= 0;
            } catch (NumberFormatException ex) {
                print("Invalid Input. Please try again.");
            }
        }
        return result;    
}

  
    
    @Override
    public void println(String string) {
        System.out.println(string);
        
    }
    
    @Override
    public LocalDate readLocalDate(String prompt, String format) {
        boolean isValid = false;
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(format);
        LocalDate result = null;
        
        while (!isValid) {
            print(prompt + " (" + format.toUpperCase() + "):\t");
            String userInput = sc.nextLine();
            
            try {
                result = LocalDate.parse(userInput, dtFormat);
                isValid = true;
            } catch (DateTimeException ex) {
                println("Invalid Input. Please check to see if your input is "
                        + "in the correct format (" + format.toUpperCase() + ")");
            }
        }
        return result;
    }
    
    
    
}
