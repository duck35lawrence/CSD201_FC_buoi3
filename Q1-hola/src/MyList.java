/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xOwner, int xPrice, int xColor) {
      if(xOwner.charAt(0)=='A'){
          return;
      }
      Pen newPen = new Pen(xOwner, xPrice, xColor);
      Node newNode = new Node(newPen);
      if (head == null) {
            head = newNode;
            return;
      }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  public void addNodeByIndex(Pen data, int index) {
      Node newNode = new Node(data);  
      if (index < 0) {
            return;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        Node prev = null;
        int currIndex = 0;

        while (temp != null && currIndex < index) {
            prev = temp;
            temp = temp.next;
            currIndex++;
        }

        newNode.next = temp;
        prev.next = newNode;
    }
  
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Pen x, y;
     x = new Pen("X",1,2);
     y = new Pen("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      addNodeByIndex(y, 0);
      // 0  1  2 ...
      addNodeByIndex(x, 1);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node tmp = head;
    Node prev = null;
    while(tmp != null){
        if(tmp.info.color < 6){
            break;
        }
        prev = tmp;
        tmp = tmp.next;
    }
    if(tmp != null){
        if(tmp == head){
            head = head.next;
            if(head == null){
                tail = null;
            }
        }else{
            prev.next = tmp.next;
        }
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node currNode = head;
    Node cmpNode = currNode.next;
    for(int i = 1; i <= 4; i++){
        for(int j = i + 1; j <= 5; j++){
            if(currNode.info.color > cmpNode.info.color){
                Pen penTmp = currNode.info;
                currNode.info = cmpNode.info;
                cmpNode.info = penTmp;
            }
            cmpNode = cmpNode.next;
        }
        currNode = currNode.next;
        cmpNode = currNode.next;
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

