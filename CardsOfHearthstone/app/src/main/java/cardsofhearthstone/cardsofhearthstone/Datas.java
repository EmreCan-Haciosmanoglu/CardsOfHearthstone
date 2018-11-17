package cardsofhearthstone.cardsofhearthstone;

import java.util.ArrayList;

public class Datas {
    private int imageId;


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



    public Datas(int imageId, String text1, String text2) {
        this.imageId = imageId;

    }
    public Datas(){

    }
    public static ArrayList<Datas> getData(){
        ArrayList<Datas> dataList=new ArrayList<Datas>();
        int[] images={
                R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
                R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,
                R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,
                R.drawable.a19,R.drawable.a20
        };

        for (int i=0;i<20;i++){
            Datas temp=new Datas();
            temp.setImageId(images[i]);
            dataList.add(temp);
        }
        return dataList;
    }
}
