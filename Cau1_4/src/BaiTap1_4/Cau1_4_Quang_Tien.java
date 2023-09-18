package BaiTap1_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cau1_4_Quang_Tien {
    public static int[][] docMaTranKe(String filePath) {
        int[][] maTranKe = null;

        try {
            Scanner scanner = new Scanner(new File(filePath));
            int n = scanner.nextInt();
            maTranKe = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maTranKe[i][j] = scanner.nextInt();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return maTranKe;
    }

    public static boolean kiemTraHopLe(int[][] maTranKe) {
        for (int i = 0; i < maTranKe.length; i++) {
            if (maTranKe[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean kiemTraDoiXung(int[][] maTranKe) {
        for (int i = 0; i < maTranKe.length; i++) {
            for (int j = 0; j < maTranKe[i].length; j++) {
                if (maTranKe[i][j] != maTranKe[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] demBacRa(int[][] maTranKe) {
        int n = maTranKe.length;
        int[] bac = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bac[i] += maTranKe[i][j];
            }
        }

        return bac;
    }

    
    public static int[] demBacVao(int[][] maTranKe) {
        int n = maTranKe.length;
        int[] bacVao = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bacVao[i] += maTranKe[j][i];
            }
        }

        return bacVao;
    }

    public static void main(String[] args) {
        int[][] maTranKe = docMaTranKe("input.txt");

        if (kiemTraHopLe(maTranKe)) {
            System.out.println("Đồ thị hợp lệ.");
        } else {
            System.out.println("Đồ thị không hợp lệ.");
            return;
        }
        int[] bacVao = demBacVao(maTranKe);
        int[] bacRa = demBacRa(maTranKe);

        if (kiemTraDoiXung(maTranKe)) {
            System.out.println("Đồ thị đối xứng.");
            System.out.println("Bậc của các đỉnh trong đồ thị:");
        for (int i = 0; i < bacVao.length; i++) {
            System.out.println("Đỉnh " + (i + 1) + ": " + bacRa[i]);
        }
        } else {
            System.out.println("Đồ thị không đối xứng.");
            System.out.println("Bậc vào và bậc ra của các đỉnh trong đồ thị có hướng:");
            for (int i = 0; i < bacVao.length; i++) {
                System.out.println("Đỉnh " + (i + 1) + ": Bậc vào = " + bacVao[i] + ", Bậc ra = " + bacRa[i]);
        }
        }
    }
}
