/**revenue.. The revenue of all IPL teams are classified into the following: 1. Media rights 2.Sponsorship 3. Ticket sales 4. Stall rental 
5. Prize money Write a program to get all the revenues based on a category mentioned above and the total amount earned. Prompt the user to 
know whether they want to continue to add revenue or not and finally generate a report to display top-earning categories and the total amount
earned as shown in the sample input and output. Since the categories are stored in sorted order so we use TreeSet<Revenue> to store all the Revenue 
object. The template for the Revenue class contains the method compareTo() to perform the comparison between two revenue objects and return an integer 
value. By default,the iterator in tree set class returns the values in ascending order and for this requirement, we can use*/



import java.util.*;

class Revenue implements Comparable<Revenue> {
  String category;
  int revenue;

  public Revenue(String category, int revenue) {
    this.category = category;
    this.revenue = revenue;
  }

  @Override
  public int compareTo(Revenue o) {
    return Integer.compare(o.revenue, this.revenue); // descending order
  }
}


//main class

public class IPLRevenue {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TreeSet<Revenue> revenueList = new TreeSet<>();

    boolean continueInput = true;
    while (continueInput) {
      System.out.println("Enter category (Media rights, Sponsorship, Ticket sales, Stall rental, Prize money): ");
      String category = scanner.nextLine();

      System.out.println("Enter revenue for " + category + ": ");
      int revenue = scanner.nextInt();
      scanner.nextLine();

      revenueList.add(new Revenue(category, revenue));

      System.out.println("Do you want to add revenue for another category (y/n)? ");
      String choice = scanner.nextLine();
      if (choice.equalsIgnoreCase("n")) {
        continueInput = false;
      }
    }

    System.out.println("\nHere's the summarized revenue report:");
    System.out.println("Category \t Revenue");
    for (Revenue revenue : revenueList) {
      System.out.println(revenue.category + "\t\t" + revenue.revenue);
    }

    int totalRevenue = 0;
    for (Revenue revenue : revenueList) {
      totalRevenue += revenue.revenue;
    }
    System.out.println("\nTotal revenue: " + totalRevenue);
  }
}
