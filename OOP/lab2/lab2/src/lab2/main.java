/* @Lab1.java 1.82 02/02/2022
 *
 * �������� (c) 1993-1996 Sun Microsystems, Inc. ��� ����� ��������.
 *
 * ��� ����������� ����������� �������� ���������������� � �������� ����������� Sun
 * Microsystems, Inc. (����������������� �����������). �� �� �������
 * ���������� ����� ���������������� ���������� � ������������ �� ������ �
 * ������������ � ��������� ������������� ����������, � ������� �� ��������
 * � Sun.
 *
 * SUN �� ���� ������� ��������, ����� ��� ��������� (������� - �� ��
 * ������������� ��� - �������� �������������), ������������ ������˨�����
 * ���������� ��� ����������� �������, ��� ���������� ������ ������������
 * �������� ��� �����-���� ����� ��� ��� ����� ������������� ��� ����������
 * ������ ����������� �� ����� �������� �����-���� �������� ������� �������,
 * ��������� ����, ������������ ����� ��� ���� ����.
 /
/*
 * Name class main
 * 
 * Version: 2021-12 (4.22.0)
 * 
 * ����� �������
 */

//������� 8

package lab2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("������� N: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.print("[0]do while ��� [1]while: ");
		int flag = sc.nextInt();
		
		if (flag == 1) {
			int i = 0;
			while(i < (2*n)) {
				if(i < n) {
					int k = 0;
					while(k < i) {
						System.out.print("  ");
						k++;
					}
					int j = n;
					while (j > i) {
						System.out.print(j + " ");
						j--;
					}
					System.out.print("\n");
				} else if(i > n) {
					int k = 0;
					while(k < n-1) {
						System.out.print("  ");
						k++;
					}
					int j = 2*n - i;
					while (j <= n) {
						System.out.print(j + " ");
						j++;
					}
					System.out.print("\n");
				}
				i++;
			}
		
		} else if(flag == 0) {
			int i = 0;
			do {
				if(i < n) {
					int k = 0;
					do {
						if(i == 0) {
							break;
						}
						System.out.print("  ");
						k++;
					} while(k < i);
					int j = n;
					do {
						System.out.print(j + " ");
						j--;
					} while (j > i);
					System.out.print("\n");
				} else if(i > n) {
					int k = 0;
					do {
						System.out.print("  ");
						k++;
					} while(k < n-1);
					int j = 2*n - i;
					do {
						System.out.print(j + " ");
						j++;
					} while (j <= n);
					System.out.print("\n");
				}
				i++;
			} while (i < (2*n));
		}
		
		sc.close();
	}

}
