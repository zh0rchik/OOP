/* @Lab1.java 1.82 02/02/2022
 *
 * Копирайт (c) 1993-1996 Sun Microsystems, Inc. Все права защищены.
 *
 * Это программное обеспечение является конфиденциальной и закрытой информацией Sun
 * Microsystems, Inc. («Конфиденциальная информация»). Вы не должены
 * раскрывать такую Конфиденциальную информацию и использовать ее только в
 * соответствии с условиями лицензионного соглашения, в которых вы состоите
 * с Sun.
 *
 * SUN НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО НЕ
 * ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ ОПРЕДЕЛЁННОМУ
 * НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ ДАННОЙ СПЕЦИФИКАЦИИ
 * ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ
 * ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ,
 * АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 /
/*
 * Name class main
 * 
 * Version: 2021-12 (4.22.0)
 * 
 * Зюзин Георгий
 */

//Вариант 8

package lab2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Введите N: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.print("[0]do while или [1]while: ");
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
