/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabookstore;

import java.util.Scanner;


 
public class LamaBookstore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez saisir la quantité : ");
        int qt = sc.nextInt();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir le prix de l'article (DT) : ");
        double p = scanner.nextInt();
        
        
        System.out.print("le prix totale est  "+Utility.CalculateTotalPrice(qt, p)+"  (DT)");
    }

}
