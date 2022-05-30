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

package lab1;

import java.util.Scanner;

public class main {
	public static void main(String agrs[]) {
		System.out.println("�� ������� � ����������.");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������� �������� ��������.");
		System.out.print("������� ������ ����� ��������: ");
		int left = sc.nextInt();
		System.out.print("\n������� ������ ������ ��������: ");
		int right = sc.nextInt();
		
		System.out.println("�������� ����.");
		System.out.println("[0] do while");
		System.out.println("[1] while");
		int flag = sc.nextInt();
		
		if(flag == 1) {
			while(left <= right) {
				System.out.print(left);
				float f = (float) (1.8 * left + 32);
				System.out.println(" " + f);
				left++;
			}
		} else {
			do {
				if(left > right) {
					break;
				}
				System.out.print(left);
				float f = (float) (1.8 * left + 32);
				System.out.println(" " + f);
				left++;
			} while(left <= right);
		}
		
		sc.close();
	}
}
