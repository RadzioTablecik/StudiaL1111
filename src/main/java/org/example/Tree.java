package org.example;

/**Klasa odpowiadajaca za operacje na drzewie*/
public class Tree<T extends Comparable<T>> {
    private TreeElement<T> root;
    public Tree(){
        root=null;
    }

    /**Finalne usuwanie*/
    public void delete(T key) { root = deleteRec(root, key); }

    /**Usuwanie na zasadach drzewa binarnego*/
    private TreeElement<T> deleteRec(TreeElement<T> w, T key)
    {
        //puste drzewo
        if (w == null)
            return w;

        //idz w dol
        if (key.compareTo(w.key) < 0)
            w.left = deleteRec(w.left, key);
        else if (key.compareTo(w.key) > 0)
            w.right = deleteRec(w.right, key);


        else {
            // 1 child albo 0
            if (w.left == null)
                return w.right;
            else if (w.right == null)
                return w.left;

            // 2 child ustaw mniejszy na prawo
            w.key = minValue(w.right);

            //skasuj
            w.right = deleteRec(w.right, w.key);
        }

        return w;
    }

    public T minValue(TreeElement<T> w)
    {
        T minv = w.key;
        while (w.left != null)
        {
            minv = w.left.key;
            w = w.left;
        }
        return minv;
    }
    /**Dodawanie na zasadach drzewa binarnego*/
    private TreeElement<T> ins (T elem, TreeElement<T> w){
        if(w==null)
            return new TreeElement<>(elem);
        if(elem.compareTo(w.key)<0)
            w.left = ins(elem,w.left);
        if(elem.compareTo(w.key)>0)
            w.right = ins(elem,w.right);
        return w;
    }
    /**Finalne dodawanie*/
    public void insert(T element){
        root = ins(element,root);
    }

    /**Wyszukiwanie na zasadach drzewa binarnego*/
    private boolean isElem(T elem, TreeElement<T> base) {
        if( base==null ) return false;
        if( elem.compareTo(base.key)==0 ) return true;
        if( elem.compareTo(base.key)<0)
            return isElem(elem, base.left);
        else
            return isElem(elem, base.right);
    }
    /**Finalne wyszukanie*/
    public boolean isElement(T elem){
        return isElem(elem, root);
    }

    /**Budowa wyswietlenia drzewa binarnego*/
    private String toS(TreeElement<T> w) {
        if( w!=null )
            return "("+w.key +":"+toS(w.left)+":"+toS(w.right)+")";
        return "()";
    }
    /**Finalne wyswietlenie*/
    public String toString() {
        return toS(root);
    }

}

