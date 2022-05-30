package lab11;

public class MyList {
	Element head;			//������ ������� ������
	Element tail;			// ��������� ������� ������
	
	public MyList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean checkList() {
		return head == null;
	}
	
	//�������, ������� ��������� ������ ������� ������ (������ ���������� �������)
	public void addHead(String nameF, String nameI, String nameO, String number) {
		Element element = new Element(nameF, nameI, nameO, number);
		
		if(this.checkList()) {
			tail = element;
		} else {
			head.prev = element;		//���������� ������
		}
		
		element.next = head;			
		head = element;
	}
	
	
	public void addTail(String nameF, String nameI, String nameO, String number) {
		Element element = new Element(nameF, nameI, nameO, number);
		
		if(this.checkList()) {
			head = element;
		} else {
			tail.next = element;		//��������� �����
		}
		
		element.prev = tail;			
		tail = element;
	}
	
	public void deleteHead() {
		if (head == null) {
			return;
		}
		if(head.next == null) { //���� ��� ��������� ������
			tail = null;		//������ ������ ���.
		} else {
			head.next.prev = null;	//next -> prev  ����� �������, ������ ��� �� ����� � �� ������ ��������� �����
		}
		
		head = head.next;
	}
	
	public void deleteTail() {
		if (head == null) {
			return;
		}
		if(head.next == null) {
			head = null;
		} else {
			tail.prev.next = null;
		}
		
		tail = tail.prev;
	}
	
	public void deleteElementByNameF(String lastName, boolean flag) {
		
		Element search = null;
		if (flag) {
			search = head;
		} else {
			search = tail;
		}

        while (!search.nameF.equals(lastName)) {
        	if (flag) {
    			search = search.next;
    		} else {
    			search = search.prev;
    		}

            if (search == null) {
                return;
            }
        }

        if (search == head) {
            deleteHead();
        } else {
        	if (search.prev == null) {
        		deleteHead();
        	} else {
        		search.prev.next = search.next;
        	}
        }

        if (search == tail) {
            deleteTail();
        } else {
        	if (search.next == null) {
        		deleteTail();
        	} else {
        		search.next.prev = search.prev;
        	}
        }

	}
}
