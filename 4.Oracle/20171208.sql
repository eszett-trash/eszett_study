create user test IDENTIFIED by java;
drop user test CASCADE;


http://tibang.tistory.com/entry/����Ŭ-����-���

1)���̺� �����̽� ����

CREATE tablespace ���̺� �����̽���
DATAFILE '���' SIZE ������

2)����� ���� ����

CREATE USER ����� ID identified by ��й�ȣ
DEFAULT TABLESPACE ���̺����̽���
QUOTA UNLIMITED ON ���̺� �����̽���;


--���� ���� hw / ces
create user hw identified by ces;

--���� ���Ѻο�
grant �R�� to hw;
