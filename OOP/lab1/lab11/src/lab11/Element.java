package lab11;

public class Element {
	String nameF;
	String nameI;
	String nameO;
	String number;
	
	// Элементы, которые используются для премещения по списку
	Element next;			// Следующий элемент списка
	Element prev;			// Предыдущий элемент списка
	
	public Element(String nameF, String nameI, String nameO, String number) { // конструктор, который будет новый элемент списка, задавая изначальные значения полям класса
		//Указатель this — это указатель на адрес объекта класса, при этом 
		//он является скрытым первым параметром любого метода класса 
		//(кроме статических методов), а типом указателя выступает имя класса.
		
		this.nameF = nameF;
		this.nameI = nameI;
		this.nameO = nameO;
		this.number = number;
	}
}
