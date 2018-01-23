package BusinessTier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class DecryptImage {
	public String texted(String img){
		int count=0;
		String text = null;
		try {
			BufferedImage i=ImageIO.read(new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\ImagesRetrived\\"+img));
			int []x=new int[3];
			int []x1=new int[3];
			int []x2=new int[3];
			int []x3=new int[3];
			int []x4=new int[3];
			int []x5=new int[3];
			int []x6=new int[3];
	        int k123=0;
			char qw[] = new char[1000000];
			 int wd=i.getWidth();
			 wd=wd-1;
			 int h=0;
			 int w=0;
			for (int j = 0; j < 1000000;j++) {
				
				//pix 1
				int a[]=i.getData().getPixel(w,h,x);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
				//pix2
				int a1[]=i.getData().getPixel(w,h,x1);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
				
				//pix 3
				int a2[]=i.getData().getPixel(w,h,x2);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
			    
				//pix 4
				int a3[]=i.getData().getPixel(w,h,x3);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
				
				//pix 5
				int a4[]=i.getData().getPixel(w,h,x4);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
				
				//pix 6
				int a5[]=i.getData().getPixel(w,h,x5);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
				
				//pix 7
				int a6[]=i.getData().getPixel(w,h,x6);
				if(w==wd){
					w=0;
					h++;
				}
				else{
					w++;
				}
				
				
				
				
	            byte b=(byte) (a[2] << 7);
				 b=(byte) (b>>>7);
				 b=(byte) Math.abs(b);
			    byte b1=(byte) (a1[2] << 7);
			     b1=(byte) (b1>>>6);
			     b1=(byte) Math.abs(b1);
			    byte b2=(byte) (a2[2]<<7); 
			    b2=(byte) (b2>>5);
			    b2=(byte) Math.abs(b2);
			     
			    byte b3=(byte) (a3[2]<<7);
			    b3=(byte) (b3>>>4);
			    b3=(byte) Math.abs(b3);
			    byte b4=(byte) (a4[2]<<7);
			    b4=(byte) (b4>>>3);
			    b4=(byte) Math.abs(b4);
			    byte b5=(byte) (a5[2]<<7);
			    b5=(byte) (b5>>>2);
			    b5=(byte) Math.abs(b5);
	            
			    byte b6=(byte) (a6[2]<<7);
			    b6=(byte) (b6>>>1);
			    b6=(byte) Math.abs(b6);
	            byte b7=0;
			    byte qwt=(byte) (b7|b6|b5|b4|b3|b2|b1|b);
			    qw[j]=(char) qwt;
			    k123=j;
			    if(qwt==36){
			    	count=count+1;
			    	if(count==4){
			    	break;
			    }
			    }else{
			    	count=0;
			    }
			}
			for (int j1 = 0; j1 < k123; j1++) {
				text=text+qw[j1];
			}
			//System.out.println(qw[0]+""+qw[1]+""+qw[2]+""+qw[3]+""+qw[4]+""+qw[5]+""+qw[6]);
			
			
		}
		
		catch (IOException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		String text1=text.substring(4,text.length()-3);
		return text1;
	}
}
