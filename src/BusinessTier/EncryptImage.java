package BusinessTier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class EncryptImage {

	public String Image(String data,String name){
		
		try {
			int aaaaaa;
			BufferedImage i1=ImageIO.read(new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\UploadedImages\\"+name));	
			File outputFile = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\EncryptedImages\\images1.png");
			 ImageIO.write(i1,"png",outputFile);
			 BufferedImage i2=ImageIO.read(new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\EncryptedImages\\images1.png"));
			int width=i2.getWidth();
			int height=i2.getHeight();
			BufferedImage i=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); 
			
			 for (int y=0; y<height; y++)
			    {
			        for (int x=0; x<width; x++)
			        {
			           aaaaaa=i2.getRGB(x, y);
			           i.setRGB(x, y, aaaaaa);
			            
			        }
			    }
			 int wd=i.getWidth();
			 wd=wd-1;
			 int h=0;
			 int w=0;
			 
			byte z,z11,z22,z33,z44,z55,z66;
			
			String g=data+"$$$$";
		    int t;
		    for (int j = 0; j < g.length(); j++) {
            char as=g.charAt(j);
            t=as;
		    byte pix1= (byte) (t << 7);
			pix1=(byte) (pix1>>>7);
			pix1= (byte) Math.abs(pix1);
			
			byte pix2= (byte) (t << 6);
			pix2=(byte) (pix2>>>7);
			pix2= (byte) Math.abs(pix2);
			
			byte pix3= (byte) (t << 5);
			pix3=(byte) (pix3>>>7);
			pix3= (byte) Math.abs(pix3);
			
			byte pix4= (byte) (t << 4);
			pix4=(byte) (pix4>>>7);
			pix4= (byte) Math.abs(pix4);
			
			byte pix5= (byte) (t << 3);
			pix5=(byte) (pix5>>>7);
			pix5= (byte) Math.abs(pix5);
			
			byte pix6= (byte) (t << 2);
			pix6=(byte) (pix6>>>7);
			pix6= (byte) Math.abs(pix6);
			
			byte pix7= (byte) (t << 1);
			pix7=(byte) (pix7>>>7);
			pix7= (byte) Math.abs(pix7);
			
			byte pix8 = 0;
			pix8=(byte) (pix8>>>7);
			pix8= (byte) Math.abs(pix8);
			
			int []x=new int[3];
			int []x1=new int[3];
			int []x2=new int[3];
			int []x3=new int[3];
			int []x4=new int[3];
			int []x5=new int[3];
			int []x6=new int[3];
			int ar123[]=i.getData().getPixel(w,h,x);
			z=(byte) ar123[0];
			int zz=ar123[1];
			int zzz;
			//pixel 1
			//red1
			if(pix1==1){
				if(ar123[2]%2==1){
					 zzz=(byte) ar123[2];
				}
				else{
					zzz=ar123[2]+1;
				}
			}
			else{
				if(ar123[2]%2==1){
					zzz=ar123[2]-1;
				}
				else{
				zzz=(byte) ar123[2];
			}
			}
			//int rgb123 = (z << 16 | zz << 8 | zzz);
			int rgb123 = z;
			  rgb123 = (rgb123 << 8) + zz;
			  rgb123 = (rgb123 << 8) + zzz;
			  if(w==wd){
				i.setRGB(w, h, rgb123);
				w=0;
				h++;
			  }
			  else{
				   i.setRGB(w,h,rgb123);
				   w++;
			  }
			 
			  
			  // 2nd pixel
			  int ar1234[]=i.getData().getPixel(w,h,x1);
			  int zz11=ar1234[0];
			  int zzz11=ar1234[1];
			  //red2
				if(pix2==1){
					if(ar1234[2]%2==1){
						 z11=(byte) ar1234[2];
					}
					else{
						z11=(byte) (ar1234[2]+1);
					}
				}
				else{
					if(ar1234[2]%2==1){
						z11=(byte) (ar1234[2]-1);
					}
					else{
						z11=(byte) ar1234[2];
				}
				}
				  //int rgb1234 = (zz11 << 16 | zzz11 << 8 | z11);
				int rgb1234 = zz11;
				  rgb1234 = (rgb1234 << 8) + zzz11;
				  rgb1234 = (rgb1234 << 8) + z11;
				  if(w==wd){
					  i.setRGB(w, h, rgb1234);
					  w=0;
					  h++;
				  }
				  else{
					  i.setRGB(w,h,rgb1234);
					  w++;
				  }
				  			  				  
				  // 3rd pixel
				  int ar12345[]=i.getData().getPixel(w,h,x2);
				  int zz22=ar12345[0];
				  int zzz22=ar12345[1];
				  //red3
					if(pix3==1){
						if(ar12345[2]%2==1){
							 z22=(byte) ar12345[2];
						}
						else{
							z22=(byte) (ar12345[2]+1);
						}
					}
					else{
						if(ar12345[2]%2==1){
							z22=(byte) (ar12345[2]-1);
						}
						else{
							z22=(byte) ar12345[2];
					}					
					}
					  //int rgb12345 = (zz22 << 16 | zzz22 << 8 | z22);
					int rgb12345 = zz22;
					  rgb12345 = (rgb12345 << 8) + zzz22;
					  rgb12345 = (rgb12345 << 8) + z22;
					  if(w==wd){
						  i.setRGB(w, h, rgb12345);
						  w=0;
						  h++;
					  }
					  else{
						  i.setRGB(w,h,rgb12345);
						  w++;
						   }
						 
					// 4rd pixel
					  int ar123456[]=i.getData().getPixel(w,h,x3);
					  int zz33=ar123456[0];
					  int zzz33=ar123456[1];
					  //red3
						if(pix4==1){
							if(ar123456[2]%2==1){
								 z33=(byte) ar123456[2];
							}
							else{
								z33=(byte) (ar123456[2]+1);
							}
						}
						else{
							if(ar123456[2]%2==1){
								z33=(byte) (ar123456[2]-1);
							}
							else{
								z33=(byte) ar123456[2];
						}					
						}
						  //int rgb123456 = (zz33 << 16 | zzz33 << 8 | z33);
						int rgb123456 = zz33;
						  rgb123456 = (rgb123456 << 8) + zzz33;
						  rgb123456 = (rgb123456 << 8) + z33;
						  if(w==wd){
							  i.setRGB(w, h, rgb123456);
							  w=0;
							  h++;
						  }
						  else{
							  i.setRGB(w,h,rgb123456);
							  w++;
							   }
		    
						// 5rd pixel
						  int ar1234567[]=i.getData().getPixel(w,h,x4);
						  int zz44=ar1234567[0];
						  int zzz44=ar1234567[1];
						  //red3
							if(pix5==1){
								if(ar1234567[2]%2==1){
									 z44=(byte) ar1234567[2];
								}
								else{
									z44=(byte) (ar1234567[2]+1);
								}
							}
							else{
								if(ar1234567[2]%2==1){
									z44=(byte) (ar1234567[2]-1);
								}
								else{
									z44=(byte) ar1234567[2];
							}					
							}
							  //int rgb1234567 = (zz44 << 16 | zzz44 << 8 | z44);
							int rgb1234567 = zz44;
							  rgb1234567 = (rgb1234567 << 8) + zzz44;
							  rgb1234567 = (rgb1234567 << 8) + z44;
							  if(w==wd){
								  i.setRGB(w, h, rgb1234567);
								  w=0;
								  h++;
							  }
							  else{
								  i.setRGB(w,h,rgb1234567);
								  w++;
								   }
							  
							// 6rd pixel
							  int ar12345678[]=i.getData().getPixel(w,h,x5);
							  int zz55=ar12345678[0];
							  int zzz55=ar12345678[1];
							  //red3
								if(pix6==1){
									if(ar12345678[2]%2==1){
										 z55=(byte) ar12345678[2];
									}
									else{
										z55=(byte) (ar12345678[2]+1);
									}
								}
								else{
									if(ar12345678[2]%2==1){
										z55=(byte) (ar12345678[2]-1);
									}
									else{
										z55=(byte) ar12345678[2];
								}					
								}
								  //int rgb12345678 = (zz55 << 16 | zzz55 << 8 | z55);
								int rgb12345678 = zz55;
								  rgb12345678 = (rgb12345678 << 8) + zzz55;
								  rgb12345678 = (rgb12345678 << 8) + z55;
								  if(w==wd){
									  i.setRGB(w, h, rgb12345678);
									  w=0;
									  h++;
								  }
								  else{
									  i.setRGB(w,h,rgb12345678);
									  w++;
									}
		    
								// 7rd pixel
								  int ar123456789[]=i.getData().getPixel(w,h,x6);
								  int zz66=ar123456789[0];
								  int zzz66=ar123456789[1];
								  //red3
									if(pix7==1){
										if(ar123456789[2]%2==1){
											 z66=(byte) ar123456789[2];
										}
										else{
											z66=(byte) (ar123456789[2]+1);
										}
									}
									else{
										if(ar123456789[2]%2==1){
											z66=(byte) (ar123456789[2]-1);
										}
										else{
											z66=(byte) ar123456789[2];
									}					
									}
									  //int rgb123456789 = (zz66 << 16 | zzz66 << 8 | z66);
									int rgb123456789 = zz66;
									  rgb123456789 = (rgb123456789 << 8) + zzz66;
									  rgb123456789 = (rgb123456789 << 8) + z66;
									  if(w==wd){
										  i.setRGB(w, h, rgb123456789);
										  w=0;
										  h++;
									  }
									  else{
										  i.setRGB(w,h,rgb123456789);
										  w++;
										}
		    
		    }
		    
		    
		    File outputfile = new File("C:\\Users\\sai_523591\\Desktop\\workspace11111\\ProjectDay1\\WebContent\\EncryptedImages\\saved.png");
		    ImageIO.write(i,"png",outputfile);
		
	}
		
		
		catch (IOException e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
		}
		return "success1"; 
		
	}
}
