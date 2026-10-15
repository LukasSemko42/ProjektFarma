package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Farma extends WinPane {
    private final int PocetZahonov;
    private int[] zahony;

    public Farma(int pocetZahonov){
        this.PocetZahonov=pocetZahonov;
        this.zahony=new int[pocetZahonov];
        this.setWidth(500);
        this.setHeight(300);
        this.setBackgroundColor(new Color(255, 211, 155));
        drawBorderLines(pocetZahonov);
    }

    public int getPocetZahonov(){
        return PocetZahonov;
    }

    public void drawBorderLines(int pocetZahonov){
        Turtle t = new Turtle();
        this.add(t);
        t.setPenWidth(2);
        int x=this.getWidth()/pocetZahonov;
        for (int i = 0; i < pocetZahonov; i++) {
            t.setPosition(x,0);
            t.setDirection(180);
            t.step(this.getHeight());
            x+=this.getWidth()/pocetZahonov;
        }
        this.remove(t);
    }

    public void pridajKvietok(int x, int y){
        Turtle t = new Turtle();
        this.add(t);
        t.setPosition(x,y);
        t.setFillColor(Color.YELLOW);
        t.dot(15);
        this.remove(t);
    }

    protected void onMouseClicked(int x, int y, MouseEvent detail){
        if (detail.getButton()==MouseEvent.BUTTON1){
            this.pridajKvietok(x,y);
            this.addFlowerCount(x);
        }
        if (detail.getButton()==MouseEvent.BUTTON3){
            System.out.println("Počet kvetov v záhone: "+vZahone(x));
        }
        if (detail.getButton()==MouseEvent.BUTTON2){
            System.out.println("Počet kvetov celkovo: "+pocetKvetov());
        }

    }

    public void addFlowerCount(int x){
        int widthOfOne=this.getWidth()/getPocetZahonov();
        for (int i = 0; i < getPocetZahonov(); i++) {
            if (x<=widthOfOne){
                zahony[i]+=1;
                break;
            }
            widthOfOne+=this.getWidth()/getPocetZahonov();
        }
    }

    public int vZahone(int x){
        int widthOfOne=this.getWidth()/getPocetZahonov();
        for (int i = 0; i < getPocetZahonov(); i++) {
            if (x<=widthOfOne){
                return zahony[i];
            }
            widthOfOne+=this.getWidth()/getPocetZahonov();
        }
        return 0;
    }

    public int pocetKvetov(){
        int count=0;
        for (int x : zahony){
            count+=x;
        }
        return count;
    }

    public int sViacAko(int s){
        int pocet=0;
        for (int x:zahony){
            if (x>s){
                pocet++;
            }
        }
        return pocet;
    }

    public boolean vsadeNieco(){
        for (int x:zahony){
            if(x==0){
                return false;
            }
        }
        return true;
    }

    public int najZahon(){
        int indexMax=0;
        int max=0;
        for (int x:zahony){
            if (x>max){
                max=x;
                indexMax=zahony[x];
            }
        }
        return indexMax;
    }
}