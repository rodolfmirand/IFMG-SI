package org.example.ex9;

public class Main {
    public static void main(String[] args) {
        CatalogTree<Integer> catalog = new CatalogTree<>();

        catalog.insert(5, "");
        catalog.insert(3, "");
        catalog.insert(4, "");
        catalog.insert(8, "");
        catalog.insert(6, "");
        catalog.insert(9, "");

        catalog.showInOrder();

        catalog.removePreviousFiles(8);

        catalog.showInOrder();
    }
}