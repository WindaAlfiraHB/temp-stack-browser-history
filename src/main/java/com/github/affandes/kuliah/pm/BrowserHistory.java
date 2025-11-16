package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    private Stack<String> history = new Stack<>();

    // Tambah website ke history
    public void browse(String website) {
        history.push(website);
        System.out.println("Browsing: " + website);
    }

    // Kembali ke website sebelumnya dan hapus history terbaru
    public void back() {
        if (history.size() <= 1) {
            System.out.println("Tidak bisa kembali! History kosong atau hanya ada satu item.");
            return;
        }

        String removed = history.pop();
        System.out.println("Back dari: " + removed);
        System.out.println("Sekarang berada di: " + history.peek());
    }

    // Menampilkan semua history (paling baru → paling lama)
    public void view() {
        if (history.isEmpty()) {
            System.out.println("History masih kosong!");
            return;
        }

        System.out.println("\n=== HISTORY (Terbaru ke Terlama) ===");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
        System.out.println("====================================\n");
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("=== MENU BROWSER ===");
            System.out.println("1. Browse website");
            System.out.println("2. Back");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            input.nextLine(); // agar tidak lompat input

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama website: ");
                    String site = input.nextLine();
                    browser.browse(site);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.view();
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Menu tidak valid!");
            }

            System.out.println();
        }
    }
}