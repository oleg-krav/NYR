package game; 
// ����������� ����������� ��������� 

import javax.swing.*; // ������ � �������

// ������� ����� ���� 
public class game { 
	// ������� �����, ������� ��������� ����
	public static void main(String[] args) { 
		
		// ����� ����������� ���� ��� ����� ��������� ����
		String rez = JOptionPane.showInputDialog(null, "������� ��������� ���� �� 1 �� 7:", "��������� ����", 1);
		
		// ��������� ���������� ������ � ���������� ������ ����
		int slogn = Integer.parseInt(rez)/*.charAt(0) - '0'*/;
		
		// ��������, ��� ������� ����� �� 1 �� 7
		if ((slogn >= 1)&&(slogn <= 7)){
			// �������� ����, � ������� ��������� ������� ����
			okno window = new okno(slogn);
		} 
	} 
}























// 01. �������� ������� �����, �����.
// 02. ������� ������������ ����� ����� �������
// 03. ������� ������������ ������� �� ��������� � �����������
// 04. ��������� ������� �� ���������� 1440�1980
// 05. ��������� �������� ������� ��������
// 06. ��������� ������������ ���������� �������� �� 9
// 07. �������� ������� ���������� ��������� ��������
// 08. ������� �������� ������� �� ���� ������� (2 ������) � �� 30 �������� (2 ������)
// 09. ������� ���������� ��������� ��������
// 10. ������� ���������� �������� ������
