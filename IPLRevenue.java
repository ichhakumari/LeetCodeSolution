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
