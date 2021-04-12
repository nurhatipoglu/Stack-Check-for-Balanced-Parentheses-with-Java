package Odevler;

import java.util.*;

// geçerli veya geçersiz olduğunu tespit eden java programı.
public class Stack {
    // parantez durumlarının doğru olup olmadığını kontrol eden fonksiyon
    static boolean areBracketsBalanced(String expr) {
        MyStack mystack = new MyStack();
        for (int i = 0; i < expr.length(); i++) {
            //her karakteri kontrol ediyoruz.
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                //operatoru stack e(yığına) ekle.
                mystack.myPush(x);
                continue;
            }
            char check;
            switch (x) {
                case ')':
                    check = mystack.myPop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = mystack.myPop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = mystack.myPop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        // stağın boş olup olmadığını kontrol edelim. Boş ise true döner.Böylece stackte hiç eleman kalmaz. Her sey duzgun.
        return (mystack.IsEmpty());
    }

    // Kodu çalıştıralım.
    public static void main(String[] args)
    {
        //String expr = "([{XXX \"(XXX)\" XXX}])";
        //String expr = "([{}])" ;
        //String expr = "([)]";
        String expr = "([{XXX (XXX) XXX}])";
        System.out.println("İfade: "+expr);

        // fonksiyonu çağıralım.
        if (areBracketsBalanced(expr))
            System.out.println("Geçerli");
        else
            System.out.println("Geçersiz");
    }
}
/* Java program to implement basic stack
operations */
class MyStack {
    static final int MAX = 1000;
    int top;//top son elemanı gösterir.
    char a[] = new char[MAX]; // Maximum size of Stack
    MyStack(){
        top = -1;
    }
    boolean IsEmpty(){
        return (top < 0);
    }
    boolean myPush(char x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Taştı");
            return false;
        }
        else {
            //diziyi aşmadıysak yeni elemanı diziye ekliyoruz.
            a[++top] = x;
            System.out.println(x + " stack'e eklendi");
            return true;
        }
    }
    char myPop(){
        if (top < 0) {
            System.out.println("Stack Taştı");
            return 0;
        }
        else {
            //son eleman stackten çıkarılır. Stackteki son eleman geri döndürülür. Son eleman artık sondan bir önceki eleman olmuştur.
            //son gelen ilk çıkar mantığı kullanılır(FILO). top artık sondan bir önceki elemanı gösterir. Çünkü sonuncu eleman pop edildi.
            char x = a[top--];
            System.out.println(x + " stack ten çıkarıldı.");
            return x;
        }
    }
    int peek(){
        if (top < 0) {
            System.out.println("Stack Taştı");
            return 0;
        }
        else {
            char x = a[top];//stackteki son elemanı döndürür.
            return x;
        }
    }
}

