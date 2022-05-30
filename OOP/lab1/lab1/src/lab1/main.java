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

package lab1;

import java.util.Scanner;

public class main {
	public static void main(String agrs[]) {
		System.out.println("Из Цельсия в Фаренгейты.");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите диапозон значений.");
		System.out.print("Введите крайне левое значение: ");
		int left = sc.nextInt();
		System.out.print("\nВведите крайне правое значение: ");
		int right = sc.nextInt();
		
		System.out.println("Выберите цикл.");
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
