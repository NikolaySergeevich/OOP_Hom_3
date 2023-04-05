import java.util.Iterator;

public class MyLinkedList implements Iterable<MyLinkedList.Ysel> {
    private Ysel head;
    private  int count;

    public MyLinkedList() {
        this.head = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        Ysel time = head;
        StringBuilder res = new StringBuilder();
        if (time != null){
            res.append(String.format("%d\n",time.number));
        }
        while (time.next != null){
            res.append(String.format("%d\n",time.next.number));
            time = time.next;
        }
        return res.toString();
    }

    /**
     * Метод добавления. Тут хитро продумана реализация добавления в конец списка и добавления ссылки на след. элем.
     *
     * @param number
     */
    public void  addNum(int number){
        Ysel newYsel = new Ysel((number));
        Ysel courentyPos = head;
        //когда мы создаём лист, то согласно конструктора мы задаём голове(head) значение null. А когда мы первый раз
        //будем пприменять функцию addnum, то сработают следующие две строки. А когда будем вызывать этот метод ещё,
        //то head уже не пустой, а будет содержать в себе узел(с пустой ссылкой на след. элем.(согласно конструктора)).
        if (head == null) {
            head = newYsel;
        }else {
            while (courentyPos.next != null){
                courentyPos = courentyPos.next;//В этой строке и присваивается ссылка на след. элем.
            }//А когда цикл дошёл до последнего элемента, то он как бы говорит своим условием, что следующего
            //элемента нет. И тогда на следующей строке мы создаём новый узел с пустой ссылко согласно контруктору
            //и пихаем его в конец списка.
            courentyPos.next = newYsel;
        }
        count ++;

    }

    /**
     * Метод удаления узла по числу, которое принимает метод.
     * @param num
     */
     public void removeNum(int num){
         Ysel courentyYs = head;//для прохождения по листу, что бы знал на каком узле в конкретный момент нахожусь.
         //этот узел будет удаляться.
         Ysel previousYs = null;//для того, что бы могли передать ссылку этого узла на узел, который станет следующим
         //после удаления необходимого узла. Нужен для всех случаев, кроме тех, когда будет удаляться первый элемент.

         while (courentyYs.next != null){
             if (courentyYs.number == num){//теперь нужно произвести замены ссылками перед удаление узла.Два случая:
                 //когда элемент, который удаляем стоит первым в списке(это блок if) и когда не первым(блок else)
                 if (courentyYs == head){
                     head = courentyYs.next;//говорим, что голова теперь второй элемент. А первый мы удалим вот-вот))
                 }else {
                     previousYs.next = courentyYs.next;//тут мы говорим, что ссылка с того элемента, который мы удаляем,
                                                    //теперь переходит на предыдущий элемент. То есть предыдущий элемент
                     // будет теперь знать, что следующим будет не тот, который мы вот-вот удали, а последующий.
                 }
             }


             previousYs = courentyYs;
             courentyYs = courentyYs.next;
         }
         count --;

     }

     public String size(){
         return String.format("Длина вашего списка = %d", getCount());
     }

    @Override
    public Iterator<Ysel> iterator() {
        return new Iterator<Ysel>() {
            int flag = 0;
            Ysel count = head;
            @Override
            public boolean hasNext() {
                if (flag < getCount()) return  true;
                return false;
            }

            @Override
            public Ysel next() {
                if (flag == 0){
                    flag ++;
                    return count;
                }
                flag ++;
                count = count.next;
                return count;
            }
        };
    }


    /**
     * Класс узел. Вложенный класс. Он реализует узел. Этими узлами будет заполняться лист
     */
    public class Ysel{
        public int number;
        public Ysel next;

        /**
         * конструктор создаёт узел(число, но без ссылки на след.элемент.)
         * @param number
         */
        public Ysel(int number) {
            this.number = number;
            next = null;
        }

        /**
         * Нужен при выводе с помощью foreach
         * @return
         */
        @Override
        public String toString() {
            return String.format("%d",this.number);
        }
    }

}
